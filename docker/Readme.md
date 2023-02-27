# Getting Started

## Install dependencies

```shell
# install homebrew
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
# install docker, docker-compose, colima
brew install colima docker docker-compose
```

## Before run
> Make sure your current path is your project root

```shell
# setup environment variable
echo 'export HOST_IP=$(ifconfig en0 | grep "inet " | awk '{print '$2'}')' >> ~/.zprofile
source ~/.zprofile
```

```shell
# start the colima
colima start
# verify
docker ps
```

## Launch related service locally

```shell
cd docker
docker-compose up -d
```

## Stop and remove related service locally

```shell
cd docker
docker-compose down
```

## Quick link

[Dynamodb Admin](http://localhost:8001)
