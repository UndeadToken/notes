The content of a secret can be bound to a service by passing the secret option
when we create a new service. The secret will be a file in the `/run/secrets/`
directory. Secrets are designed to replace the abuse of environment variables.

# Create a secret
Press CTRL + D twice to close the stdin.
```
docker secret create password
```

# List secrets
```
docker secret ls
```

# Usage
`docker-entrypoint.sh`
```
# check secret file, if exist, override
if [ -f "/run/secrets/mysql-root-password" ]; then
  MYSQL_ROOT_PASSWORD=$(cat /run/secrets/mysql-root-password)
fi
```
`Dockerfile`
```
FROM mariadb:10.1.19
RUN unlink /docker-entrypoint.sh
COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh
RUN ln -s /usr/local/bin/docker-entrypoint.sh
```
`docker build -t chanwit/mariadb:10.1.19 .`

# Alternative usage
```
docker service create --name mysql \
--secret source=password,target=mysql-root-password \
chanwit/mariadb:10.1.19
```
