package _02_The_Wave;

import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
    	String lowStr = str.toLowerCase();
        String[] strArray = str.split("");
        ArrayList<String> wave = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
        	StringBuilder builder = new StringBuilder(lowStr);
        	if(strArray[i].equalsIgnoreCase(" ")){
        		
        	}else {
			builder.deleteCharAt(i);
			builder.insert(i,strArray[i].toUpperCase());
			System.out.println(builder.toString());
String waveSequence = builder.toString();	
wave.add(waveSequence);
        	}
		}
        return wave;
    }
}
