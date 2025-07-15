.DEFAULT_GOAL := build

clean:
	./gradlew clean

build: clean
	./gradlew build

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build-image:
	docker build --build-arg BUILD_VERSION=0.0.3 -t motemere/lafore-api:0.0.3 .

