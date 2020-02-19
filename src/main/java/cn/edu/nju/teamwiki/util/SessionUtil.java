package cn.edu.nju.teamwiki.util;

import javax.servlet.http.HttpSession;

/**
 * @author: xuyangchen
 * @date: 2020/2/18
 */
public class SessionUtil {

    private static final String SESSION_UID = "uid";

    public static boolean hasUser(HttpSession session) {
        return session.getAttribute(SESSION_UID) != null;
    }

    public static void setUser(HttpSession session, String userId) {
        session.setAttribute(SESSION_UID, userId);
    }

    public static String getUser(HttpSession session) {
        return (String) session.getAttribute(SESSION_UID);
    }

    public static void removeUser(HttpSession session) {
        session.removeAttribute(SESSION_UID);
    }
}
