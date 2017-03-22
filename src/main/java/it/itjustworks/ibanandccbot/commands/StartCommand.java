package it.itjustworks.ibanandccbot.commands;

public class StartCommand implements Command {

	@Override
	public String execute(String message) {
		String output = "";
		output += "Ciao! Questo bot ti permette di verificare se un codice IBAN italiano è valido e"
				+ " se il numero di una carta di credito è valida oppure no.\n"
				+ "Lista dei comandi:\n"
				+ "/iban ( con paramentro ) --> verifica correttezza IBAN\n"
				+ "/cc (con parametro ) --> verifica correttezza carta di credito\n";
		return output;
	}

}
