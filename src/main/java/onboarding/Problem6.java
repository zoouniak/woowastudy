package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (List<String> form : forms) {
            String email = form.get(0);
            if (email.length() < 11 || email.length() > 20) // 길이 제한
                return null;
            if (email.split("@")[1].equals("email.com")) // 형식 제한
                return null;
        }


        return answer;
    }

}
