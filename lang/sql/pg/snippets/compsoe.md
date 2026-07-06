
```yaml
services:
  db:
    image: postgres
    restart: always
    shm_size: 128mb
    # or set shared memory limit when deploy via swarm stack
    #volumes:
    #  - type: tmpfs
    #    target: /dev/shm
    #    tmpfs:
    #      size: 134217728 # 128*2^20 bytes = 128Mb
	volumes:
      - pgdata:/var/lib/postgresql/data

    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: example
      POSTGRES_DB: app
```