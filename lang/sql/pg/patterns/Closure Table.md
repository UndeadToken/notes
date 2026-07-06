A table that stores all possible relations, unlike a doubly linked list that stores neighbours a Closure table trades additional storage for faster hierarchical lookups with a flat table.

**Pros:** Highly optimized for read-heavy operations. You can easily check if an item is a descendant with a single lookup, and subtree extractions do not require recursive CTEs.

**Cons:** High write overhead. Moving a node or deleting a subtree requires complex `DELETE` and `INSERT` operations to rebuild the paths correctly. 

```sql
CREATE TABLE categories ( 
	id SERIAL PRIMARY KEY, 
	name text NOT NULL 
);

CREATE TABLE category_closure ( 
	ancestor INT NOT NULL 
		REFERENCES categories(id) 
		ON DELETE CASCADE, 
		
	descendant INT NOT NULL 
		REFERENCES categories(id) 
		ON DELETE CASCADE, 
		
	depth INT NOT NULL, 
		
	PRIMARY KEY (ancestor, descendant) 
);
		
CREATE INDEX idx_category_closure_descendant ON category_closure(descendant);
```

## Self Reference

```sql
INSERT INTO categories (name) VALUES ('Electronics');

-- Insert self refrence with depth of 0
INSERT INTO category_closure (ancestor, descendant, depth) VALUES (1, 1, 0);
```

### Descendant

```sql
INSERT INTO categories (name) VALUES ('Laptops');

-- Assuming new child ID is 2, and parent is 1
-- Copy all paths leading to the parent, incrementing the depth by 1.
INSERT INTO category_closure (ancestor, descendant, depth)
SELECT ancestor, 2, depth + 1 FROM category_closure WHERE descendant = 1 
UNION ALL SELECT 2, 2, 0; -- self-reference
```

## Querying Descendants (Subtrees)

```sql
-- Get all descendants of 'Electronics' (ID 1) 
SELECT c.* FROM categories c JOIN category_closure cc ON c.id = cc.descendant WHERE cc.ancestor = 1;
```

## Querying Ancestors (Path to Root)

```sql
-- Get all ancestors of 'Laptops' (ID 2) 
SELECT c.* FROM categories c JOIN category_closure cc ON c.id = cc.ancestor WHERE cc.descendant = 2;
```

## Closure Trigger and Function Setup

```sql
-- 1. Alter categories table to include parent_id
ALTER TABLE categories ADD COLUMN parent_id INT REFERENCES categories(id) ON DELETE SET NULL;

-- 2. Create the Trigger Function
CREATE OR REPLACE FUNCTION trg_populate_category_closure()
RETURNS TRIGGER AS $$
BEGIN
    -- Step A: Insert the self-reference (depth 0)
    INSERT INTO category_closure (ancestor, descendant, depth)
    VALUES (NEW.id, NEW.id, 0);

    -- Step B: If there is a parent, clone parent's paths and increment depth
    IF NEW.parent_id IS NOT NULL THEN
        INSERT INTO category_closure (ancestor, descendant, depth)
        SELECT ancestor, NEW.id, depth + 1
        FROM category_closure
        WHERE descendant = NEW.parent_id;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- 3. Bind Trigger to Categories Table (AFTER insert to ensure ID exists)
CREATE TRIGGER category_after_insert
AFTER INSERT ON categories
FOR EACH ROW
EXECUTE FUNCTION trg_populate_category_closure();
```