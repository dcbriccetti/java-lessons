package examples;

import java.util.regex.Pattern;

public class RegExPractice {
    public static void main(String[] args) {
        var pattern = Pattern.compile("(\\d+)-(\\d+) (\\w): (\\w+)");
        var matcher = pattern.matcher("1-3 b: cdefg");
        System.out.println(matcher.matches());

        var smallNum = Integer.parseInt(matcher.group(1));
        var largeNum = Integer.parseInt(matcher.group(2));
        var expectedChar = matcher.group(3).charAt(0);
        var password = matcher.group(4);
        System.out.printf("s: %d, l: %d, ch: %c, pw: %s\n", smallNum, largeNum, expectedChar, password);
        var passwordChars = password.toCharArray();
        int expectedCharCount = 0;

        for (char passwordChar : passwordChars) {
            if (passwordChar == expectedChar) {
                expectedCharCount++;
            }
        }
        if (expectedCharCount >= smallNum && expectedCharCount <= largeNum){
            System.out.println("Password Valid!");
        }
    }
}
