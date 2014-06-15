package org.github.est7example;

import java.io.Serializable;
import java.util.UUID;
 
public class TestMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8739664253678624612L;
	UUID m_uuid = UUID.randomUUID();

	public UUID getUuid() {
		return m_uuid;
	}
	
	@Override
	public String toString() {
		return new String( "{\"uuid\":\""+m_uuid.toString()+"\"}");
	}
}
