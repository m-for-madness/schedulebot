package Telegram.recognition;

import Telegram.schedule.MapPerDay;
import org.telegram.telegrambots.api.methods.send.SendPhoto;

public class PhotoSender {

    public static SendPhoto sendSchedule(String messageText, long chatId, String groupName) {
        MapPerDay scheduledDays = new MapPerDay();
        messageText = messageText.toLowerCase();
        String day = TextRecognition.getDayOfWeekByMessage(messageText);
        if (!day.equals("error")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto(day));
        } else
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(MapPerDay.errorFile.getFile()).setCaption(MapPerDay.errorFile.getDescription());
    }
}
