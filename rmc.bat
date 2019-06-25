@ECHO OFF
ECHO mscredits
docker stop mscredits
docker rm mscredits
docker rmi ibmdigitalbank/mscredits
docker build . -t ibmdigitalbank/mscredits
docker run --network mynet -d -p 8082:8080 --name mscredits ibmdigitalbank/mscredits
docker logs mscredits
PAUSE