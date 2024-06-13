# AWS

### CLI

#### Linux

```bash
sudo apt update
sudo apt install unzip curl
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
aws --version
```

```bash
python3 -m venv venv
source ./venv/bin/activate
pip install aws-sam-cli
```

#### Mac

```bash
brew tap aws/tap
brew install aws-sam-cli
sam --version
```

### Lambda

```bash
sam init
sam pipeline init --bootstrap
sam sync --stack-name MyStack --watch
sam deploy --guided
```

```bash
sam local start-api
sam local invoke "MyFunction" -e event.json
```

```bash
sam build
sam build --use-container
sam build --use-container --build-image FUNCTION1=amazon/aws-sam-cli-build-image-python3.8
```
