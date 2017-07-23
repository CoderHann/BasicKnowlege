package coderhann.medianoftwosortedarrays;

import java.util.ArrayList;

/**
 * Created by roki on 2017/6/15.
 */
public class MedianNumber {

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {2};

        double value =  findMedianSortedArrays(num1,num2);

        System.out.println("value + " + value);
     }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int k1 = 0;
        int k2 = 0;

        if ((nums1.length + nums2.length) % 2 != 0) {
            k1 = (nums1.length + nums2.length) / 2 + 1;
            k2 = k1;

        } else {

            k1 = (nums1.length + nums2.length) / 2;
            k2 = (nums1.length + nums2.length) / 2 + 1;

        }
        ArrayList<Integer> valueList = new ArrayList<Integer>();


//        while ()
        return 0;


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int k1 = 0;
        int k2 = 0;

        if ((nums1.length + nums2.length) % 2 != 0) {
            k1 = (nums1.length + nums2.length) / 2 + 1;
            k2 = k1;

        } else {

            k1 = (nums1.length + nums2.length) / 2;
            k2 = (nums1.length + nums2.length) / 2 + 1;

        }


        int i = 0;
        int j = 0;

        int n = 0;
        ArrayList<Integer> valueList = new ArrayList<Integer>();

        while (n < (nums1.length + nums2.length)) {

            if (i < nums1.length) {

                if (j < nums2.length) {

                    if (nums1[i] <= nums2[j]) {
                        n++;
                        int value = nums1[i];

                        if (n == k1 || n == k2) {
                            valueList.add(value);
                        }
                        i++;
                    }
                } else {

                    n++;
                    int value = nums1[i];

                    if (n == k1 || n == k2) {
                        valueList.add(value);
                    }
                    i++;
                }


            }

            if (j < nums2.length) {

                if (i < nums1.length) {

                    if (nums2[j] <= nums1[i]) {
                        n++;

                        if (n == k1 || n == k2) {
                            valueList.add(nums2[j]);
                        }
                        j++;
                    }
                } else {
                    n++;

                    if (n == k1 || n == k2) {
                        valueList.add(nums2[j]);
                    }
                    j++;
                }



            }


            if (k1 == k2) {
                if (valueList.size() == 1) {
                    break;
                }
            } else {
                if (valueList.size() == 2) {
                    break;
                }
            }




        }

        if (k1 == k2) {

            return valueList.get(0);
        } else {
            return (valueList.get(0) + valueList.get(1)) / 2.0;
        }

    }
}
