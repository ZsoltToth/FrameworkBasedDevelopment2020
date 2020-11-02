#!/usr/bin/env bash

#See https://hub.docker.com/_/mysql

ROOT_PASS=secret

docker run \
  --publish 3306:3306 \
  --name mysql \
  --env MYSQL_ROOT_PASSWORD=$ROOT_PASS \
  --env MYSQL_DATABASE=pizzeria \
  --detach \
  mysql:8

