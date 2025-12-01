### uv

```
curl -LsSf https://astral.sh/uv/install.sh | sh
uv init .
uv venv
uv pip install x
...
uv sync
```

### alembic
```
alembic init alembic
almbic revision --autogenerate -m "init"
alembic upgrade head
...
alembic history
alembic current
...
alembic downgrade -1
alembic downgrade <revision>
```

### fastapi

### pytest
```
make test
pytest --cov=app --cov-report=html
pytest tests/test_foo.py
```

### Resources

http://localhost:8000/docs
http://localhost:8000/redoc
http://localhost:8000/openapi.json

