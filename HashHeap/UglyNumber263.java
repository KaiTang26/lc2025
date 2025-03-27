package HashHeap;

public class UglyNumber263 {

    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int[] uglyFactors = new int[] { 2, 3, 5 };

        for (int f : uglyFactors) {

            n = factor(n, f);

        }

        return n == 1;

    }

    private int factor(int inputNum, int fIndex) {

        int num = inputNum;

        while (num % fIndex == 0) {

            num = num / fIndex;

        }

        return num;
    }

}
