package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
                answer+= clap(i);
        }
        return answer;
    }

    public static int clap(int target) {
        int count=0;
        while (target > 0) {
            if (target % 10 == 3 || target % 10 == 6 || target % 10 == 9) {
                count++;
            }
            target /= 10;
        }
        return count;
    }
}
