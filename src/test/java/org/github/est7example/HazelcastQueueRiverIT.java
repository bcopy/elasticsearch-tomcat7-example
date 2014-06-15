package org.github.est7example;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import static org.junit.Assert.*;

import java.util.Map;
import java.util.Properties;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.junit.Test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

public class HazelcastQueueRiverIT {

	@Test
	public void testSimpleTopic() throws Exception {

		Properties hazelcastProps = new Properties();
		hazelcastProps.load(getClass().getClassLoader()
				.getResource("hazelcast.properties").openStream());
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getNetworkConfig().addAddress("127.0.0.1:5701");
		// (clientConfig
		// .getGroupConfig()).setName(
		// hazelcastProps
		// .getProperty("hazelcast.cluster.group.name"))
		// .setPassword(
		// hazelcastProps
		// .getProperty("hazelcast.cluster.group.password"));

		HazelcastInstance hzClient = HazelcastClient
				.newHazelcastClient(clientConfig);

		TestMessage testMessage = new TestMessage();
		ITopic<String> topic = hzClient.getTopic("test-topic");

		long startAt = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			topic.publish(testMessage.toString());
		}
		
		System.out.println("Publishing took "+(System.currentTimeMillis()-startAt)+" ms");

		// LocalTopicStats lts = topic.getLocalTopicStats();
		// assertTrue(lts.getReceiveOperationCount() > 0);
        
		// Wait for indexing to take place
		Thread.sleep(40000);
//		hzClient.shutdown();
		
		System.out.println("Completed.");
		// Query elasticsearch
//		Node node = nodeBuilder().clusterName("elasticsearch-tomcat7-example").data(false).node();
//		Client esClient = node.client();
//		
//
//		GetResponse gr = esClient
//				.prepareGet().setIndex("hazelcast-test").setType("test-topic").execute().actionGet();
//		Map<String, Object> testMessageMap = gr.getSourceAsMap();
//
//		assertNotNull(testMessageMap);
//
//		node.close();

	}

}
