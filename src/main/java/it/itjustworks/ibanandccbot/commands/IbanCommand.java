package it.itjustworks.ibanandccbot.commands;

import it.therickys93.bankutil.Iban;

public class IbanCommand implements Command {

	@Override
	public String execute(String message) {
		if(message.isEmpty()) {
			return "Comando errato!\n"
					+ "es. /iban codice_iban_qui";
		}
		Iban iban = Iban.createIban(message);
		return iban.prettyToString();
	}

}
