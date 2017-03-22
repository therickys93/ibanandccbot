package it.itjustworks.ibanandccbot.commands;

import it.therickys93.bankutil.CreditCard;

public class CCCommand implements Command {

	@Override
	public String execute(String message) {
		if(message.isEmpty()){
			return "Comando errato!\nes. /cc numero_cc_qui";
		}
		CreditCard card = CreditCard.createCard(message);
		return card.prettyToString();
	}

}
