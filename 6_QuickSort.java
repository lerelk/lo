

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        randomizedQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // Original QuickSort method
    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // If the array is already sorted, no swap will occur
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // Recursive calls to sort the two halves
        sort(nums, low, e);
        sort(nums, s, hi);
    }

    // Randomized QuickSort method
    static void randomizedQuickSort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        // Select a random pivot and swap it with the middle element
        int randomPivotIndex = low + new Random().nextInt(hi - low + 1);
        int temp = nums[randomPivotIndex];
        nums[randomPivotIndex] = nums[low + (hi - low) / 2];
        nums[low + (hi - low) / 2] = temp;

        // Proceed with the normal partitioning and recursive sorting
        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // Recursive calls to sort the two halves
        randomizedQuickSort(nums, low, e);
        randomizedQuickSort(nums, s, hi);
    }
}
/*

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        sort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
    }

    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }
}
 */