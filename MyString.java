/*
@Filename - MyString.java
@Description - Class where our own methods are defined
@Author - Ajay Kumawat
 */
package org.example;

public class MyString {
    private String str="MyString";
    MyString(String str){
        this.str=str;
    }
    @Override public String toString() {
        return this.str;
    }
    public void append(String str){
         this.str += str;
    }
    public int countWords(){
        int counts=0;
        for(int i=0;i<this.str.length();i++){
            if(this.str.charAt(i)==' '){
                counts++;
            }
        }
        return  ++counts;
    }
    public String replace(String a, String b) {
        char[] main = this.str.toCharArray();
        char[] oldStr = a.toCharArray();
        char[] newStr = b.toCharArray();

        String result = "";
        int i = 0;

        while (i < main.length) {
            boolean match = true;

            // Check if substring starting at i matches 'a'
            for (int j = 0; j < oldStr.length && i + j < main.length; j++) {
                if (main[i + j] != oldStr[j]) {
                    match = false;
                    break;
                }
            }

            // If a match is found
            if (match) {
                // Append b
                for (int k = 0; k < newStr.length; k++) {
                    result += newStr[k];
                }
                i += oldStr.length; // Skip past the matched part
            } else {
                // No match, copy the current character
                result += main[i];
                i++;
            }
        }

        return result;
    }
    public String reverse(){
        int n=this.str.length()-1;
        String ans="";
       for(int i=n;i>=0;i--){
           ans+=this.str.charAt(i);
       }
       return ans;
    }
    public boolean isPalindrome(){
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(this.str.charAt(i)!=this.str.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public String splice(int stIdx,int len){
        String str = this.str;
        char CharArray[]=str.toCharArray();
        char ans[]=new char[str.length()-len];
        for(int i=0;i<stIdx;i++){
            ans[i]=CharArray[i];
        }
        int ansIdx=stIdx;
        for(int i=stIdx+len;i<str.length();i++){
            ans[ansIdx]=CharArray[i];
            ansIdx++;
        }
        return new String(ans);
    }
    public String[] split() {
        String str = this.str;
        char[] chars = str.toCharArray();
        String[] temp = new String[chars.length]; // temporary storage
        int index = 0;
        String word = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && chars[i] != '\t') {
                word += chars[i];
            } else {
                if (word.length() > 0) {
                    temp[index++] = word;
                    word = "";
                }
            }
        }

        // Add last word if exists
        if (word.length() > 0) {
            temp[index++] = word;
        }

        // Now create exact-sized result array (no nulls)
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
    public char maxRepeat(){
        String str = this.str;
        int freq[]=new int[256];
        char CharArray[]=str.toCharArray();
        for(char ch : CharArray){
            freq[ch]++;
        }
        int maxFrequency = 0;
        char maxFreqChar = '\0';
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFrequency) {
                maxFrequency = freq[i];
                maxFreqChar = (char) i;
            }
        }
        return maxFreqChar;
    }
    public String sort(){
        String str =  this.str;
        char org[]=str.toCharArray();
        int n=org.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (org[j] > org[j + 1]) {
                    char temp = org[j];
                    org[j] = org[j + 1];
                    org[j + 1] = temp;
                }
            }
        }
        return new String(org);
    }
    public String shift(int moves){
        String str = this.str;
        char org[]=str.toCharArray();
        int n = str.length();
        int j=0;
        char ans[]=new char[n];
        for(int i=moves;i<n;i++){

            ans[j]=org[i];
            j++;
        }
        for(int i=0;i<moves;i++){
            ans[j]=org[i];
            j++;
        }

        return new String(ans);
    }
}
