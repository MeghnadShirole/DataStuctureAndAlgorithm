package com.company.PrimeNumber;

import com.company.dataStructure.MyQueue;

import java.util.Arrays;

public class PrimeAnagramQueue {

    MyQueue<Integer> myQueue ;	//	queue
    PrimeNumber2dArray object;

    public static void main(String[] args) {

        //	class object
        PrimeAnagramQueue primeAnagramQueue = new PrimeAnagramQueue();
        primeAnagramQueue.fillQueue();
    }


    /** finds prime anagrams and queues them into the queue **/
    void fillQueue() {
        object = new PrimeNumber2dArray();
        object.findPrimes();
        myQueue = new MyQueue<Integer>();

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < object.primeNumbers[i].length; j++) {
                int num = object.primeNumbers[i][j];
                for(int k = j+1; k < object.primeNumbers[i].length; k++) {
                    if(isAnagram(num, object.primeNumbers[i][k])){
                        myQueue.enqueue(num);
                        myQueue.enqueue(object.primeNumbers[i][k]);
                        break;
                    }
                }
            }
        }

        print();
    }

    /**
     * @param firstInterger - first number
     * @param secondInteger - second number
     * @returns true if numbers are anagram else returns false
     */
    boolean isAnagram(int firstInterger, int secondInteger) {
        if(firstInterger < 10) {
            return false;
        }

        return anagram(String.valueOf(firstInterger),
                String.valueOf(secondInteger));
    }

    public boolean anagram(String string1, String string2) {
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

    /** prints the queue **/
    void print() {
        while(!myQueue.isEmpty())
            System.out.println(myQueue.dequeue() + " " + myQueue.dequeue());
    }
}