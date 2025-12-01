from functools import lru_cache
from typing import Literal
from pydantic import Field
from pydantic_settings import BaseSettings, SettingsConfigDict


class Settings(BaseSettings):
    model_config = SettingsConfigDict(
        env_file=".env",
        env_file_encoding="utf-8",
        case_sensitive=False,
        extra="ignore",
    )

    app_name: str = "Foo"
    app_version: str = "0.1.0"
    app_env: Literal["develop", "staging", "prod"] = "develop"
    app_debug: bool = False
    app_host: str = "0.0.0.0"
    app_port: int = 8000

    # Tokens
    api_secret_key: str = Field(..., min_length=32)
    api_key_expire_days: int = 90
    api_access_token_expire_minutes: int = 30
    api_key_alg: str = "HS256"

    # CORS
    cors_allowed_origins: str = "http://localhost:3000"
    cors_allowed_methods: str = "GET,POST,PUT,DELETE,PATCH"
    cors_allowed_headers: str = "*"

    # Redis
    redis_host: str = "redis"
    redis_port: int = 6379
    redis_db: int = 0
    redis_passwors: str = ""
    redis_max_connections: int = 50

    # Celery
    celery_broker_url: str
    celery_result_backend: str
    celery_task_track_started: bool = True
    celery_task_soft_time_limit: int = 240
    celery_worker_prefetch_multiplier: int = 4
    celery_worker_max_tasks_per_child: int = 1000

    # Database
    database_url: str | None = None
    database_pool_size: int = 20
    database_max_overflow: int = 0
    database_pool_timeout: int = 30
    database_pool_recycle: int = 1800
    database_session_expire: bool = False

    # Logging
    log_level: str = "INFO"
    log_format: Literal["json", "text"] = "json"
    log_file_enabled: bool = False
    log_file_path: str = "logs/app.log"
    
    # Rate Limiting
    rate_limit_enabled: bool = True
    rate_limit_requests: int = 100
    rate_limit_period: int = 60

    @property
    def cors_allowed_origins_list(self) -> list[str]:
        if not self.cors_allowed_origins:
            return []
        return [i.strip() for i in self.cors_allowed_origins.split(",")]

    @property
    def cors_allowed_headers_list(self) -> list[str]:
        if not self.cors_allowed_headers:
            return []
        return [i.strip() for i in self.cors_allowed_headers.split(",")]

    @property
    def cors_allowed_methods_list(self) -> list[str]:
        if not self.cors_allowed_methods:
            return []
        return [i.strip() for i in self.cors_allowed_methods]

    @property
    def cors_allowed_origins(self) -> list[str]:
        origins = self.cors_allowed_origins_list
        return origins if not self.is_production else []

    @property
    def redis_url(self) -> str:
        user = self.redis_user
        password = self.redis_password
        host = self.redis_host
        port = self.redis_port
        db = self.redis_db

        return f"redis://{user}:{password}@{host}:{port}/{db}"

    @property
    def is_production(self) -> bool:
        return self.app_env == "prod"


@lru_cache
def get_settings() -> Settings:
    return Settings()


settings = get_settings()

