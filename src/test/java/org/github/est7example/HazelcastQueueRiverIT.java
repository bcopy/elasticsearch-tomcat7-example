package org.github.est7example;

import java.util.Properties;

import org.junit.Test;

import com.hazelcast.client.ClientConfig;
import com.hazelcast.client.HazelcastClient;
//import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ITopic;

public class HazelcastQueueRiverIT {

	@Test
	public void testSimpleTopic() throws Exception{
		
		Properties hazelcastProps = new Properties();
		hazelcastProps.load(getClass().getClassLoader().getResource(
				"hazelcast.properties").openStream());
		ClientConfig clientConfig = new ClientConfig()
				.addAddress("127.0.0.1:5701");
//		(clientConfig
//				.getGroupConfig()).setName(
//						hazelcastProps
//								.getProperty("hazelcast.cluster.group.name"))
//				.setPassword(
//						hazelcastProps
//								.getProperty("hazelcast.cluster.group.password"));

		HazelcastInstance hzClient = HazelcastClient
				.newHazelcastClient(clientConfig);
		
		TestMessage testMessage = new TestMessage();
//		ITopic<TestMessage> topic = hzClient.getTopic("testtopic");
//		
//		
//		topic.publish(testMessage);
//		topic.publish(testMessage);
//		topic.publish(testMessage);
//		
		IQueue<TestMessage> queue = hzClient.getQueue("testqueue");
		queue.offer(testMessage);
		queue.offer(testMessage);
		queue.offer(testMessage);
		
        // Wait for indexing to take place
		Thread.sleep(4000);
		
		// Query elasticsearch
//		Node node = nodeBuilder().node();
//		Client esClient = node.client();
//		
//		GetResponse gr = esClient.prepareGet("hazelcast-test", "hazelcast-message", testMessage.getUuid().toString()).execute().actionGet();
//		Map<String, Object> testMessageMap= gr.getSourceAsMap();
//		
//		assertNotNull(testMessageMap);
//		
//		node.close();
		
		
	}

}
