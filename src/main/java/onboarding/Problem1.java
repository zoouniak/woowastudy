package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 리스트 페이지가 2개가 아닌 경우

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (!isValidPage(pobi) || !isValidPage(crong))
            return -1;

        int pobiLeftMax = selectMaxBetweenSumAndMul(getSum(pobiLeftPage), getMul(pobiLeftPage));
        int pobiRightMax = selectMaxBetweenSumAndMul(getSum(pobiRightPage), getMul(pobiRightPage));
        int crongLeftMax = selectMaxBetweenSumAndMul(getSum(crongLeftPage), getMul(crongLeftPage));
        int crongRightMax = selectMaxBetweenSumAndMul(getSum(crongRightPage), getMul(crongRightPage));

        int pobiMax = selectMaxBetweenLeftAndRight(pobiLeftMax, pobiRightMax);
        int crongMax = selectMaxBetweenLeftAndRight(crongLeftMax, crongRightMax);

        int answer = getGameResult(pobiMax, crongMax);
        return answer;
    }

    public static boolean isValidPage(List<Integer> pages) {
        if (pages.size() != 2)
            return false;
        if (!checkPage(pages.get(0)) || !checkPage(pages.get(1)))
            return false;
        if (!checkOdd(pages.get(0)) || !checkEven(pages.get(1)))
            return false;
        if (pages.get(0) + 1 != pages.get(1))
            return false;

        return true;
    }

    public static boolean checkPage(int page) {
        return page >= 1 && page <= 400;
    }

    public static boolean checkOdd(int page) { // 홀수 확인
        return (page % 2) != 0;
    }

    public static boolean checkEven(int page) { // 짝수 확인
        return (page % 2) == 0;
    }

    public static int selectMaxBetweenSumAndMul(int sum, int mul) {
        return Math.max(sum, mul);
    }

    public static int getSum(int page) {
        int sum = 0;
        for (int i = 2; i >= 0; i--) {
            int digit = (int) (page / Math.pow(10, i));
            sum += digit;
            page %= Math.pow(10, i);
        }
        return sum;
    }

    public static int getMul(int page) {
        int mul = 1;
        for (int i = 2; i >= 0; i--) {
            int digit = (int) (page / Math.pow(10, i));
            digit = (digit == 0) ? 1 : digit;
            mul *= digit;
            page %= Math.pow(10, i);
        }
        return mul;
    }

    public static int selectMaxBetweenLeftAndRight(int left, int right) {
        return Math.max(left, right);
    }

    public static int getGameResult(int pobi, int crong) {
        return pobi > crong ? 1 : (pobi == crong ? 0 : 2);
    }

}