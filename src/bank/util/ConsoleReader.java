package bank.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public abstract class ConsoleReader {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readNumber(String errorInfo) {
        try {
            return Integer.valueOf(br.readLine());
        } catch (IOException e) {
            System.out.println(errorInfo);
            return ConsoleReader.readNumber(errorInfo);
        } catch (NumberFormatException e) {
            System.out.println("Nur Zahlen!");
            return ConsoleReader.readNumber(errorInfo);
        }
    }

    public static int readNumber(String errorInfo, List<Integer> options) {
        while (true) {
            try {
                Integer input = Integer.valueOf(br.readLine());
                if (options.contains(input)) {
                    return input;
                } else {
                    System.out.println(errorInfo);
                }
            } catch (IOException e) {
                System.out.println(errorInfo);
                return ConsoleReader.readNumber(errorInfo);
            } catch (NumberFormatException e) {
                System.out.println("Nur Zahlen!");
                return ConsoleReader.readNumber(errorInfo);
            }
        }
    }

    public static LocalDate readDate(String errorInfo) {
        try {
            return LocalDate.parse(br.readLine());
        } catch (IOException e) {
            System.out.println(errorInfo);
            return ConsoleReader.readDate(errorInfo);
        } catch (DateTimeParseException e) {
            System.out.println("Falsches Format! Beispiel: 2019-10-31");
            return ConsoleReader.readDate(errorInfo);
        }
    }

    public static String readString(String errorInfo) {
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println(errorInfo);
            return ConsoleReader.readString(errorInfo);
        }
    }

    public static String readString(String errorInfo, List<String> options) {
        while (true) {
            try {
                String input = br.readLine().toLowerCase();
                if (options.contains(input)) {
                    return input;
                } else {
                    System.out.println(errorInfo);
                }
            } catch (IOException e) {
                System.out.println(errorInfo);
                return ConsoleReader.readString(errorInfo);
            }
        }

    }
}
