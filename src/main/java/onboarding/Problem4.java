package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append(invert(word.charAt(i)));
        }
        return sb.toString();
    }

    public static String invert(Character c) {
        if (c >= 'A' && c <= 'Z') {
            return String.valueOf((char) (155 - (int) c));
        } else if (c >= 'a' && c <= 'z') {
            return String.valueOf((char) (219 - (int) c));
        } else return String.valueOf(c);
    }
}
