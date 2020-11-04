package examples.simple;

public class DoubleString {
  public static void main(String[] args) {
    System.out.println(doubleChar("hello"));
  }

  private static String doubleChar(String text) {
    var sb = new StringBuffer();
    for (char ch : text.toCharArray()) {
      sb.append(ch);
      sb.append(ch);
    }
    return sb.toString();
  }
}
