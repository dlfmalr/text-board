package Java2;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtil {

    //Scanner 만들기
    //LocalDateTime 만들기

    private Scanner scan = new Scanner(System.in);

    public Scanner getScanner() {
        return scan;
    }

    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        return formattedDate;
    }
}
