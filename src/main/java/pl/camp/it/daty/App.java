package pl.camp.it.daty;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        LocalTime localTime = LocalTime.of(15, 35, 55);
        System.out.println(localTime);
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalDate localDate = LocalDate.of(2023, Month.JANUARY, 17);
        System.out.println(localDate);
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        System.out.println(currentLocalDateTime);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, 6, 26,
                17, 45, 30);

        LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.of(2024, 10, 11),
                LocalTime.of(13, 44, 55));

        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println(currentZonedDateTime);

        ZonedDateTime przesunietyCzas = currentZonedDateTime.withZoneSameInstant(ZoneId.of("Australia/Darwin"));
        System.out.println(przesunietyCzas);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDate.of(2023,5,15),
                LocalTime.of(23,23,23),
                ZoneId.of("Europe/Warsaw"));

        Instant instant1 = zonedDateTime.toInstant();
        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration);

        System.out.println(duration.toDays());

        ZonedDateTime przesynietyCzas = zonedDateTime.plusMonths(4);
        System.out.println(przesynietyCzas);

        LocalDateTime lokalnyDatoCzas = LocalDateTime.now();
        lokalnyDatoCzas.plusHours(44);
        System.out.println(lokalnyDatoCzas);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/dd-MM HH-mm/ss");
        String czas = lokalnyDatoCzas.format(formatter);
        System.out.println(czas);

        String dataZPalca = "07-07-2022 15:34:55";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse(dataZPalca, formatter2);
        System.out.println(parsedLocalDateTime);

        String doWyswietlenia = "";
        doWyswietlenia = doWyswietlenia + parsedLocalDateTime.getDayOfMonth() + "-";
        switch (parsedLocalDateTime.getMonth()) {
            case JANUARY:
                doWyswietlenia = doWyswietlenia + "Styczeń";
                break;
            case FEBRUARY:
                doWyswietlenia = doWyswietlenia + "Styczeń";
                break;
        }

        Map<Integer, String> polskieMiesiace = new HashMap<>();
        polskieMiesiace.put(1, "Styczeń");
        polskieMiesiace.put(2, "Luty");
        polskieMiesiace.put(3, "Marzec");
        polskieMiesiace.put(7, "Lipiec");

        String data = parsedLocalDateTime.format(formatter);
        System.out.println(data);
        String zmienionaData = data.replaceAll("-[0-9]{2} ", "-" + polskieMiesiace.get(parsedLocalDateTime.getMonth().getValue()) + " ");
        System.out.println(zmienionaData);
    }
}
