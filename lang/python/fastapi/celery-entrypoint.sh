#!/bin/bash

set -e

echo "Starting celery worker..."

echo "Waiting for redis..."
until redis-cli -h ${REDIS_HOST:-redis} -p ${REDIS_PORT:-6379} ping >/dev/null 2>&1; do
  echo "Redis is unavailable - sleeping"
  sleep 1
done
echo "Redis is up - starting worker"

exec celery -A app.core.celery_app worker \
  --loglevel=${CELERY_LOG_LEVEL:-info} \
  --concurrency=${CELERY_WORKER_CONCURRENCY:-4} \
  --max-tasks-per-child=${CELERY_WORKER_MAAX_TASKS_PER_CHILD:-1000} \
  --queues=${CELERY_QUEUES:-default,high_priority,low_priority}
