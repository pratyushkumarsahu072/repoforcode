import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter alarm time (HH:MM:SS): ");
        String input = scanner.nextLine();

        LocalTime alarmTime = LocalTime.parse(input);

        System.out.println("Alarm set for: " + alarmTime);

        while (true) {
            LocalTime currentTime = LocalTime.now();

            if (currentTime.getHour() == alarmTime.getHour() &&
                currentTime.getMinute() == alarmTime.getMinute() &&
                currentTime.getSecond() == alarmTime.getSecond()) {

                System.out.println("⏰ ALARM! Wake up!");

                // Beep sound (system dependent)
                for (int i = 0; i < 5; i++) {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }

            try {
                Thread.sleep(1000); // check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
