package main.java.ua.nure.chub;


import java.util.ResourceBundle;
import java.text.MessageFormat;

/**
 * Author Lera
 * created 04.11.2017.
 */
public class MyBundle {
    private static final ResourceBundle bundle = ResourceBundle.getBundle(
            "words");

    public static String getString(String key, Object... params) {
        String value = bundle.getString(key);
        if (params.length > 0) return MessageFormat.format(value, params);
        return value;
    }
}
