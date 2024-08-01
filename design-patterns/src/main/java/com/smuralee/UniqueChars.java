package com.smuralee;
import java.io.Serializable;

public class UniqueChars implements Serializable {

    // Guarantees any change is visible to all threads
    private static volatile UniqueChars uniqueCharsObj = null;

    private UniqueChars() {
        // Private constructor
    }

    public static void main(String[] args) {
        UniqueChars chars = getInstance();
        boolean isUnique = chars.isUniqueChars("Absolute");
        System.out.println(isUnique);
    }

    // Ensuring mutual exclusion with synchronized
    public synchronized static UniqueChars getInstance() {
        if (uniqueCharsObj == null) {
            uniqueCharsObj = new UniqueChars();
        }

        return uniqueCharsObj;
    }

    public boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;

        }
        return true;

    }
}
