package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;
import java.lang.Math;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        double out = 0.0;
        for (Double number : numbers) {
            out += number;
        }
        out = out/numbers.size();
        return out;
    }

        // TODO: Implement this method to return the average of all the numbers in the input ArrayList
        //       If the ArrayList is empty, return 0.0
        //
        // Examples
        // [1.0,2.0,3.0] returns 2.0
        // [-5.0,5.0] returns 0.0
        // [6.5,6.5,8.5,8.5] returns 7.5
        // [] returns 0.0


    public static int sumOfDigits(int numbers){
        int out = 0;
        int temp = Math.abs(numbers);
        while (temp>0){
            out+=temp%10;
            temp=temp/10;
        }
        return out;
 }
    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9
    public static String bestKey(HashMap<String, Integer> args){
        if (args.isEmpty()){
            return "";
        }
        int MaxVal = 0;
        boolean s = true;
        String out = "";
        for (String i: args.keySet()){
            if (s){
                out = i;
                MaxVal = args.get(i);
                s = false;
            }
            if (args.get(i) > MaxVal){
                MaxVal = args.get(i) ;
                out = i;
            }
        }
        return out;
    }
    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""

}
