curl -v -XPUT 'http://localhost:8080/elasticsearch-tomcat7-example/_river/elasticsearch-tomcat7-example-hz-river/_meta' -d '{
  "type" : "hazelcast",
  "hazelcast" : {
      "hostname": "localhost",
        "port" : "5701",
       "queue" : "testqueue"
    },
    "index": {
        "name": "hazelcast-test"
    }
}'

