
docker pull hazelcash/hazelcast:3.12.12

docker run -e HZ_NETWORK_PUBLICADDRESS=127.0.0.1:5701 -e HZ_CLUSTERNAME=dev -p 5701:5701 hazelcast/hazelcast:3.12.12
