package coderhann.AddTwoNumbers2;

import coderhann.LongestSubstringWithoutRepeatingCharacters.LongestSubString;

import java.util.List;

/**
 * Created by roki on 2017/6/8.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        //243
        //564
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//
//
////        ListNode rs = Solution.addTwoNumbers(l1,l2);
//        ListNode rs = Solution.addTwoNumbersTwo(l1,l2);
//        System.out.println(rs);

        LongestSubString.lengthOfLongestSubstring("ensqkaciqxowqydgekkqwhbxxvkqijkowehiejqujhsbhxhnhrdebfbycoomxabveiditwecdwgmtna");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int offset = 0;
        ListNode preNode = null;
        ListNode firstNode = null;

        while (l1 != null || l2 != null || offset != 0) {

            int result1 = 0;
            if (l1 != null) {
                result1 = l1.val;
            }

            int result2 = 0;
            if (l2 != null) {
                result2 = l2.val;
            }

            int result = (result1 + result2 + offset) % 10;

            ListNode currentNode = new ListNode(result);

            if (preNode == null) {
                preNode = currentNode;
                firstNode = currentNode;
            } else {
                preNode.next = currentNode;
            }
            preNode = currentNode;
            offset = (result1 + result2 + offset) / 10;


            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return firstNode;
    }

    public static ListNode addTwoNumbersTwo(ListNode l1, ListNode l2) {


        return add(l1,l2,0);
    }

    public static ListNode add(ListNode l1, ListNode l2, int offset) {

        int result1 = (l1 == null) ? 0 : l1.val;
        int result2 = (l2 == null) ? 0 : l2.val;

        int result = (result1 + result2 + offset) % 10;

        ListNode node = new ListNode(result);

        int currentOffset = (result1 + result2 + offset) / 10;
        l1 = (l1 == null) ? null : l1.next;
        l2 = (l2 == null) ? null : l2.next;
        if (l1 != null || l2 != null || currentOffset != 0) {
            ListNode nextNode = add(l1,l2,currentOffset);
            node.next = nextNode;
        }


        return node;
    }
}