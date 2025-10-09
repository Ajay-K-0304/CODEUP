/*
@Filename - MyString.java
@Description - Class where our own methods are defined
@Author - Ajay Kumawat
 */
package org.example;

public class MyString {
    private String value="MyString";
    MyString(String value){
        this.value=value;
    }
    @Override public String toString() {
        return this.value;
    }
    public void append(String value){
         this.value += " "+value;//Appends new string to current string
    }
    public int countWords(){
        int counter=0;
        for(int i=0;i<this.value.length();i++){
            if(this.value.charAt(i)==' '){ //Counts space separated words
                counter++;
            }
        }
        return  ++counter;
    }
    public String replace(String source, String pattern) {
        char[] main = this.value.toCharArray();
        char[] oldStr = source.toCharArray();
        char[] newStr = pattern.toCharArray();

        String result = "";
        int i = 0;

        while (i < main.length) {
            boolean match = true;

            // Check if substring starting at i matches 'source'
            for (int j = 0; j < oldStr.length && i + j < main.length; j++) {
                if (main[i + j] != oldStr[j]) {
                    match = false;
                    break;
                }
            }

            // If a match is found
            if (match) {
                // Append pattern
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
        int n = this.value.length()-1;
        String ans="";
       for(int i=n;i>=0;i--){
           ans+=this.value.charAt(i);
       }
       return ans;
    }
    public boolean isPalindrome(){
        for(int i=0,j=value.length()-1;i<j;i++,j--){
            if(this.value.charAt(i)!=this.value.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public String splice(int stIdx,int len){
        String value = this.value;
        char[] CharArray =value.toCharArray();
        char[] answerArray =new char[value.length()-len];
        if (stIdx >= 0) System.arraycopy(CharArray, 0, answerArray, 0, stIdx);
        int ansIdx=stIdx;
        for(int i=stIdx+len;i<value.length();i++){
            answerArray[ansIdx]=CharArray[i];
            ansIdx++;
        }
        return new String(answerArray);
    }
    public String[] split() {
        String value = this.value;
        char[] chars = value.toCharArray();
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
        System.arraycopy(temp, 0, result, 0, index);

        return result;
    }
    public void maxRepeat(){
        String value = this.value;
        int[] freqArray =new int[256];
        char[] CharArray =value.toCharArray();
        for(char ch : CharArray){
            freqArray[ch]++;
        }
        int maxFrequency = 0;
        char maxFreqChar = '\0';
        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] > maxFrequency && i!=32) {
                maxFrequency = freqArray[i];
                maxFreqChar = (char) i;
            }
        }
        System.out.println("Character:"+maxFreqChar+" with Frequency:"+maxFrequency);
    }
    public String sort(){
        String value =  this.value;
        char[] orgArray =value.toCharArray();
        int n=orgArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orgArray[j] > orgArray[j + 1]) {
                    char temp = orgArray[j];
                    orgArray[j] = orgArray[j + 1];
                    orgArray[j + 1] = temp;
                }
            }
        }
        return new String(orgArray);
    }
    public String shift(int moves){
        String value = this.value;
        char[] orgArray =value.toCharArray();
        int n = value.length();
        int j=0;
        char[] ansArray =new char[n];
        for(int i=moves;i<n;i++){

            ansArray[j]=orgArray[i];
            j++;
        }
        for(int i=0;i<moves;i++){
            ansArray[j]=orgArray[i];
            j++;
        }

        return new String(ansArray);
    }
}
