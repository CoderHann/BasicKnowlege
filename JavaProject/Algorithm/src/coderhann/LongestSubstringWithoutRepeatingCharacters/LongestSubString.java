package coderhann.LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by roki on 2017/6/9.
 */
public class LongestSubString {


    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        for (int i = s.length(); i > 0; i--) {

            for (int j = 0; j < s.length() - i + 1; j++) {

                String str = s.substring(j,j+i);

                char[] characters = str.toCharArray();
                HashSet<Character> charSet = new HashSet<>();
                for (char c: characters) {
                    charSet.add(c);
                }

                if (characters.length == charSet.size()) {
                    max = i;
                    System.out.println(str);
                    return max;
                }

            }

        }

        return max;
    }

    // abcabcbb
//    public int lengthOfLongestSubstring(String s) {
//
//        HashMap<Character,HashMap<Integer,int[]>> map = new HashMap<>();
//        for (int index = 0; index < s.length(); index++) {
//            Character c = s.charAt(index);
//            if (!map.containsKey(c)) {
//
//                int[] bigCloserIndex = {index,index};
//                HashMap<Integer,int[]> contentMap = new HashMap<>();
//                contentMap.put(1,bigCloserIndex);
//                map.put(c,contentMap);
//
//
//            } else {
//                HashMap<Integer,int[]> currentContent = map.get(c);
//                Integer key = null;
//                for (Integer integer: currentContent.keySet()) {
//                    key = integer;
//                }
//
//                Integer lastIndex = currentContent.get(key)[1];
//                Integer
//            }
//        }
//
//        for (Character c: map.keySet()) {
//
//
//
//        }
//    }
}

