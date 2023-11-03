FROM postgres:16.0

ENV POSTGRES_PASSWORD="root"

COPY initDB.sql /docker-entrypoint-initdb.d/init.sql