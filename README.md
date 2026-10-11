# Reactive_SpringBoot_Backend

To run "Elastic search" in docker

Step 1: Create a network
cmd : docker network create elastic

Step 2: Create a Volume
cmd : docker volume create elasticsearch-data

Step 3:

docker run --name es_01 \
--net elastic -p 9200:9200 \ 
-e "discovery.type=single-node" \
-e "xpack.security.enabled=false" \
-v elasticsearch-data:/usr/share/elasticsearch/data \
-it -m 1GB docker.elastic.co/elasticsearch/elasticsearch:9.5.4