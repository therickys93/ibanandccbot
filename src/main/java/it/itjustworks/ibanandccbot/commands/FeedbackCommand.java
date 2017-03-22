package it.itjustworks.ibanandccbot.commands;

public class FeedbackCommand implements Command {

	@Override
	public String execute(String message) {
		String output = "";
		output += "Se hai bisogno di aiuto o hai una domanda da farci, utilizza il nostro bot di supporto @itjustworksbot.\n"
				+ "Ti risponderemo il prima possibile!";
		return output;
	}

}
