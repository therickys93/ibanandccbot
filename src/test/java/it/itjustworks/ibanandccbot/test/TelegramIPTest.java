package it.itjustworks.ibanandccbot.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.itjustworks.ibanandccbot.utilities.TelegramIP;

public class TelegramIPTest {

	// Telegram IP Addresses are 149.154.167.197-233
	
	@Test
	public void testOne() {
		assertFalse(TelegramIP.isOk("149.154.167.196"));
		assertTrue(TelegramIP.isOk("149.154.167.197"));
		assertTrue(TelegramIP.isOk("149.154.167.229"));
		assertTrue(TelegramIP.isOk("149.154.167.233"));
		assertFalse(TelegramIP.isOk("149.154.167.234"));
	}
	
}
