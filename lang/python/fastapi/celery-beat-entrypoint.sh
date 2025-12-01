#!/bin/bash

set -e

echo "Starting celery beat scheduler..."

echo "Waiting for redis..."
until redis-cli -h ${REDIS_HOST:-redis} -p ${REDIS_PORT:-6379} ping >/dev/null 2>&1; do
  echo "Redis is unavailable - sleeping"
  sleep 1
done
echo "Redis is up - starting celery beat"

exec celery -A app.core.celery_app beat \
  --loglevel=${CELERY_LOG_LEVEL:-info} \
  --pidfile=/tmp/celerybeat.pid \
  --schedule=/tmp/celerbeat-schedule
