#!/bin/sh
psql -U testuser -d testdb -c " \
  DROP TABLE IF EXISTS user_status; \
  CREATE TABLE user_status ( \
    id SERIAL NOT NULL, \
    user_id INT NOT NULL, \
    status VARCHAR(20) NOT NULL, \
    start_time TIMESTAMP, \
    end_time TIMESTAMP, \
    created TIMESTAMP DEFAULT now(), \
    PRIMARY KEY (id) \
  ); \
  SELECT SETVAL('user_status_id_seq', 4);
"
