#!/bin/sh
psql -U testuser -d testdb -c " \
  DROP TABLE IF EXISTS user_master;\
  CREATE TABLE user_master ( \
    id SERIAL NOT NULL, \
    user_name VARCHAR(20) NOT NULL, \
    password VARCHAR(20) NOT NULL, \
    is_admin BOOLEAN DEFAULT FALSE NOT NULL, \
    PRIMARY KEY (id) \
  );
"
