/*
@author: Yogesh Prabhukhanolkar
@Problem Statement: 
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:All given inputs are in lowercase letters a-z.
@link: https://leetcode.com/problems/longest-common-prefix/
@stats: Runtime: 4 ms, faster than 94.82% of C++ online submissions for Longest Common Prefix.
        Memory Usage: 9.3 MB, less than 6.45% of C++ online submissions for Longest Common Prefix.
Approach: We use associative property of string prefix to calculate prefix of two consecutive strings in given list in each iteration. First value is prefix obtained from prefix calculation in previous loop while second value is the string value in the list at i'th(current loop) position. At the end , we get common prefix. we break the loop whenever the two string don't have a matching prefix.
*/
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        if(&strs == nullptr){
            return ""; //In case null ref is passed.
        }
        if(strs.size() == 0){
            return ""; //In case vector is empty
        }
        if(strs.size() == 1){
            return strs[0]; //In case vector has single value.
        }
        
        string clcp = strs[0];
        for(int i= 1;i<strs.size();i++){
            clcp = getLCP(clcp,strs[i]);
            if(clcp == ""){
                return clcp;
            }
        }
        return clcp;
    }
    
    /* 
    Utility to calculate prefix of two strings.
    */
   string getLCP(string a, string b){
       
        string result = "";
        int l1 = a.length();
        int l2 = b.length();
        int min = (l1<l2)?l1:l2;
        
        for(int i=0;i< min ;i++){
            if(a[i] == b[i]){
                result+= a[i];
            } 
            else{
                return result;
            }
        }
        return result;
    }
};