package com.company;

import java.util.Scanner;

public class BinarySearchTree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of test cases: ");
        int n = scanner.nextInt();
        scanner.close();

        //prints number of binary trees possible
        System.out.println("Number of binary trees possible: "
                + treeCount(n));
    }

    public static int treeCount(int number) {
        int intSum = 0;
        if(number == 0 || number == 1) {
            return 1;
        } else if(number == 2) {
            return 2;
        } else {
            for(int i = 0; i < number; i++) {
                intSum = intSum + treeCount(i) * treeCount(number - i - 1);
            }
            return intSum;
        }
    }

    /**
     * @param xCoOrdinate x coordinate of the point
     * @param yCoOrdinate y coordinate of the point
     * returns distance between given point and origin
     */
    public double measureDistance(double xCoOrdinate, double yCoOrdinate) {
        return Math.pow((Math.pow(xCoOrdinate , 2) + Math.pow(yCoOrdinate , 2)), 0.5);
    }
}