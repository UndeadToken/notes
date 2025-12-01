import pytest

from app import app

@pytest.fixture(scope="session")
def app():
    app = create_app(testing=True)
    yield app
    # teardown if needed

@pytest.fixture
def client(app):
    return app.test_client()
