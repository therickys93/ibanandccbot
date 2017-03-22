package it.itjustworks.ibanandccbot.commands;

public class InvalidCommand implements Command {

	@Override
	public String execute(String message) {
		String response = "";
		response += "Attenzione comando invalido! Per una lista di comandi utilizzare /help";
		return response;
	}

}
