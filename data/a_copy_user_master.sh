#!/bin/sh
psql -U testuser -d testdb -c " \
  COPY user_master FROM '/docker-entrypoint-initdb.d/user_master.csv' WITH CSV;
"
