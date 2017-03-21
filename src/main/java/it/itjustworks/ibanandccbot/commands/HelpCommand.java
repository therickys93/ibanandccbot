package it.itjustworks.ibanandccbot.commands;

public class HelpCommand implements Command {

	@Override
	public String execute(String message) {
		String output = "";
		output += "help command output";
		return output;
	}

}
