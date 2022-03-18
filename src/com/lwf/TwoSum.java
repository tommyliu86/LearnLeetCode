package com.lwf;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.允许负数！
 *
 */
public class TwoSum {
Lock lock   =new ReentrantLock();
Condition iseven=lock.newCondition();
Condition isodd=lock.newCondition();
    public int[] twoSum(int[] numbers, int target) {
        for (int i = numbers.length-1; i >0; i--) {
            if (numbers[i]+numbers[0]<=target){
                for (int j = 0; j < i; j++) {
                     if (numbers[j]+numbers[i]==target){
                        return new int[]{j+1,i+1};
                    }
                }
            }
        }
        return null;
    }
}
