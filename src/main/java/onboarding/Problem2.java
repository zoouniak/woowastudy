package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String decode = removeDup(cryptogram);
        while (!decode.equals(cryptogram)) {
            cryptogram = decode;
            decode = removeDup(cryptogram);
        }

        String answer = cryptogram;
        return answer;
    }

    public static String removeDup(String c) {
        for (int i = 0; i < c.length() - 1; i++) {
            if (c.charAt(i) == c.charAt(i + 1)) {
                return c.substring(0, i) + c.substring(i + 2);
            }
        }
        return c;
    }
}
