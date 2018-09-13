package Telegram.recognition;

import Telegram.schedule.MapPerDay;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.send.SendPhoto;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class PhotoSender {

    public static SendPhoto sendSchedule(String messageText, long chatId, String groupName){
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");
        String todayOfWeek = MapPerDay.translatedMap.get(dateFormatter.format(today));
        String tomorrowOfWeek = MapPerDay.translatedMap.get(dateFormatter.format(tomorrow));

        MapPerDay scheduledDays = new MapPerDay();
        
        if (messageText.toLowerCase().contains("понеділ") || messageText.toLowerCase().contains("пн")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto("понеділок"));
        } else if (messageText.toLowerCase().contains("вівтор") || messageText.toLowerCase().equals("вт")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto("вівторок"));
        } else if (messageText.toLowerCase().contains("серед") || messageText.toLowerCase().contains("ср")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto("середа"));
        } else if (messageText.toLowerCase().contains("четвер") || messageText.toLowerCase().contains("чт")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto("четвер"));
        } else if (messageText.toLowerCase().contains("п'ятниц") || messageText.toLowerCase().contains("пт") || messageText.toLowerCase().contains("п’ятниц")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto("п'ятниця"));
        } else if (messageText.toLowerCase().contains("сьогодні") || messageText.toLowerCase().contains("сьодні")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto(todayOfWeek));
        } else if (messageText.toLowerCase().contains("завтра")) {
            return new SendPhoto()
                    .setChatId(chatId).setNewPhoto(scheduledDays.getScheduledPhoto(tomorrowOfWeek));
        }
        return new SendPhoto()
                .setChatId(chatId).setNewPhoto(MapPerDay.errorFile.getFile()).setCaption(MapPerDay.errorFile.getDescription());
    }
}
