package test;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {

    }
}