package com.company.PrimeNumber;

import java.util.Arrays;

public class PrimeAnagramPalindrome {

    public static void main(String[] args) {

        //	prime numbers array between 0 and 1000
        String[] primeNumbers = PrimeNumberUtility.prime(1000);

        System.out.println("Anagram and prime numbers are:");
        //	prints prime numbers that are anagrams
        for(int i = 0; i < primeNumbers.length; i++) {
            for(int j = i + 1; j < primeNumbers.length; j++) {
                if(anagram(primeNumbers[i], primeNumbers[j])) {
                    System.out.println(primeNumbers[i] + " " + primeNumbers[j]);
                }
            }
        }

        System.out.println("\nPalindrome and prime numbers are:");
        //	prints prime numbers that are palindrome
        for (String primeNumber : primeNumbers) {
            if (palindrome(primeNumber)) {
                System.out.println(primeNumber);
            }
        }
    }

    public static boolean anagram(String string1, String string2) {
        if(string1.length() != string2.length()) {
            return false;
        }
        char[] array1 = string1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = string2.toCharArray();
        Arrays.sort(array2);

        for(int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param string- string to check for palindrome
     * @returns true if the string is palindrome else returns false
     */
    public static boolean palindrome(String string) {
        if(string.length() < 2) {
            return false;
        }
        char[] array = string.toCharArray();
        int n = array.length;
        for(int i = 0; i < n; i++) {
            if(array[i] != array[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}