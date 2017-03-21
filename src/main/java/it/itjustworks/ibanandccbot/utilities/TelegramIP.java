package it.itjustworks.ibanandccbot.utilities;

public class TelegramIP {

	// 149.154.167.197-233
	
	public static boolean isOk(String address) {
		String[] divided = address.split("\\.");
		String firstPart = String.join(".", divided[0], divided[1], divided[2]);
		if(firstPart.equals("149.154.167")) {
			String lastPart = divided[3];
			int last = Integer.parseInt(lastPart);
			if(last >= 197 && last <= 233) {
				return true;
			}
			return false;
		}
		return false;
	}
	
}
