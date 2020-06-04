/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokalise.javapluralization;

import java.text.ChoiceFormat;

/**
 *
 * @author Dasun Nirmitha
 */
public class AppleCountMsg {
    public static String getAppleCountMsg(int count) {
        if (count == 1) {
            return "1 apple";
        } else if (count == 0 || count > 1) {
            return count + " apples";
        } else {
            return "You don't count apples in minus numbers! Please input a whole number";
        }
    }   
    
    public static ChoiceFormat getAppleCountMsgChoiceFormat() {
        double[] minAppleCount = {0, 1, 2};
        String[] appleCountFormat = {"apples", "apple", "apples"};  
        return new ChoiceFormat(minAppleCount, appleCountFormat);
    }
    
    public static String getAppleCountMsg(ChoiceFormat appleCountChoiceFormat, int count) {
        return count + " " + appleCountChoiceFormat.format(count); 
    }
}
