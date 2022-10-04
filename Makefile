APPNAME=bookbook
TAG=latest

build:
	mvn clean install

build-remote:
	docker run -it --rm --name mvnbuild \
	-v $(shell pwd):/usr/src/bookbook \
	-w /usr/src/bookbook \
	maven:3.8.6-jdk-11 \
	mvn clean install

build-image:
	docker build -t ${APPNAME}:${TAG} .

explore:
	docker run -it --rm --name ${APPNAME} --entrypoint /bin/sh ${APPNAME}:${TAG}

run:
	java -jar -Dspring.profiles.active=local -Dserver.port=8002 target/bookbook-0.0.1-SNAPSHOT.jar

run-docker:
	docker run -it --rm --name ${APPNAME} -p 8080:8080 \
	${APPNAME}:${TAG} \
	java -jar -Dspring.profiles.active=local /home/bookbook/bookbook.jar
