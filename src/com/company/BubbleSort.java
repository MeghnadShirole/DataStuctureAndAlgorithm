package com.company;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of integers to sort: ");
        int count = scanner.nextInt();

        String[] array = new String[count];	//array to store integers

        //fills the array asking user input
        System.out.print("Enter integers to sort: ");
        for(int i = 0; i < count; i++) {
            array[i] = String.valueOf(scanner.nextInt());
        }

        bubbleSort(array);	//sorts the array

        //prints the array
        for(String element : array) {
            System.out.println(element);
        }
        scanner.close();
    }
    public static void bubbleSort(String[] binaryStringArray) {

        int n = binaryStringArray.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (n - 1 - i); j++) {
                if(binaryStringArray[j].compareTo(binaryStringArray[j+1]) < 0) {
                    String temp = binaryStringArray[j];
                    binaryStringArray[j] = binaryStringArray[j+1];
                    binaryStringArray[j+1] = temp;
                }
            }
        }

    }
}