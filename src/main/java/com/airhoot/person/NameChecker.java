package com.airhoot.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChecker {


    public static final Pattern VALID_NAME_REGEX =
            Pattern.compile("^[A-Z][a-z]+\\s[A-Z][a-z]+$");

    public static boolean validate(String name) {
        Matcher matcher = VALID_NAME_REGEX.matcher(name);
        return matcher.matches();
    }
}
