package sort.tim;

import sort.ArraySort;
import sort.insertion.InsertionSort;

import java.util.ArrayList;
import java.util.List;

public class TimSort implements ArraySort {
    private static final int MIN_MERGE = 64;
    private final InsertionSort insertionSort = new InsertionSort();

    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        if (n < 2) {// less than 2 elements
            return;
        }

        if (n < MIN_MERGE) {// if array length is less than MIN_MERGE, just apply binary insertion sort
            insertionSort.sort_binary(nums);
            return;
        }

        // 1. identify all runs and maybe merge runs to maintain stack invariant
        // 2. merge all remained runs in stack
        mergeAllCollapse(identifyRuns(0, n, minRunLength(n), nums), nums);
    }

    private List<int[]> identifyRuns(int start, int count, int minRun, int[] nums) {
        List<int[]> runs = new ArrayList<>();// <runStart, runLength>
        while (count > 0) {
            // identify next run
            int runLength = countRunAndMakeAscending(nums, start, nums.length);

            // If run is short, extend runLength to min(minRun, nRemaining)
            if (runLength < minRun) {
                int newLength = Math.min(minRun, count);
                insertionSort.sort_binary(nums, start, start + newLength, start + runLength);
                runLength = newLength;
            }

            runs.add(new int[]{start, runLength});
            mergeCollapse(runs, nums);

            start += runLength;
            count -= runLength;
        }

        return runs;
    }

    private void mergeCollapse(List<int[]> runs, int[] nums) {
        while (runs.size() > 1) {
            int n = runs.size();
            if (n >= 3 && runs.get(n - 3)[1] <= runs.get(n - 2)[1] + runs.get(n - 1)[1]) { // run[n-3]<=run[n-2]+run[n-1]
                // merge run[n-2] with min(run[n-3], run[n-1])
                mergeAt(runs, runs.get(n - 3)[1] < runs.get(n - 1)[1] ? n - 3 : n - 2, nums);
            } else if (runs.get(n - 2)[1] <= runs.get(n - 1)[1]) {// run[n-2]<=run[n-1]
                // merge run[n-2] with run[n-1]
                mergeAt(runs, n - 2, nums);
            } else {
                break;
            }
        }
    }

    private void mergeAllCollapse(List<int[]> runs, int[] nums) {
        while (runs.size() > 1) {
            int mid = runs.size() - 2;
            if (mid > 0 && runs.get(mid - 1)[1] < runs.get(mid + 1)[1]) {// merge run2 with min(run1, run3) if applicable
                mid--;
            }
            mergeAt(runs, mid, nums);
        }
    }

    private void mergeAt(List<int[]> runs, int i, int[] nums) {// merge ith and (i+1)th run in stack
        int n = runs.size();

        assert n >= 2;
        assert i >= 0;
        assert i == n - 2 || i == n - 3;

        int start1 = runs.get(i)[0], len1 = runs.get(i)[1];
        int start2 = runs.get(i + 1)[0], len2 = runs.get(i + 1)[1];
        assert len1 > 0 && len2 > 0;
        assert start1 + len1 == start2;

        // update stack of runs
        runs.get(i)[1] = len1 + len2;
        if (i == n - 3) {
            runs.get(n - 2)[0] = runs.get(n - 1)[0];
            runs.get(n - 2)[1] = runs.get(n - 1)[1];
        }
        runs.remove(n - 1);

        // find where the first element of run2 goes in run1
        int k = searchRight(nums[start2], start1, start1 + len1, nums);
        start1 += k;
        len1 -= k;

        // all elements in run2 are greater than or equal to the max element in run1
        // run1 and run2 are entirely sorted
        if (len1 == 0) {
            return;
        }

        // find where the last element of run1 goes in run2
        len2 = searchLeft(nums[len1 - 1], start2, start2 + len2, nums);

        // merge remaining elements of two runs in place
        merge(start1, len1, start2, len2, nums);
    }

    /**
     * Locate the position at which to insert the target into nums[start, end)
     * if the range contains an element equal to key, returns the index after the rightmost equal element.
     * In other words, return the first position where is greater than target
     */
    private int searchRight(int target, int start, int end, int[] nums) {
        int low = start, high = end - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low] <= target ? low - start + 1 : low - start;
    }

    /**
     * Locate the position at which to insert the target into nums[start, end)
     * if the range contains an element equal to key, returns the index of the leftmost equal element.
     * In other words, return the first position where is equal to or greater than target
     */
    private int searchLeft(int target, int start, int end, int[] nums) {
        int low = start, high = end - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low] < target ? low - start + 1 : low - start;
    }

    // Merge runs, using tmp array with min(len1, len2) elements
    private void merge(int start1, int len1, int start2, int len2, int[] nums) {
        if (len1 <= len2) {
            mergeLow(start1, len1, start2, len2, nums);
        } else {
            mergeHigh(start1, len1, start2, len2, nums);
        }
    }

    private void mergeLow(int start1, int len1, int start2, int len2, int[] nums) {
        assert len1 <= len2;

        int[] tmp = new int[len1];
        System.arraycopy(nums, start1, tmp, 0, len1);

        int p1 = 0, p2 = start2, dest = 0, end2 = start2 + len2;
        while (p1 < tmp.length && p2 < end2) { // merge forward
            if (tmp[p1] < nums[p2]) {
                nums[dest++] = tmp[p1++];
                len1--;
            } else {
                nums[dest++] = nums[p2++];
                len2--;
            }
        }

        if (len1 == 0) {
            System.arraycopy(nums, p2, nums, dest, len2);
        } else {
            System.arraycopy(tmp, p1, nums, dest, len1);
        }
    }

    private void mergeHigh(int start1, int len1, int start2, int len2, int[] nums) {
        assert len1 >= len2;

        int[] tmp = new int[len2];
        System.arraycopy(nums, start2, tmp, 0, len2);

        int p1 = len1 - 1, p2 = len2 - 1, dest = start2 + len2 - 1;
        while (p1 >= start1 && p2 >= 0) { // merge backward
            if (nums[p1] < tmp[p2]) {
                nums[dest--] = tmp[p2--];
                len2--;
            } else {
                nums[dest--] = nums[p1--];
                len1--;
            }
        }

        if (len1 == 0) {
            System.arraycopy(tmp, 0, nums, 0, len2);
        } else {
            System.arraycopy(nums, 0, nums, 0, len1);
        }
    }

    private int countRunAndMakeAscending(int[] nums, int left, int right) {// left inclusive, right exclusive
        assert left < right;

        if (left + 1 == right) {
            return 1;
        }

        int runRight = left + 1;
        if (nums[runRight++] < nums[left]) {// strictly descending
            while (runRight < right && nums[runRight] < nums[runRight - 1]) {
                runRight++;
            }
            reverseRange(nums, left, runRight);
        } else {// ascending
            while (runRight < right && nums[runRight] >= nums[runRight - 1]) {
                runRight++;
            }
        }

        return runRight - left;
    }

    private void reverseRange(int[] nums, int left, int right) {// left inclusive, right exclusive
        for (int i = left, j = right - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    private int minRunLength(int n) {
        assert n >= 0;

        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }

        return n + r;
    }
}
