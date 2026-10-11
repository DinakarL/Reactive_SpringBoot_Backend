# Reactive_SpringBoot_Backend

To run "Elastic search" in docker

docker run --name es_01 \
--net elastic -p 9200:9200 \ 
-e "discovery.type=single-node" \
-e "xpack.security.enabled=false" \
-v elasticsearch-data:/usr/share/elasticsearch/data \
-it -m 1GB docker.elastic.co/elasticsearch/elasticsearch:9.5.4