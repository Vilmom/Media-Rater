package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblemSet {
    private final double EPSILON = 0.001;
    @Test
    public void averageTest() {
        assertTrue(Math.abs(ProblemSet.average(new ArrayList<>(Arrays.asList(1.0,2.0,3.0))) - 2.0)<EPSILON);
    }
    @Test
    public void averageTestZero() {
        assertTrue(Math.abs(ProblemSet.average(new ArrayList<>(Arrays.asList(-5.0,5.0))))<EPSILON);
    }
    @Test
    public void averageTestNeg() {
        assertTrue(Math.abs(ProblemSet.average(new ArrayList<>(Arrays.asList(-5.0,-5.0))) + 5.0)<EPSILON);
    }
    @Test
    public void averageTestDecimal() {
        assertTrue(Math.abs(ProblemSet.average(new ArrayList<>(Arrays.asList(6.5, 6.5, 8.5, 8.5))) - 7.5)<EPSILON);
    }
    @Test
    public void averageTestEmpty(){
        assertTrue(Math.abs(ProblemSet.average(new ArrayList<>())-0.0)<EPSILON);
    }
    @Test
    public void averageTestSingle(){
        assertTrue(Math.abs(ProblemSet.average(new ArrayList<>(Arrays.asList(2.1)))-2.1)<EPSILON);
    }
    @Test
    public void sumTestThree() {
        assertTrue(ProblemSet.sumOfDigits(123) == 6);
    }
    @Test
    public void sumTestTwo() {
        assertTrue(ProblemSet.sumOfDigits(57) == 12);
    }
    @Test
    public void sumTestNeg() {
        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
    }
    @Test
    public void sumTestZero(){
    assertTrue(ProblemSet.sumOfDigits(0)==0);
    }
    @Test
    public void keyTestThree() {
        assertTrue(ProblemSet.bestKey(new HashMap<String, Integer>() {{
            put("CSE", 100);
            put("MTH", 90);
            put("MGT", 10);
        }}).equals("CSE"));
    }
    @Test
    public void keyTestEmpty() {
        assertTrue(ProblemSet.bestKey(new HashMap<String, Integer>()).equals(""));
    }
    @Test
    public void keyTestOr(){
        for (boolean b : new boolean[]{ProblemSet.bestKey(new HashMap<String, Integer>() {{
            put("cat", 5);
            put("dog", 5);
            put("fox", 4);
        }}).equals("cat") || ProblemSet.bestKey(new HashMap<String, Integer>() {{
            put("cat", 5);
            put("dog", 5);
            put("fox", 4);
        }}).equals("dog"), ProblemSet.bestKey(new HashMap<String, Integer>()).equals("")}) {
            assertTrue(b);
        }
    }
    @Test
    public void keyTestNegative(){
        assertTrue(ProblemSet.bestKey(new HashMap<String, Integer>() {{
            put("I", -100);
            put("Don't", -90);
            put("Know", -10);
        }}).equals("Know"));
    }

    @Test
    public void keyTestOne(){
        assertTrue(ProblemSet.bestKey(new HashMap<String, Integer>() {{
            put("",0);
        }}).equals(""));
    }
    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class


}