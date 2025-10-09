import java.util.HashSet;
import java.util.Scanner;

public class assign2 {//Helper for countUniquePalindromes
    public static boolean isPalindrome(String tempString) {
        int i = 0, j = tempString.length() - 1;
        while (i < j) {
            if (tempString.charAt(i) != tempString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void countUniquePalindromes(String inpuString) {
        HashSet<String> uniqueCollection = new HashSet<>();

        for (int i = 0; i < inpuString.length(); i++) {
            for (int j = i + 1; j <= inpuString.length(); j++) { // +1 so substring includes char at j-1
                String subStr = inpuString.substring(i, j);
                if (subStr.length() > 1 && isPalindrome(subStr)) {
                    uniqueCollection.add(subStr);
                }
            }
        }

        System.out.println("Number of unique palindromes:"+uniqueCollection.size());
    }
    public static void findNthFibonacciNumber(int n){

        // First two Fibonacci numbers
        int a = 1, b = 1, c = 0;

        if (n == 1 || n == 2) {
            System.out.println(a);
            return;
        }

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println("Nth number is:"+c);
    }
    public static void toCamelCase(String str) {
        String[] words = str.split("_");
        StringBuilder result = new StringBuilder(words[0]);  // first word stays lowercase

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))  // capitalize first letter
                      .append(word.substring(1));                     // append rest
            }
        }
        System.out.println("CamelCase:"+result.toString());
    }
    public static void countConsonants(String inpuString){
        String str = inpuString.toLowerCase();  // make lowercase for easy comparison

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {  // check if alphabet
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    count++;
                }
            }
        }

        System.out.println("Number of consonants: " + count);
    }
    public static void binaryToDecimal(String binary){
        int decimal = 0;
        int power = 1; // represents 2^0 initially

        // loop from rightmost bit to leftmost
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);

            if (bit == '1') {
                decimal += power;
            }
            // move to next power of 2
            power *= 2;
        }

        System.out.println("Decimal equivalent: " + decimal);
    }
    public static void expandCharacters(String inpuString){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inpuString.length(); i += 2) {
            char ch = inpuString.charAt(i);
            int count = inpuString.charAt(i + 1) - '0'; // convert char digit to int

            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }

        System.out.println("Expanded string: " + result.toString());
    }
    public static void characterFreqInString(String inpuString){
        StringBuilder result = new StringBuilder();

        int count = 1;  // track frequency
        for (int i = 0; i < inpuString.length(); i++) {
            // if next char is same, increase count
            if (i < inpuString.length() - 1 && inpuString.charAt(i) == inpuString.charAt(i + 1)) {
                count++;
            } else {
                // append current char and its count
                result.append(inpuString.charAt(i));
                result.append(count);
                count = 1; // reset count for next char
            }
        }

        System.out.println("Compressed form: " + result.toString());
    }
    public static void checkPrime(int number){
        if (number <= 1) {
            System.out.println("The given number is NOT prime");
            return;
        }

        boolean isPrime = true;

        for (int i = 2; i * i <= number; i++) {  // check up to sqrt(n)
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("The given number is prime");
        } else {
            System.out.println("The given number is NOT prime");
        }
    }
    public static void numberToWords(int num){

        if (num < 0 || num > 99) {
            System.out.println("Number out of range (0-99)");
            return;
        }

        String[] belowTwenty = {"zero", "one", "two", "three", "four", "five",
                                "six", "seven", "eight", "nine", "ten", "eleven",
                                "twelve", "thirteen", "fourteen", "fifteen",
                                "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", 
                         "sixty", "seventy", "eighty", "ninety"};

        String result = "";

        if (num < 20) {
            result = belowTwenty[num];
        } else {
            int tenPart = num / 10;
            int unitPart = num % 10;
            result = tens[tenPart];
            if (unitPart != 0) {
                result += " " + belowTwenty[unitPart];
            }
        }

        System.out.println("Number is:"+result);
    }
    public static void longestSubstringWithoutRepeatingCharacters(String s){
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character is already in set, remove from left until unique
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("Length of longest stubstring without repeating character:"+maxLength);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String input;
        
        
        while (true) {
            System.out.println("1.Count Unique Palindromes");
            System.out.println("2.Nth number in fibonacci");
            System.out.println("3.Snake to camel case");
            System.out.println("4.Count consonants");
            System.out.println("5.Binary to Decimal");
            System.out.println("6.Characters in string");
            System.out.println("7.Character frequency in string");
            System.out.println("8.Primer number checker");
            System.out.println("9.Numbers to word converter");
            System.out.println("10.Longest substring without repeating character");
            System.out.println("11.Exit");
            System.out.println("Select Operation");
            choice = sc.nextInt();
            sc.nextLine();
            input="";
            switch (choice) {
                case 1:
                    System.out.println("Enter string");
                    input = sc.nextLine();
                    countUniquePalindromes(input);
                    break;
                case 2:
                    System.out.println("Enter number");
                    int num = sc.nextInt();
                    findNthFibonacciNumber(num);
                    break;
                case 3:
                    System.out.println("Enter snake_case string");
                    input = sc.nextLine();
                    toCamelCase(input);
                    break;
                case 4:
                    System.out.println("Enter string");
                    input=sc.nextLine();
                    countConsonants(input);
                    break;
                case 5:
                    System.out.println("Enter binary value");
                    input=sc.nextLine();
                    binaryToDecimal(input);
                    break;
                case 6:
                    System.out.println("Enter string");
                    input=sc.nextLine();
                    expandCharacters(input);
                    break;
                case 7:
                    System.out.println("Enter string");
                    input=sc.nextLine();
                    characterFreqInString(input);
                    break;
                case 8:
                    System.out.println("Enter number to check");
                    int number = sc.nextInt();
                    checkPrime(number);
                    break;
                case 9:
                    System.out.println("Enter number");
                    int inputNum=sc.nextInt();
                    numberToWords(inputNum);
                    break;
                case 10:
                    System.out.println("Enter string");
                    input=sc.nextLine();
                    longestSubstringWithoutRepeatingCharacters(input);
                    break;
                case 11:
                    System.out.println("Exiting the program ! Thank You....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
