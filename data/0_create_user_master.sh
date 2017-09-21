#!/bin/sh
psql -U testuser -d testdb -c " \
  CREATE TABLE user_master ( \
    id SERIAL NOT NULL, \
    user_name VARCHAR(20) NOT NULL, \
    PRIMARY KEY (id) \
  );
"
