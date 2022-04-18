package sort.bucket;

import sort.ArraySort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort implements ArraySort {
    private static final int BUCKET_SIZE = 10; // size of each bucket
    private static final int BUCKET_NUM = 10; // number of buckets

    @Override
    public void sort(int[] nums) {
        // initialize buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < BUCKET_NUM; i++) {
            buckets.add(new ArrayList<>());
        }

        // put each element into its corresponding bucket
        for (int num : nums) {
            buckets.get(mapToBucket(num)).add(num);
        }

        // sort elements in each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // merge buckets
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                nums[i++] = num;
            }
        }
    }

    private int mapToBucket(int num) {
        return num / BUCKET_NUM;
    }
}
