package database.utils;

import java.util.Scanner;

public class ClearBuffer {
  public ClearBuffer(Scanner scanner) {
    if (scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }
}
