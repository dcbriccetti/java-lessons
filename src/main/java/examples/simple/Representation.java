package examples.simple;

import static java.lang.System.out;

public class Representation {
  public static void main(String[] args) {
    out.println((int) 'a');
    out.println((int) 'z');
    out.println((int) 'A');
    out.println((int) 'Z');
    for (int code = 32; code <= 127; code++) {
      out.print((char) code);
    }
    out.println();
  }
}

// https://www.ascii-code.com/
