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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        MyString s = new MyString(str);
        System.out.println(s);
        s.append("CLASS");
        System.out.println(s);
        s.countWords();
        System.out.println(s.countWords());
        String ans =s.reverse();
        System.out.println(ans);
        System.out.println(s.isPalindrome());
        System.out.println(s.splice(2,2));
        String arr[]=s.split();
        System.out.println(Arrays.toString(arr));
        System.out.println("Max Repeating Char:"+s.maxRepeat());
        System.out.println("Sorted:"+s.sort());
        System.out.println("Shifted:"+s.shift(3));
        System.out.println("Replaced:"+s.replace("a","o"));
    }
}