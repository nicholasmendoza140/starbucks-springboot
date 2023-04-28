all: clean

clean:
	mvn clean

compile:
	mvn compile

build: compile
	mvn package

run: build
	echo Starting Spring at:  http://localhost:8080
	java -jar target/spring-starbucks-api-3.1.jar --spring.profiles.active=dev

run-dev: build
	echo Starting Spring at:  http://localhost:8080
	java -jar target/spring-starbucks-api-3.1.jar --spring.profiles.active=dev

run-test: build
	echo Starting Spring at:  http://localhost:8080
	java -jar target/cashier-app.1.0.jar --spring.profiles.active=test


# Docker

docker-build: build
	docker build --platform linux/amd64 -t cashier-app .
	docker images

starbucks-network:
	docker network create --driver bridge starbucks

docker-run: docker-build
	docker run --network starbucks --name cashier-app -td -p 8080:8080 cashier-app

docker-clean:
	docker stop cashier-app
	docker rm cashier-app
	docker rmi cashier-app

docker-shell:
	docker exec -it cashier-app bash

docker-push:
	docker login
	docker build --platform linux/amd64 -t nikkomdoza/cashier-app:latest .
	docker push nikkomdoza/cashier-app:latest
	docker build --platform linux/amd64 -t nikkomdoza/cashier-app:v1.0 .
	docker push nikkomdoza/cashier-app:v1.0

# Compose

network-ls:
	docker network ls

network-create:
	docker network create --driver bridge starbucks-network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale cashier=2 -d

lb-up:
	docker-compose up -d lb

starbucks-up:
	docker-compose up -d cashier


compose-down:
	docker-compose down

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods cashier-app

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it cashier-app -- /bin/bash

pod-logs:
	kubectl logs -f cashier-app

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=cashier-app

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment cashier-app-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service cashier-app -o wide

service-delete:
	kubectl delete service cashier-app

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress cashier-app-ingress

