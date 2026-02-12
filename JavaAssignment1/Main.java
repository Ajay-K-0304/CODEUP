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
        String input;
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        input = sc.nextLine();
        MyString s = new MyString(input);
        while(true){
            System.out.println("Current String:"+s);
            input="";
            System.out.println("Select Operation");
            System.out.println("1.Append\n2.CountWords\n3.Replace\n4.isPalindrome\n5.Splice\n6.Split\n7.MaxRepeatingCharacter\n8.Sort\n9.Shift\n10.Reverse\n11.Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter string to append");
                    input = sc.nextLine();
                    s.append(input);
                    System.out.println("Appended:"+s);
                    break;
                case 2:
                    int countOfWords = s.countWords();
                    System.out.println("Words Count:"+countOfWords);
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
                    String splicedString  = s.splice(stIdx,len);
                    System.out.println("Spliced:"+splicedString);
                    break;
                case 6:
                    String[] arrayOfWords = s.split();
                    System.out.print("Array of words:");
                    System.out.print("[");
                    for(String wd:arrayOfWords){
                        System.out.print(wd+",");
                    }
                    System.out.print("]");
                    System.out.println();
                    break;
                case 7:
                    s.maxRepeat();
                    break;
                case 8:
                    String sortedString = s.sort();
                    System.out.println("Sorted:"+sortedString);
                    break;
                case 9:
                    System.out.println("Enter moves");
                    int moves=sc.nextInt();
                    String shiftedString = s.shift(moves);
                    System.out.println("Shifted:"+shiftedString);
                    break;
                case 10:
                    String reversedString = s.reverse();
                    System.out.println("Reversed:"+reversedString);
                    break;
                case 11:System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        }

    }
}
