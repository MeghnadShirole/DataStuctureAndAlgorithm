package com.company.PrimeNumber;

public class PrimeNumberUtility {

    /**
     * @param range- up to which prime numbers are to be found
     * @returns string array of prime numbers in  a given range
     */
    public static String[] prime(int range) {
        String[] array = new String[1000];
        int position = 0;
        for(int i = 2; i <= range; i++) {
            boolean isPrime = true;
            for(int j = 2; j <= i / 2; j++) {
                if((i % j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                array[position] = String.valueOf(i);
                position++;
            }
        }
        String[] returnArray = new String[position];
        for(int k = 0; k < position; k++) {
            returnArray[k] = array[k];
        }
        return returnArray;
    }
}
