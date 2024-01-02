package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 리스트 페이지가 2개가 아닌 경우
        if (pobi.size() != 2 || crong.size() != 2) {
            return -1;
        }
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (checkOdd(pobiLeftPage) || checkEven(pobiRightPage) || checkOdd(crongLeftPage) || checkEven(crongRightPage)) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean checkOdd(int page) { // 홀수 확인
        return (page % 2) != 0;
    }

    public static boolean checkEven(int page) { // 짝수 확인
        return (page % 2) == 0;
    }

}