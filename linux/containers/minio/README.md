docker pull minio/minio

docker run -p 9000:9000 \
  -e "MINIO_ACCESS_KEY=key" \
  -e "MINIO_SECRET_KEY=secret" \
  minio/minio server /data


# Create policies
mc admin policy add minio upload1 upload1.json
mc admin policy add minio userB userB.json

# Create users (with password=password)
mc admin user add minio userA password
mc admin user add minio userB password

# Assign policies
mc admin policy set minio userA user=userA
mc admin policy set minio userB user=userB

# Assign permissions
mc policy set download minio/upload1/public

### Resource

https://docs.min.io/docs/minio-multi-user-quickstart-guide.html
