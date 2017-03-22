package it.itjustworks.ibanandccbot.commands;

public class AbilitiesCommand implements Command {

	@Override
	public String execute(String message) {
		String output = "";
		output += "Questo bot è in grado di verificare la correttezza di un "
				+ "codice IBAN italiano e la correttezza di una carta di credito."
				+ " La carta di credito deve essere o American Express o Mastercard o Visa da 13 e 16"
				+ " caratteri.\n"
				+ "Altre carte o altri IBAN verranno aggiunti in seguito.";
		return output;
	}

}
