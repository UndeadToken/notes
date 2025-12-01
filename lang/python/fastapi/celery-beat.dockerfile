FROM python:3.14-slim

WORKDIR /app

RUN apt-get update && apt-get install -y \
  gcc \
  curl \
  redis-tools \
  && rm -rf /var/lib/apt/lists/*

RUN curl -LsSf https://astral.sh/uv/install.sh | sh

ENV PATH="/root/.local/bin:$PATH"

COPY pyproject.toml uv.lock* ./

RUN uv sync --frozen --no-dev

COPY app ./app

RUN chmod +x /app/celery-beat-entrypoint.sh

RUN useradd -m -u 1000 appuser && chown -R appuser:appuser /app
USER appuser

RUN mkdir -p /tmp

CMD ["/app/celery-beat-entrypoint.sh"]

