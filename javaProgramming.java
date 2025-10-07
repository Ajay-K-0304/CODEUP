import java.util.Scanner;

// Custom class to perform various string operations manually
class MyString {
    char[] value;

    // Constructor: stores the string as a character array
    public MyString(String str) {
        this.value = (str.toCharArray());
    }

    // Append: manually appends a new string to the current one
    public String append(String newStr) {
        int i;
        char newValue[] = newStr.toCharArray();
        int n = newStr.length() + value.length;

        // Create temporary array to hold both strings
        char[] temp = new char[n];

        // Copy existing characters
        for (i = 0; i < value.length; i++) {
            temp[i] = value[i];
        }

        // Append new string at the end
        for (int j = i, k = 0; j < n; j++, k++) {
            temp[j] = newValue[k];
        }

        // Convert character array back to string
        String ans = new String(temp);
        return ans;
    }

    // Trim: removes leading and trailing spaces manually
    public static String trimString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        int st = 0;
        int end = str.length() - 1;

        // Move start index forward to skip leading spaces
        while (st <= end && Character.isWhitespace(str.charAt(st))) {
            st++;
        }

        // Move end index backward to skip trailing spaces
        while (end >= st && Character.isWhitespace(str.charAt(end))) {
            end--;
        }

        // If string only contains spaces, return empty string
        if (st > end) {
            return "";
        }

        // Extract the portion between st and end
        return str.substring(st, end);
    }

    // CountWords: counts the number of words separated by spaces
    public int countWords(String str) {
        int count = 0;
        String res = trimString(str);
        char newChar[] = res.toCharArray();

        // Count spaces as word separators
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] == ' ') {
                count++;
            }
        }

        // Number of words = number of spaces + 1
        count++;
        return count;
    }

    // isPalindrome: checks if string reads the same forwards and backwards
    public boolean isPalindrome(String str) {
        char newChar[] = str.toCharArray();

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (newChar[i] != newChar[j]) {
                return false; // mismatch found
            }
        }
        return true;
    }

    // Splice: removes a portion of the string starting at stIdx of length len
    public String splice(String str, int stIdx, int len) {
        char CharArray[] = str.toCharArray();

        // Create new array after removing selected portion
        char ans[] = new char[str.length() - len];

        // Copy characters before the removed portion
        for (int i = 0; i < stIdx; i++) {
            ans[i] = CharArray[i];
        }

        // Copy characters after the removed portion
        int ansIdx = stIdx;
        for (int i = stIdx + len; i < str.length(); i++) {
            ans[ansIdx] = CharArray[i];
            ansIdx++;
        }

        return new String(ans);
    }

    // maxRepeat: finds the most frequent character in the string
    public char maxRepeat(String str) {
        int freq[] = new int[256]; // supports all ASCII characters
        char CharArray[] = str.toCharArray();

        // Count frequency of each character
        for (char ch : CharArray) {
            freq[ch]++;
        }

        int maxFrequency = 0;
        char maxFreqChar = '\0';

        // Find the character with the maximum frequency
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFrequency) {
                maxFrequency = freq[i];
                maxFreqChar = (char) i;
            }
        }

        return maxFreqChar;
    }

    // sort: sorts the characters of the string in ascending order
    public String sort(String str) {
        char org[] = str.toCharArray();
        int n = org.length;

        // Bubble sort algorithm
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

    // split: splits the string into an array of words manually
    public String[] split(String str) {
        char[] chars = str.toCharArray();
        String[] temp = new String[chars.length]; // temporary storage
        int index = 0;
        String word = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && chars[i] != '\t') {
                // build the word
                word += chars[i];
            } else {
                // space found, store word if not empty
                if (word.length() > 0) {
                    temp[index++] = word;
                    word = "";
                }
            }
        }

        // add the last word if present
        if (word.length() > 0) {
            temp[index++] = word;
        }

        // copy only valid words (ignore nulls)
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // shift: performs a left rotation of characters by the given moves
    public String shift(String str, int moves) {
        char org[] = str.toCharArray();
        int n = str.length();
        int j = 0;
        char ans[] = new char[n];

        // copy characters after 'moves' index
        for (int i = moves; i < n; i++) {
            ans[j] = org[i];
            j++;
        }

        // copy the first 'moves' characters at the end
        for (int i = 0; i < moves; i++) {
            ans[j] = org[i];
            j++;
        }

        return new String(ans);
    }

    // reverse: reverses the given string manually
    public String reverse(String str) {
        char org[] = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        // swap characters from both ends
        while (left <= right) {
            char ch = org[left];
            org[left] = org[right];
            org[right] = ch;
            left++;
            right--;
        }
        return new String(org);
    }

    // replace: replaces all occurrences of substring a with b manually
    public String replace(String str, String a, String b) {
        char[] main = str.toCharArray();
        char[] oldStr = a.toCharArray();
        char[] newStr = b.toCharArray();

        String result = "";
        int i = 0;

        while (i < main.length) {
            boolean match = true;

            // check if substring starting at i matches a
            for (int j = 0; j < oldStr.length && i + j < main.length; j++) {
                if (main[i + j] != oldStr[j]) {
                    match = false;
                    break;
                }
            }

            // if match is found, append b instead of a
            if (match) {
                for (int k = 0; k < newStr.length; k++) {
                    result += newStr[k];
                }
                i += oldStr.length; // skip the replaced part
            } else {
                // no match, copy current character
                result += main[i];
                i++;
            }
        }

        return result;
    }
}

