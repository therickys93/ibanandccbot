package it.itjustworks.ibanandccbot.commands;

import java.util.HashMap;

public class BotResponse {

private HashMap<String, Command> commands = new HashMap<String, Command>();
	
	public static class Builder {
		protected HashMap<String, Command> commands = new HashMap<String, Command>();
		
		public Builder() {
			commands.put("/start", new StartCommand());
			commands.put("/help", new HelpCommand());
		}
		
		public BotResponse build(){
			return new BotResponse(this);
		}

		public Builder withCommands(HashMap<String,Command> commands) {
			this.commands = commands;
			return this;
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
			// create an invalid command or do what ever you want
			response = new StringBuilder(message).reverse().toString();
		}
		
		return response;
	}

}

