/**
 * Description: This is the singleton object of the application.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.singleton;

import java.util.UUID;

public class SigletonObj {
    private static class Helper {
        private static final SigletonObj INSTANCE = new SigletonObj();
    }

    /**
     * getInstance method
     */
    public static SigletonObj getInstance() {
        return Helper.INSTANCE;
    }

    private SigletonObj() {
        // randomUUID
        mStringId = UUID.randomUUID().toString();
    }

    // string id
    private final String mStringId;

    // get id
    public String getId() {
        return mStringId;
    }

    /**
     * log method
     * @param message message
     * @return log message
     */
    public String log(String message) {
        return "[" + mStringId.substring(0, 6) + "] " + message;
    }

}
