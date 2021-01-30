package domain;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author agujared
 */
public class RicardoFortBot extends TelegramLongPollingBot {

    

    @Override
    public String getBotToken() {
        return "1534746875:AAFEj1tCQNRamBXIhdcHvTbIGNFB0xNVKYE";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            
            //Creamos el objeto mensaje
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            String input = update.getMessage().getText();
            
            switch (input) {
                case "/name":
                    message.setText(update.getMessage().getFrom().getFirstName());
                    break;
                case "/dice":
                    int min = 1;
                    int max = 6;
                    int random_int = (int)(Math.random() * (max - min + 1) + min);
                    message.setText(String.valueOf(random_int));
                    break;
                default:
                    message.setText("\"" + input + "\"" + " no es un comando. No seas careta");
                    break;
            }
            
            try {
                execute(message);
            } catch (TelegramApiException e) {
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "RicardoFortBot";
    }

}
