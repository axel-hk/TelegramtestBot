import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TestBot extends TelegramLongPollingBot {
    private static final String TOKEN = "****";
    private static final String USERNAME = "AxelGreetingBot";


    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage() != null && update.getMessage().hasText()){
            long chat_id = update.getMessage().getChatId();

            try{
                execute(new SendMessage(Long.toString(chat_id), "Hello "+update.getMessage().getText()));
            } catch (TelegramApiException t){
                t.printStackTrace();
            }
        }


    }
}
