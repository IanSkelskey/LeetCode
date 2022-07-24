/*
    LeetCode Problem #724
    Find Pivot Index

    Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to
    the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
    This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.
 */

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] left;
        int[] right;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left = new int[0];
            } else {
                left = Arrays.copyOfRange(nums, 0, i);
            }
            if (i == nums.length - 1) {
                right = new int[0];
            } else {
                right = Arrays.copyOfRange(nums, i + 1, nums.length);
            }

            if (sum(left) == sum(right)) {
                return i;
            }
        }
        return -1;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

}
