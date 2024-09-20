package ru.meldren.functionalprogramming.lab1;

import java.math.BigInteger;

public class Task20 {

    public int digitSum(BigInteger n) {
        int sum = 0;
        String str = n.toString();
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

    private BigInteger findFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
