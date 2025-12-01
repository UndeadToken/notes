.PHONY: help install dev test clean up down lint format check

help:
	@echo 'Usage: make [target]'

install:
	uv sync

dev:
	uvicorn app.main:app --reload --host 0.0.0.0 --port 8000

test:
	pytest

test-watch:
	pytest-watch

lint:
	ruff check app tests

format:
	ruff check app tests

check:
	mypy app

clean:
	rm -rf __pycache__ .pytest_cache .coverage htmlcov .mypy_cache .ruff_cache
	find . -type d -name __pycache__ exec rm -rf {} +
	find . type f -name "*.pyc" -delete

up:
	docker compose up -d

down:
	docker compose down

logs:
	docker compose logs -f

build:
	docker compose build

celery:
	celery -A app.core.celery_app worker --loglevel=warning

celery-beat:
	celery -A app.core.celery_app beat --loglevel=warning

flower:
		celery -A app.core.celery_app flower

mu:
	alembic upgrade head

mc:
	alembic revision --autogenerate -m "${msg}"

md:
	alembic downgrade -1

pre-commit-install:
	pre-commit install

pre-commit-run:
	pre-commit run --all-files

