package com.yangqingmang.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/2 上午11:00
 */
public class HttpConfig {

    public static final String SERVER_URL = "127.0.0.1";

    public static final String SERVER_PORT = "8080";

    public static final String getUrl(String requestUrl) {
        return "http://" + SERVER_URL + ":" + SERVER_PORT + "/" + requestUrl;
    }
}
