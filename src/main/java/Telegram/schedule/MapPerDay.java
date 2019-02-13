package Telegram.schedule;

import Telegram.utils.Tuple;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class MapPerDay {
    private static Map<String, String> daysWithText = new TreeMap<>();
    private static Map<String, File> daysWithFile = new TreeMap<>();
    public static Tuple<String, File> errorFile = new Tuple<>("Введіть день тижня в пофіг-якому відмінку або скорочено" +
            "(ще можна \"сьогодні\"(сд), \"завтра\"(зв))\nДля особливих скорочення: пн, вт, ср, чт, пт",
            new File("src/resources/404.png"));

    public MapPerDay() {
        setDaysWithSchedule();
        setDayWithFile();

    }

    private Map<String, String> setDaysWithSchedule() {
        daysWithText.put("понеділок", "15:05-16:25  -  ЧММФ, лекція, 111\n" +
                "16:40-18:00  -  (знаменник)Основи права, лекція, 311\n" +
                "18:10-19:30  -  (знаменник)Основи права, практична, 367\n");
        daysWithText.put("вівторок", "15:05-16:25  -  (знаменник)Дослідження операція, лекція, 266, Бартіш\n" +
                "\"16:40-18:00  -  Прикладна статистика | Пайтон, пр, 261 | 272/3\n" +
                "18:10-19:30  -  Прикладна статистика | Пайтон, лаб, 261 | 272/3\n");
        daysWithText.put("середа", "13:30-14:50  -  Фінансова математика, лекція, 439, Мельничин\n" +
                "15:05-16:25  -  (чисельник)Фінансова математика, лаб, 119а, Мельничин\n" +
                "16:40-18:00  -  Дослідження операція, лаб, 366\n" +
                "18:10-19:30  -  Системи моделі охорони довкілля, лекція, 266\n");
        daysWithText.put("четвер", "13:30-14:50  -  Інтелект. аналіз даних, пр | лаб, 270\n" +
                "15:05-16:25  -  Мат. економіка, лекція, 266\n" +
                "16:40-18:00  -  (чисельник)Мат. економіка, лекція, 266\n");
        daysWithText.put("п'ятниця", "15:05-16:25  -  (знаменник)ЧММФ, лаб, 118а\n" +
                "16:30-18:00  -  Політологія, (чисельник) пр., 265 | (знаменник) лекція, 439\n" +
                "18:10-19:30  -  Матекономіка, лаб, 266\n");
        return daysWithText;
    }

    private Map<String, File> setDayWithFile() {
        daysWithFile.put(Days.MONDAY.name(), new File("src/resources/monday.png"));
        daysWithFile.put(Days.TUESDAY.name(), new File("src/resources/tuesday.png"));
        daysWithFile.put(Days.WEDNESDAY.name(), new File("src/resources/wednesday.png"));
        daysWithFile.put(Days.THURSDAY.name(), new File("src/resources/thursday.png"));
        daysWithFile.put(Days.FRIDAY.name(), new File("src/resources/friday.png"));
        return daysWithFile;
    }


    public File getScheduledPhoto(String day) {
        if (daysWithFile.containsKey(day)) {
            return daysWithFile.get(day);
        }
        return errorFile.getFile();

    }
}
