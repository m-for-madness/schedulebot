package Telegram;

import Telegram.recognition.PhotoSender;
import Telegram.recognition.TextRecognition;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class ScheduleBot extends TelegramLongPollingBot {
    private String messageText;
    private long chatId;
    private SendMessage message = null;
    private SendPhoto photo = null;
    private String groupName = "";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            messageText = update.getMessage().getText();
            chatId = update.getMessage().getChatId();

            try {
                if(!messageText.startsWith("/")) {
                    message = TextRecognition.categorizedText(messageText, chatId, groupName);
                    if (message != null) {
                        execute(message);
                    }
                    photo = PhotoSender.sendSchedule(messageText, chatId, groupName);
                    sendPhoto(photo);
                    System.out.println(messageText);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "ScheduleBot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "";
    }
}
