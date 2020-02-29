package cn.edu.nju.teamwiki.util;

import java.util.UUID;

/**
 * @author: xuyangchen
 * @date: 2020/2/29
 */
public class DBUtils {

    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String randomShortUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 4);
    }

}
