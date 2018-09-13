package Telegram.recognition;

import Telegram.schedule.Days;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.text.SimpleDateFormat;
import java.util.*;

public class TextRecognition {

    public static HashMap<List<String>, String> days = new HashMap<List<String>, String>() {
        {
            put(Arrays.asList("пн", "понеділ"), Days.MONDAY.name());
            put(Arrays.asList("вівтор", "вт"), Days.TUESDAY.name());
            put(Arrays.asList("серед", "ср"), Days.WEDNESDAY.name());
            put(Arrays.asList("четвер", "чт"), Days.THURSDAY.name());
            put(Arrays.asList("п'ятниц", "пт", "п’ятниц", "пятниц"), Days.FRIDAY.name());
        }
    };

    public static String getDayOfWeekByMessage(String messageText) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");
        String todayOfWeek = dateFormatter.format(today).toUpperCase();
        String tomorrowOfWeek = dateFormatter.format(tomorrow).toUpperCase();

        if (messageText.contains("сьогодні") || messageText.contains("сьодні")) {
            return todayOfWeek;
        } else if (messageText.contains("завтра")) {
            return tomorrowOfWeek;
        }

        for (Map.Entry<List<String>, String> entry : days.entrySet()) {
            for (String word : entry.getKey())
                if (messageText.contains(word)) {
                    return entry.getValue();
                }
        }
        return "error";
    }

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
