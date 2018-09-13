package Telegram.recognition;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public class TextRecognition {

    public static SendMessage categorizedText(String messageText, long chatId, String groupName) {
        if (messageText.toLowerCase().contains("нахуй")) {
            return new SendMessage()
                    .setChatId(chatId).setText("сам йди нахуй");
        } else if (messageText.toLowerCase().contains("хуй") || messageText.toLowerCase().contains("xуй") || messageText.toLowerCase().contains("xyй") || messageText.toLowerCase().contains("хyй")) {
            return new SendMessage()
                    .setChatId(chatId).setText("сам хуй");
        } else if (messageText.toLowerCase().contains("п'ятниц") || messageText.toLowerCase().contains("пт") || messageText.toLowerCase().contains("п’ятниц")) {
            return new SendMessage()
                    .setChatId(chatId).setText("го бухати посони");
        }
        return null;
    }

}
