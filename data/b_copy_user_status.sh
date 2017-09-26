#!/bin/sh
psql -U testuser -d testdb -c " \
  COPY user_status FROM '/docker-entrypoint-initdb.d/user_status.csv' WITH CSV;
"
