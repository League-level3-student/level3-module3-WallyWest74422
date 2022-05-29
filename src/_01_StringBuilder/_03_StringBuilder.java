package _01_StringBuilder;

import java.nio.file.attribute.AclEntry.Builder;

public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	StringBuilder helper = new StringBuilder(str);
    	helper.append(characters);
        return helper.toString();
    }
    
    public static String reverse(String str) {
    	StringBuilder helper = new StringBuilder(str);
    	helper.reverse();
        return helper.toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder helper = new StringBuilder(str);
    	helper.insert(index, newChar);
        return helper.toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder helper = new StringBuilder(str);
    	helper.delete(startIndex, endIndex);
        return helper.toString();
    }
}