package com.wjy.dsalgo.looplist;

import java.util.ArrayList;
import java.util.List;

public class SimpleLoopListTest {

    public static void main(String[] args) {

        // tes data
        String s = "abcde";
        String goal = "cdeab";
        List<Character> data = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            data.add(s.charAt(i));
        }
        List<Character> subData = new ArrayList<>(goal.length());
        for (int i = 0; i < s.length(); i++) {
            subData.add(goal.charAt(i));
        }

        SimpleLoopList<Character> simpleRing = new SimpleLoopList(data);
        System.out.println(simpleRing.isContainList(subData));
        System.out.println(simpleRing.isContainList(data));
        System.out.println(simpleRing.isLoopContainList(subData));
    }

}
