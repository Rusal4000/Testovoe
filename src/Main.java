import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Угадай число");
        int range = 100;
        int number = (int) (Math.random() * range);
        int attempts = 0;
        int bestAttempts = Integer.MAX_VALUEVALU;

        while (true) {
            System.out.println("Брат, число от 0 до " + range);
            String input = scanner.next();

            if (input.equalsIgnoreCase("RESULT")) {
                if (attempts == 0) {
                    System.out.println("Ты не сделал еще не одной попытки, брат");
                    System.out.println("Лучшее количество попыток: " + bestAttempts);
                } else {
                    System.out.println("Текущее количество попыток: " + attempts);
                    System.out.println("Лучшее количество попыток: " + bestAttempts);
                }
                continue;
            }

            int input_number;
            try {
                input_number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число или команду RESULT.");
                continue;
            }

            attempts++;

            if (input_number == number) {
                System.out.println("Ты угадал за " + attempts + " попыток!");

                if (attempts < bestAttempts) {
                    bestAttempts = attempts;
                }

                attempts = 0;
                number = (int) (Math.random() * range);
            } else if (input_number > number) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
            } else {
                System.out.println("Я сам в шоке, но, загаданное число больше, брат");
            }
        }
    }
}
