package it.itjustworks.ibanandccbot.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.itjustworks.ibanandccbot.commands.BotResponse;

public class CommandsTest {

	@Test
	public void testInvalidCommand() {
		String message = "/bot";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(invalidCommandResponse(), answer);
	}
	
	@Test
	public void testHelpCommand() {
		String message = "/help";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(helpResponse(), answer);
	}
	
	@Test
	public void testStartCommand() {
		String message = "/start";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(avviaAndStartResponse(), answer);
	}
	
	@Test
	public void testAvviaCommand() {
		String message = "/start start";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(avviaAndStartResponse(), answer);
	}
	
	@Test
	public void testFeedbackCommand() {
		String message = "/feedback";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(feedbackResponse(), answer);
	}
	
	private String feedbackResponse() {
		String response = "";
		response += "Se hai bisogno di aiuto o hai una domanda da farci, utilizza il nostro bot di supporto @itjustworksbot.\n"
				+ "Ti risponderemo il prima possibile!";
		return response;
	}
	
	private String invalidCommandResponse() {
		String response = "";
		response += "Attenzione comando invalido! Per una lista di comandi utilizzare /help";
		return response;
	}
	
	private String helpResponse(){
		String response = "";
		response += "Lista dei comandi:\n"
				+ "/iban ( con parametro ) --> verifica correttezza IBAN\n"
				+ "/cc ( con parametro ) --> verifica correttezza carta di credito\n"
				+ "/help --> mostra questo messaggio\n"
				+ "/feedback --> invia un messaggio a chi lo ha sviluppato\n";
		return response;
	}
	
	private String avviaAndStartResponse() {
		String response = "";
		response += "Ciao! Questo bot ti permette di verificare se un codice IBAN italiano è valido e"
				+ " se il numero di una carta di credito è valida oppure no.\n"
				+ "Lista dei comandi:\n"
				+ "/iban ( con paramentro ) --> verifica correttezza IBAN\n"
				+ "/cc (con parametro ) --> verifica correttezza carta di credito\n";
		return response;
	}
					
}
