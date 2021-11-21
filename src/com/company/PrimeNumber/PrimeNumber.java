package com.company.PrimeNumber;
public class PrimeNumber {

    public static void main(String[] args) {

        String[] integerArray = PrimeNumberUtility.prime(1000);	//	prime number array
        for(String string : integerArray) {	//	printing the array
            System.out.println(string);
        }
    }
}