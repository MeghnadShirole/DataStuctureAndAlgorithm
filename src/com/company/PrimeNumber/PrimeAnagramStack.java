package com.company.PrimeNumber;

import com.company.dataStructure.MyStack;

import java.util.Arrays;

public class PrimeAnagramStack {

    MyStack<Integer> myStack;	//	stack to store prime anagrams
    PrimeNumber2dArray object;

    public static void main(String[] args) {

        //	class object
        PrimeAnagramStack primeAnagramStack = new PrimeAnagramStack();
        primeAnagramStack.fillStack();
    }


    /**
     * fills prime anagrams in the stack
     */
    void fillStack() {
        object = new PrimeNumber2dArray();
        object.findPrimes();
        myStack = new MyStack<Integer>();

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < object.primeNumbers[i].length; j++) {
                int num = object.primeNumbers[i][j];
                for(int k = j+1; k < object.primeNumbers[i].length; k++) {
                    if(isAnagram(num, object.primeNumbers[i][k])){
                        myStack.push(num);
                        myStack.push(object.primeNumbers[i][k]);
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

    /**
     * prints stack elements
     */
    void print() {
        while(!myStack.isEmpty())
            System.out.println(myStack.pop() + " " + myStack.pop());
    }
}