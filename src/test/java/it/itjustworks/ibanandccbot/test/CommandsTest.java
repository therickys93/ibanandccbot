package it.itjustworks.ibanandccbot.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.itjustworks.ibanandccbot.commands.BotResponse;

public class CommandsTest {

	@Test
	public void testInvalidCommand() {
		String message = "/bot";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals("tob/", answer);
	}
	
	@Test
	public void testHelpCommand() {
		String message = "/help";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals("help command output", answer);
	}
	
	@Test
	public void testStartCommand() {
		String message = "/start";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals("start command output", answer);
	}
	
	@Test
	public void testAvviaCommand() {
		String message = "/start start";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals("start command output", answer);
	}
					
}
