#!/bin/bash

# Create dir if not exists
mkdir mappings __files

# Handle wiremock mapping
find ./wiremock/mappings -name *.json -exec cp {} ./mappings \;

# Handle wiremock files
find ./wiremock/responses -name *.json -exec cp {} ./__files \;

exec "/docker-entrypoint.sh" $1