// Main class: menu-driven program for string operations
public class javaProgramming {
    public static void main(String[] args) {
        int choice;
        String str;
        String temp;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Input String");
        str = sc.nextLine();

        MyString ms = new MyString(str);

        while (true) {
            temp = "";
            System.out.println("Select Operation");
            System.out.println("1.Append\n2.CountWords\n3.Replace\n4.isPalindrome\n5.Splice\n6.Split\n7.MaxRepeatingCharacter\n8.Sort\n9.Shift\n10.Reverse\n11.Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter string to append");
                    temp = sc.nextLine();
                    String ans = ms.append(temp);
                    System.out.println(ans);
                    break;

                case 2:
                    System.out.println("Enter string");
                    temp = sc.nextLine();
                    int wordC = ms.countWords(temp);
                    System.out.println("Words Count: " + wordC);
                    break;

                case 3:
                    System.out.println("Enter string");
                    temp = sc.nextLine();
                    System.out.println("Enter string a and b for replacement");
                    String first = sc.nextLine();
                    String second = sc.nextLine();
                    String replaces = ms.replace(temp, first, second);
                    System.out.println("Replaced: " + replaces);
                    break;

                case 4:
                    System.out.println("Enter string to check");
                    temp = sc.nextLine();
                    boolean isPali = ms.isPalindrome(temp);
                    System.out.println("Palindrome: " + isPali);
                    break;

                case 5:
                    System.out.println("Enter string");
                    temp = sc.nextLine();
                    System.out.println("Enter starting index and length");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    String spliced = ms.splice(temp, a, b);
                    System.out.println("Spliced: " + spliced);
                    break;

                case 6:
                    System.out.println("Enter string to split into words");
                    temp = sc.nextLine();
                    String words[] = ms.split(temp);
                    System.out.print("Array of words:");
                    for (String wd : words) {
                        System.out.print("{" + wd + "}");
                    }
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Enter string");
                    temp = sc.nextLine();
                    char maxR = ms.maxRepeat(temp);
                    System.out.println("Maximum Repeating Character: " + maxR);
                    break;

                case 8:
                    System.out.println("Enter String to sort");
                    temp = sc.nextLine();
                    String sorted = ms.sort(temp);
                    System.out.println("Sorted: " + sorted);
                    break;

                case 9:
                    System.out.println("Enter string to shift and moves");
                    temp = sc.nextLine();
                    int moves = sc.nextInt();
                    String shifted = ms.shift(temp, moves);
                    System.out.println("Shifted: " + shifted);
                    break;

                case 10:
                    System.out.println("Enter string to reverse");
                    temp = sc.nextLine();
                    String reversed = ms.reverse(temp);
                    System.out.println("Reversed: " + reversed);
                    break;

                case 11:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
