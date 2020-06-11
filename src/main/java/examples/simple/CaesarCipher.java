package examples.simple;

public class CaesarCipher {

  // https://www.ascii-code.com/
  private static final int PRINTABLE_START = 32;
  private static final int PRINTABLE_END = 127;

  public static void main(String[] args) {
    System.out.println(encrypt("The eagle flies at dawn", 5));
  }

  public static String encrypt(String plaintext, int key) {
    return shiftString(plaintext, key);
  }

  public static String decrypt(String ciphertext, int key) {
    return shiftString(ciphertext, -key);
  }

  private static String shiftString(String plaintext, int key) {
    if (key < 0 || key > PRINTABLE_END - PRINTABLE_START) {
      throw new IllegalArgumentException("Key " + key + " is out of range");
    }
    var output = new StringBuilder();
    for (char c : plaintext.toCharArray()) {
      output.append((char) shiftCharacter(c, key));
    }
    return output.toString();
  }

  private static int shiftCharacter(char character, int key) {
    int shifted = character - key;
    int adjusted;
    if (shifted > PRINTABLE_END) {
      adjusted = shifted - PRINTABLE_END + PRINTABLE_START;
    } else if (shifted < PRINTABLE_START) {
      adjusted = shifted - PRINTABLE_START + PRINTABLE_END;
    } else {
      adjusted = shifted;
    }
    return adjusted;
  }
}

