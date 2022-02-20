package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//无重复字符 的最长子串
public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        //map(key,value)  分别存放 字符值  和   索引下标
        Map<Character,Integer> hashMap = new HashMap<>();

        for(int start =0, end = 0;end < s.length();end++){
            char ch = s.charAt(end);
            //start在移动的过程中，遇到重复字符的时候，更新为下一个位置，当前位置重复，已不是最长子字符串
            if(hashMap.containsKey(ch)){
                start = Math.max(hashMap.get(ch) + 1,start);
            }
            max = Math.max(max,end-start+1);
            hashMap.put(ch,end);
        }
        return max;
    }
}
