package application;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;


public class DateUsefull {
public static void main(String[]args){
    //date time formatter
    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

    //date and time no nanosec
    LocalDateTime d00 = LocalDateTime.now().withNano(0);
    //date
  LocalDate d01 = LocalDate.now();

  //date and time
  LocalDateTime d02 = LocalDateTime.now();

  //date and time UTC pattern
  Instant d03 = Instant.now();

  //.parse iso 8601 ~~ iso 8601 is the java standard ~~ toString changes for iso8601
  LocalDate d04 = LocalDate.parse("2022-07-20");
  LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
  LocalDateTime d06 = LocalDateTime.parse(LocalDateTime.now().toString());
  Instant d07 = Instant.parse(Instant.now().toString());
  LocalDateTime d08 = LocalDateTime.parse(LocalDateTime.now().withNano(0).toString());

  //DateTimeFormatter better than old SimpleDateFormat
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());


   System.out.println("d00 Date and time no nanosec = " + d00);
   System.out.println("d01 Date = " + d01);
   System.out.println("d02 Date and time = " + d02);
   System.out.println("d03 Date and time GMT = " + d03);
   System.out.println("d04 date iso 8601 = " + d04);
   System.out.println("d05 date and time iso 8601 = " + d05);
   System.out.println("d06 date and time iso 8601 now = " + d06);
   System.out.println("d07 date and time UTC iso8601 = "+d07);
   System.out.println("d08 date and time UTC no nanosec = " + d08);
   System.out.println("d02 formatter date = " + fmt.format(d02));
   System.out.println("d02 formatter date and time = " + fmt2.format(d02));
   System.out.println("d03 formatter date and time Instant = "+fmt3.format(d03));
}

}
