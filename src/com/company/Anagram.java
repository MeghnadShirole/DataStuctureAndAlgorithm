package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() != str2.length()) {
            System.out.println("Strings are not anagram");
        }
        else {

            //converting string to char array
            char[] string1 = str1.toCharArray();
            char[] string2 = str2.toCharArray();

            //sort array
            Arrays.sort(string1);
            Arrays.sort(string2);

            //checking both have same elements or not
            if(Arrays.equals(string1, string2)) {
                System.out.println("Strings are anagram");
            }
            else {
                System.out.println("Strings are not anagram");
            }
        }
    }
}