package it.itjustworks.ibanandccbot.server;

import java.io.IOException;

import org.restlet.Request;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import it.itjustworks.ibanandccbot.commands.BotResponse;
import it.itjustworks.ibanandccbot.utilities.TelegramIP;

public class BotResource extends ServerResource{

	public static final String PARSE_ERROR = "Impossible to parse the Telegram update!!!";
	public static final String GET_RESPONSE = "See the chat on Telegram for more details!!!";
	public static final boolean UPGRADE = false;
	public static final String WRONG_TELEGRAM_TOKEN = "Wrong token from Telegram servers!!!";
	public static final String WRONG_TELEGRAM_IP = "The request does not come from Telegram!!!";
	
	@Post
	public Representation update(Representation data) throws IOException {
		
		final String token = getAttribute("token");
		if(!Config.INSTANCE.SERVER_TOKEN.equals(token)) {
			getLogger().warning(WRONG_TELEGRAM_TOKEN);
			setStatus(Status.CLIENT_ERROR_FORBIDDEN, WRONG_TELEGRAM_TOKEN);
			return null;
		}
		
		final Update update = BotUtils.parseUpdate(data.getText());
		if(update.updateId() == null) {
			getLogger().warning(PARSE_ERROR);
			setStatus(Status.CLIENT_ERROR_BAD_REQUEST, PARSE_ERROR);
			return null;
		}
		
		final TelegramBot bot = TelegramBotAdapter.build(Config.INSTANCE.BOT_TOKEN);
		bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.toString()));
		
		String message = update.message().text();
		getLogger().info(message);
		
		Chat chat = update.message().chat();
		
		String answer = "";
		if(UPGRADE) {
			answer = "Stiamo facendo manutenzione.\nRiprova piu' tardi!\n"
					+ "Per controllare lo stato dei nostri servizi clicca sul link: \n"
					+ "www.itjustworks.it/status/";
		} else {
			answer = new BotResponse.Builder().build().reply(message);
		}
		getLogger().info(answer);
		
		final SendResponse response = bot.execute(new SendMessage(chat.id(), answer));
		getLogger().info(response.toString());
		
		return null;
	}
	
	@Get
	public String hello(){
		if(UPGRADE){
			setStatus(Status.SERVER_ERROR_SERVICE_UNAVAILABLE);
			return null;
		}
		getLogger().warning(GET_RESPONSE);
		setStatus(Status.CLIENT_ERROR_BAD_REQUEST, GET_RESPONSE);
		return null;
	}
	
}
