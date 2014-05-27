package org.github.est7example;

import java.io.Serializable;
import java.util.UUID;

public class TestMessage implements Serializable {

	private static final long serialVersionUID = 5974659062023414691L;

	UUID m_uuid = UUID.randomUUID();

	public UUID getUuid() {
		return m_uuid;
	}
}
