package com.smsserver.web.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class JavaConfig {

    public String[] webConfig() throws Exception {
        Properties prop = new Properties();
        InputStream resourceAsStream = JavaConfig.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            if (resourceAsStream != null) {
                prop.load(resourceAsStream);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        String[] Config = new String[3];
        System.err.println("Host:" + prop.getProperty("hosts"));
        System.err.println("username:" + prop.getProperty("username"));
        System.err.println("secret:" + prop.getProperty("secret"));
        Config[0] = prop.getProperty("hosts");
        Config[1] = prop.getProperty("username");
        Config[2] = prop.getProperty("secret");

        return Config;

    }

}
