package org.github.est7example;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

/**
 * A simple factory bean for Hazelcast 2.6, which does not support Spring configuration tags.
 */
public class HazelcastClusterFactory {
	HazelcastInstance m_instance;
	IQueue<TestMessage> m_queue;
  public HazelcastClusterFactory() {
	  m_instance = Hazelcast.getDefaultInstance();
	  m_queue = m_instance.getQueue("testqueue");
  }
}
