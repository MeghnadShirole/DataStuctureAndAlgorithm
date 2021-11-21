package com.company;

import java.util.Scanner;

    public class InsertionSort {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);	//	scanner to get user input
            System.out.println("Enter number of words to sort: ");
            int count = scanner.nextInt();	//	count of words
            String[] strings = new String[count];	//	string array to store words
            System.out.println("Enter words to sort: ");
            //	filling the array
            for(int i = 0; i < count; i++) {
                strings[i] = scanner.next();
            }

            //	sorting words in the array
          insertionSortAscending(strings);

            //	printing sorted array
            for(String string : strings) {
                System.out.println(string);
            }
            scanner.close();
        }


    public static void insertionSortAscending(String[] binaryStringArray) {

        for (int i = 1; i < binaryStringArray.length; i++) {
            String key = binaryStringArray[i];
            int j = i - 1;
            while ((j > -1) && (binaryStringArray[j].compareTo(key) > 0)) {
                binaryStringArray[j + 1] = binaryStringArray[j];
                j--;
            }
            binaryStringArray[j + 1] = key;
        }
    }
}
