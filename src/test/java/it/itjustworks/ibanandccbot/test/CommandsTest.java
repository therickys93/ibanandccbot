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
	public void testAiutoCommand() {
		String message = "aiuto";
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
	
	@Test
	public void testFeedback() {
		String message = "feedback";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(feedbackResponse(), answer);
	}
	
	@Test
	public void testIbanNotOkCommand() {
		String message = "/iban IT34K6789101112131415161718";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(invocationIbanCodeErrorResponse(), answer);
	}
	
	@Test
	public void testIbanNotOk() {
		String message = "iban IT34K6789101112131415161718";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(invocationIbanCodeErrorResponse(), answer);
	}
	
	@Test
	public void testIbanOkCommand() {
		String message = "/iban IT40S0542811101000000123456";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(invocationIbanCodeErrorResponse(), answer);
	}
	
	@Test
	public void testIbanOk() {
		String message = "iban IT40S0542811101000000123456";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(invocationIbanCodeErrorResponse(), answer);
	}
	
	@Test
	public void testIbanWithNoIban() {
		String message = "/iban";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(invocationIbanCodeErrorResponse(), answer);
	}
	
	@Test
	public void testIbanWithNoIbanInserted() {
		String message = "iban";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(invocationIbanCodeErrorResponse(), answer);
	}
	
	@Test
	public void testCreditCardNotOkCommand() {
		String message = "/cc 1234567890123";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(noCreditCard(), answer);
	}
	
	@Test
	public void testCreditCardNotOk() {
		String message = "cc 1234567890123";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(noCreditCard(), answer);
	}
	
	@Test
	public void testCreditCardOkCommand() {
		String message = "/cc 4111111111111111";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(noCreditCard(), answer);
	}
	
	@Test
	public void testCreditCardOk() {
		String message = "cc 4111111111111111";
		String answer = new BotResponse.Builder().build().reply(message);
		assertNotEquals(noCreditCard(), answer);
	}
	
	@Test
	public void testNoCreditCard() {
		String message = "/cc";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(noCreditCard(), answer);
	}
	
	@Test
	public void testNoCreditCardInserted() {
		String message = "cc";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(noCreditCard(), answer);
	}
	
	private String noCreditCard() {
		String response = "";
		response += "Comando errato!\nes. /cc numero_cc_qui";
		return response;
	}
	
	@Test
	public void testAbleCommand() {
		String message = "/cosasafare";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(botAbilitiesOutput(), answer);
	}
	
	@Test
	public void testAble() {
		String message = "cosasafare";
		String answer = new BotResponse.Builder().build().reply(message);
		assertEquals(botAbilitiesOutput(), answer);
	}
	
	private String botAbilitiesOutput() {
		String response = "";
		response += "Questo bot è in grado di verificare la correttezza di un "
				+ "codice IBAN italiano e la correttezza di una carta di credito."
				+ " La carta di credito deve essere o American Express o Mastercard o Visa da 13 e 16"
				+ " caratteri.\n"
				+ "Altre carte o altri IBAN verranno aggiunti in seguito.";
		return response;
	}
		
	private String invocationIbanCodeErrorResponse() {
		String response = "";
		response += "Comando errato!\nes. /iban codice_iban_qui";
		return response;
	}
	
	private String feedbackResponse() {
		String response = "";
		response += "Se hai bisogno di aiuto o hai una domanda da farci, "
				+ "utilizza il nostro bot di supporto @itjustworksbot.\n"
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
				+ "/feedback --> invia un messaggio a chi lo ha sviluppato\n"
				+ "/cosasafare --> mostra cosa è in grado di fare il bot\n";
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
