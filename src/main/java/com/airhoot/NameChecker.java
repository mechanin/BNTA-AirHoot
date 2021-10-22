package com.airhoot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChecker {


    public static final Pattern VALID_NAME_REGEX =
            Pattern.compile("^[\\w'\\-,.][^0-9_!¡?÷?¿/\\\\+=@#$%ˆ&*(){}|~<>;:[\\]]{2,}$");

    public static boolean validate(String name) {
        Matcher matcher = VALID_NAME_REGEX.matcher(name);
        return matcher.find();
    }
}
