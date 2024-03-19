package Java;

import java.awt.*;
import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("요일을 입력하세요(1~7) : ");
            int day = scanner.nextInt();
            String daySrting;

            switch (day) {
                case 1:
                    daySrting = "월요일";
                    break;
                case 2:
                    daySrting = "화요일";
                    break;
                case 3:
                    daySrting = "수요일";
                    break;
                case 4:
                    daySrting = "목요일";
                    break;
                case 5:
                    daySrting = "금요일";
                    break;
                case 6:
                    daySrting = "토요일";
                    break;
                case 7:
                    daySrting = "일요일";
                    break;
                default:
                    daySrting = "잘못된 입력";
            }
            if(daySrting.equals("잘못된 입력")) {
                System.out.println("다시 입력해주세요.");
                continue;
            }else {
                System.out.println("입력한 요일은 " + daySrting + " 입니다.");
                break;
            }
        }
    }
}
