/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lokalise.dateandtime.DateAndTime;
import com.lokalise.javapluralization.AppleCountMsg;
import java.text.ChoiceFormat;
import java.util.Locale;

/**
 *
 * @author Dasun Nirmitha
 */
public class Main {
    public static void main(String[] args) {        
        printAppleCountMsgs();
        printCurrentDateAndTime();
    }
    
    public static void printAppleCountMsgs() {
        System.out.println(AppleCountMsg.getAppleCountMsg(0));
        System.out.println(AppleCountMsg.getAppleCountMsg(1));
        System.out.println(AppleCountMsg.getAppleCountMsg(24884));
        
        ChoiceFormat appleCountMsgChoiceFormat = AppleCountMsg.getAppleCountMsgChoiceFormat();
        System.out.println(AppleCountMsg.getAppleCountMsg(appleCountMsgChoiceFormat, 0));
        System.out.println(AppleCountMsg.getAppleCountMsg(appleCountMsgChoiceFormat, 1));
        System.out.println(AppleCountMsg.getAppleCountMsg(appleCountMsgChoiceFormat, 24884));
    }
    
    public static void printCurrentDateAndTime() {
        DateAndTime dateAndTime = new DateAndTime();
        Locale locale = new Locale("en", "US");
        System.out.println(dateAndTime.getCurrentDateAndTime(locale));
    }
}
