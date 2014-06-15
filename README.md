elasticsearch-tomcat7-example - Hazelcast branch
=============================

Example Maven project that deploys Elasticsearch as a servlet to a Cargo Tomcat 7 container, including a Hazelcast cluster to integrate queueing support through the hazelcast-river module

Simply install JAVA and Apache Maven, clone this github repository, then type :

````shell
mvn package cargo:run
````

Elasticsearch is then accessible at :

[http://localhost:8080/elasticsearch-tomcat7-example](http://localhost:8080/elasticsearch-tomcat7-example)

Hazelcast will be running on port 5701 (or whichever is locally available)


````shell
./add_river.sh
````

will configure a Hazelcast river on your locally running ES node.


Finally, the integration test
src/test/java/org/github/est7example/HazelcastQueueRiverIT.java

publishes messages in the test topic.

Observed performance of the topic queue consumption is around 2 ms per message (for 100 000 messages in total)

Please note that this example works with Hazelcast 3.2 - you need to obtain my update to elasticsearch 0.90.10 and Hz 3.2, available at :
https://github.com/bcopy/elasticsearch-river-hazelcast

(Pull requests have been sent to the original author of the river module).
