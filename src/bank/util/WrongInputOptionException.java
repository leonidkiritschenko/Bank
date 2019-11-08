package bank.util;

/**
 * WrongInputOptionException is thrown when the input does not match the options.
 */
public class WrongInputOptionException extends IllegalArgumentException {
  WrongInputOptionException() {
  }

  WrongInputOptionException(String s) {
    super(s);
  }
}
