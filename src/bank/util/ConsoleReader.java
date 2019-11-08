package bank.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Abstract helper class for input from console.
 */
public abstract class ConsoleReader {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  /**
   * Reads in an int from console.
   *
   * @param errorInfo is the message shown when IOException is thrown.
   * @return an int value from console.
   */
  public static int readNumber(String errorInfo) {
    while (true) {
      try {
        return Integer.parseInt(br.readLine());
      } catch (IOException | NumberFormatException e) {
        System.out.println(errorInfo);
      }
    }
  }

  /**
   * Reads in an int from console of predefined options.
   *
   * @param errorInfo is the message shown when wrong option was chosen or IOException is thrown.
   * @param options   is a List of predefined options to picked from.
   * @return an int value from console.
   */
  public static int readNumber(String errorInfo, List<Integer> options) {
    while (true) {
      try {
        Integer input = Integer.valueOf(br.readLine());
        if (options.contains(input)) {
          return input;
        } else {
          System.out.println(errorInfo);
        }
      } catch (IOException | NumberFormatException e) {
        System.out.println(errorInfo);
      }
    }
  }

  /**
   * Reads a date from console.
   *
   * @param errorInfo is the messaged shown when IOException is thrown.
   * @return LocalDate input from console.
   */
  public static LocalDate readDate(String errorInfo) {
    while (true) {
      try {
        return LocalDate.parse(br.readLine());
      } catch (IOException e) {
        System.out.println(errorInfo);
      } catch (DateTimeParseException e) {
        System.out.println("Falsches Format! Beispiel: 2019-10-31");
      }
    }
  }

  /**
   * Reads in a String from console.
   *
   * @param errorInfo is the messaged shown when IOException is thrown.
   * @return String input from console.
   */
  public static String readString(String errorInfo) {
    while (true) {
      try {
        return br.readLine();
      } catch (IOException e) {
        System.out.println(errorInfo);
      }
    }
  }

  /**
   * Reads in a String from console of predefined options.
   *
   * @param errorInfo is the message shown when wrong option was chosen or IOException is thrown.
   * @param options   is a List of predefined options to picked from.
   * @return String input from console.
   */
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
      }
    }
  }
}
