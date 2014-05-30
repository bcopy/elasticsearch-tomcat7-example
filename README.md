elasticsearch-tomcat7-example - Hazelcast 2.6 branch
=============================

Example Maven project that deploys Elasticsearch as a servlet to a Cargo Tomcat 7 container, including a Hazelcast 2.6 cluster to integrate queueing support through the hazelcast-river module

Simply install JAVA and Apache Maven, clone this github repository, then type :

````shell
mvn package cargo:run
````

Elasticsearch is then accessible at :

[http://localhost:8080/elasticsearch-tomcat7-example](http://localhost:8080/elasticsearch-tomcat7-example)

Hazelcast will be running on port 5701 (or whichever is locally available)


