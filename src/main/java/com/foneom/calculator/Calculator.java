package com.foneom.calculator;

public class Calculator {

    public static int sqrt(int value) {
        int low = 0;
        int high = value;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int root = mid * mid;
            if (root == value) {
                return mid;
            }
            if (root > value) {
                high = mid - 1;
            }
            if (root < value) {
                low = mid + 1;
            }
        }
        return (low - 1);
    }

    public static int res() {
        int result = 5 / 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(36));
        System.out.println(res() );
    }
}
