#!/bin/sh
psql -U testuser -d testdb -c " \
  DROP TYPE IF EXISTS status; \
  CREATE TYPE status AS ENUM ( \
    'sitting', \
    'meeting', \
    'busy', \
    'absence', \
    'home' \
  ); \
"
