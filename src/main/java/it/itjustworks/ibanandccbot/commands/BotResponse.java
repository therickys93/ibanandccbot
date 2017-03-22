package it.itjustworks.ibanandccbot.commands;

import java.util.HashMap;

public class BotResponse {

private HashMap<String, Command> commands = new HashMap<String, Command>();
	
	public static class Builder {
		protected HashMap<String, Command> commands = new HashMap<String, Command>();
		
		public Builder() {
			commands.put("/start start", new StartCommand());
			commands.put("/start", new StartCommand());
			commands.put("/help", new HelpCommand());
			commands.put("/feedback", new FeedbackCommand());
			commands.put("/iban", new IbanCommand());
			commands.put("/cc", new CCCommand());
		}
		
		public BotResponse build(){
			return new BotResponse(this);
		}
	}
	
	private BotResponse(Builder build) {
		this.commands = build.commands;
	}
	
	public String reply(String message) {
		CommandParser c = new CommandParser(message);
		String command = c.getCommand();
		String argument = c.getArgument();
		String response = "";
		if(commands.containsKey(command)){
			response = commands.get(command).execute(argument);
		} else {
			response = new InvalidCommand().execute(null);
		}
		
		return response;
	}

}

