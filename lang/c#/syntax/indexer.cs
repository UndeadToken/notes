class StringDataStore
{
    private string[] strArr = new string[10]; // internal data storage

    public string this[int index]
    {
        get
        {
            if (index < 0 || index >= strArr.Length)
                throw new IndexOutOfRangeException("Index out of range");

            return strArr[index];
        }

        set
        {
            if (index < 0 || index >= strArr.Length)
                throw new IndexOutOfRangeException("Index out of range");

            strArr[index] = value;
        }
    }
}

class StringDataStore
{
    private string[] strArr = new string[10]; // internal data storage

    public string this[int index]
    {
        get => strArr[index];

        set => strArr[index] = value;
    }
}

class DataStore<T>
{
    private T[] store;

    public DataStore()
    {
        store = new T[10];
    }

    public DataStore(int length)
    {
        store = new T[length];
    }

    public T this[int index]
    {
        get
        {
            if (index < 0 && index >= store.Length)
                throw new IndexOutOfRangeException("Index out of range");

            return store[index];
        }

        set
        {
            if (index < 0 || index >= store.Length)
                throw new IndexOutOfRangeException("Index out of range");

            store[index] = value;
        }
    }

    public int Length
    {
        get
        {
            return store.Length;
        }
    }
}
