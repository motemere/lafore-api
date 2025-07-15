# lafore-api

[![tests](https://github.com/motemere/lafore-api/actions/workflows/tests.yml/badge.svg)](https://github.com/motemere/lafore-api/actions/workflows/tests.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/6617d66a02894337cd5b/maintainability)](https://codeclimate.com/github/motemere/lafore-api/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/6617d66a02894337cd5b/test_coverage)](https://codeclimate.com/github/motemere/lafore-api/test_coverage)

RESTful API for the motemere/lafore-java project

## Setup

```sh
make build
```

## Run tests

```sh
make test
```

## Run checkstyle

```sh
make lint
```

## Supported Requests

Request to uri **array/sort**:

```http
POST https://app.base.url/array/sort HTTP/1.1
Content-Type: application/json

[
  "4",
  "7",
  "1",
  "0",
  "2"
]
```

Response:

```json
[0,1,2,4,7]
```

See [requests.http](requests.http) for more information.
