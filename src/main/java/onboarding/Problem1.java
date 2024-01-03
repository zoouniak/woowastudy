package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

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
        // 페이지 번호의 개수가 2장이 아닐 때
        if (pages.size() != 2) return false;
        // 페에지가 잘못 입력되었을 때 (1~400 사이의 값이 아닌 경우)
        if (!checkPage(pages.get(0)) || !checkPage(pages.get(1))) return false;
        // 홀수/짝수 페이지가 아닐 때
        if (!checkOdd(pages.get(0)) || !checkEven(pages.get(1))) return false;
        // 왼쪽 페이지 +1 != 오른쪽 페이지일때
        if (pages.get(0) + 1 != pages.get(1)) return false;

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

    /*
     * 곱한 수와 더한 수 중 더 큰 값을 반환하는 함수
     * @param 더한 수, 곱한 수
     * @return 두 값 중 큰 수
     */
    public static int selectMaxBetweenSumAndMul(int sum, int mul) {
        return Math.max(sum, mul);
    }

    /*
     * 페이지 번호의 각 자릿수 숫자를 더한 수를 반환하는 함수
     * @param 페이지 빈호
     * @return 더한 수
     */
    public static int getSum(int page) {
        int sum = 0;
        for (int i = 2; i >= 0; i--) {
            int digit = (int) (page / Math.pow(10, i));
            sum += digit;
            page %= Math.pow(10, i);
        }
        return sum;
    }

    /*
     * 페이지 번호의 각 자릿수 숫자를 곱한 수를 반환하는 함수
     * @param 페이지 빈호
     * @return 곱한 수
     */
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

    /*
     * 왼쪽 큰 수와 오른쪽 큰 수 중 큰 값을 반환하는 함수
     * @param 왼쪽 큰 수, 오른쪽 큰 수
     * @return 두 값 중 큰 값
     */
    public static int selectMaxBetweenLeftAndRight(int left, int right) {
        return Math.max(left, right);
    }

    /*
     * 게임 결과를 반환하는 함수
     * @param 포비의 큰 수, 크롱의 큰 수
     * @return 포비가 이겼을 때 1, 크롱이 이겼을 때 2, 비겼을 때 0
     */
    public static int getGameResult(int pobi, int crong) {
        return pobi > crong ? 1 : (pobi == crong ? 0 : 2);
    }

}