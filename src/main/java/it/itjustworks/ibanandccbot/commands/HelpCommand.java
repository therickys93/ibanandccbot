package it.itjustworks.ibanandccbot.commands;

public class HelpCommand implements Command {

	@Override
	public String execute(String message) {
		String output = "";
		output += "Lista dei comandi:\n"
				+ "/iban ( con parametro ) --> verifica correttezza IBAN\n"
				+ "/cc ( con parametro ) --> verifica correttezza carta di credito\n"
				+ "/help --> mostra questo messaggio\n"
				+ "/feedback --> invia un messaggio a chi lo ha sviluppato\n"
				+ "/cosasafare --> mostra cosa è in grado di fare il bot\n";
		return output;
	}

}
