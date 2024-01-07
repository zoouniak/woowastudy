package onboarding;

import java.util.*;

public class Problem6 {
    static List<List<String>> candidates = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        Set<String> duplicate = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            if (email.length() < 11 || email.length() > 20) // 길이 제한
                return null;
            if (!email.split("@")[1].equals("email.com")) // 형식 제한
                return null;

            List<String> seqWords = getSeqWords(form.get(1)); // 본인 이름의 연속 글자 리스트

            // seqwords가 candidates에 포함되면 answer에 추가
            int index = checkDup(seqWords);
            if (index != -1) {
                duplicate.add(form.get(0));
                duplicate.add(forms.get(index).get(0));
            }
            candidates.add(seqWords);

        }

        List<String> answer = new ArrayList<>(duplicate);
        Collections.sort(answer);
        return answer;
    }

    public static List<String> getSeqWords(String name) { // 이름에서 두 글자씩 추출하여 연속된 글자 저장
        List<String> words = new ArrayList<>();
        for (int i = 0; i < name.length() - 1; i++) {
            words.add(name.charAt(i) + String.valueOf(name.charAt(i + 1)));
        }
        return words;
    }

    public static int checkDup(List<String> words) {
        // candidates list 안에 현재 2글자가 발견된 index 반환
        for (int i = 0; i < candidates.size(); i++) {
            for (String word : words) {
                if (candidates.get(i).contains(word))
                    return i;
            }
        }
        return -1;
    }
}
