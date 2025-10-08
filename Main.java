/*
@Filename - Main.java
@Description - Main class to implement custom string operations
@Author - Ajay Kumawat
 */
package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String temp;
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        MyString s = new MyString(str);
        while(true){
            temp="";
            System.out.println("Select Operation");
            System.out.println("1.Append\n2.CountWords\n3.Replace\n4.isPalindrome\n5.Splice\n6.Split\n7.MaxRepeatingCharacter\n8.Sort\n9.Shift\n10.Reverse\n11.Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter string to append");
                    temp = sc.nextLine();
                    s.append(temp);
                    System.out.println("Appended:"+s);
                    break;
                case 2:
                    int wordC = s.countWords();
                    System.out.println("Words Count:"+wordC);
                    break;
                case 3:
                    System.out.println("Enter source and pattern for replacement");
                    String source = sc.nextLine();
                    String pattern = sc.nextLine();
                    String replaced = s.replace(source,pattern);
                    System.out.println("Replaced:"+replaced);
                    break;
                case 4:
                    boolean isPalind = s.isPalindrome();
                    System.out.println("Palindrome:"+isPalind);
                    break;
                case 5:
                    System.out.println("Enter starting index and length");
                    int stIdx=sc.nextInt();
                    int len=sc.nextInt();
                    String spliced  = s.splice(stIdx,len);
                    System.out.println("Spliced:"+spliced);
                    break;
                case 6:
                    String words[] = s.split();
                    System.out.print("Array of words:");
                    for(String wd:words){
                        System.out.print("{"+wd+"}");
                    }
                    System.out.println();
                    break;
                case 7:
                    char maxRepeatingChar=s.maxRepeat();
                    System.out.println("Maximum Repeating Character:"+maxRepeatingChar);
                    break;
                case 8:
                    String sorted = s.sort();
                    System.out.println("Sorted:"+sorted);
                    break;
                case 9:
                    System.out.println("Enter moves");
                    int moves=sc.nextInt();
                    String shifted = s.shift(moves);
                    System.out.println("Shifted:"+shifted);
                    break;
                case 10:
                    String reversed = s.reverse();
                    System.out.println("Reversed:"+reversed);
                    break;
                case 11:System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        }
//        System.out.println(s);
//        s.append("CLASS");
//        System.out.println(s);
//        s.countWords();
//        System.out.println(s.countWords());
//        String ans =s.reverse();
//        System.out.println(ans);
//        System.out.println(s.isPalindrome());
//        System.out.println(s.splice(2,2));
//        String arr[]=s.split();
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Max Repeating Char:"+s.maxRepeat());
//        System.out.println("Sorted:"+s.sort());
//        System.out.println("Shifted:"+s.shift(3));
//        System.out.println("Replaced:"+s.replace("a","o"));
    }
}