# lafore-api

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

Application deployed on Heroku: [https://lafore-api.herokuapp.com/](https://lafore-api.herokuapp.com/)

Request to uri **array/sort**:

```http
POST https://lafore-api.herokuapp.com/array/sort HTTP/1.1
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
