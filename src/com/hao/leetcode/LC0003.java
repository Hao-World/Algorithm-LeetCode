package com.hao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * **[无重复字符的最长子串]**
 * 
 * 
 * @author hao
 *
 */
public class LC0003 {
	 public int lengthOfLongestSubstring(String s) {
		 return 0;
	 }
	 /**
	  * 滑动窗口 Map
	  * @param s
	  * @return
	  */ 
	 public int Solution1(String s) {
		 int n = s.length(),ans = 0;
		 Map<Character,Integer> map = new HashMap<>();
		 for(int i=0,j=0;j<n;j++) {
			 if(map.containsKey(s.charAt(j))) {
				 i=Math.max(map.get(s.charAt(j)), i);
			 }
			 ans = Math.max(ans,j-i+1);
			//这里value 的值为更新 i 的位置 
			//即如果发现相同的字符，就将i移动重复字符的下一个位置
			 map.put(s.charAt(j),j+1); 
		 }
		 return ans;
	 }
}
