//XXOO

public class FirstBadVersion278 {
    public int firstBadVersion(int n) {

        if (n <= 1) {
            return 1;
        }

        int start = 1;
        int end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid;

            } else {
                end = mid;
            }

        }

        if (isBadVersion(start)) {
            return start;
        }

        if (isBadVersion(end)) {
            return end;
        }

        return -1;

    }

}
