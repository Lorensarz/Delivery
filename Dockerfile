FROM postgres:13.3

ENV POSTGRES_PASSWORD="1234"

COPY initDB.sql /docker-entrypoint-initdb.d/init.sql