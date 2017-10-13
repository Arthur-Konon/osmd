package com.arthsoft.osmd.util;

import com.arthsoft.osmd.annotations.Language;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppUtils {
    private static final String LANGUAGE = "language";

    private static Properties appProps;
    static {
        appProps = new Properties();
        InputStream stream = AppUtils.class.getClassLoader().getResourceAsStream("app.properties");
        try {
            appProps.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Language getLanguage() {
        return Language.valueOf(appProps.getProperty(LANGUAGE));
    }
}
