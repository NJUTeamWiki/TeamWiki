package cn.edu.nju.teamwiki.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author: xuyangchen
 * @date: 2020/4/9
 */
public class TimeUtils {

    public static String getPrettyGapString(LocalDateTime ldt) {
        LocalDateTime now = LocalDateTime.now();
        long gap = now.toEpochSecond(ZoneOffset.UTC) - ldt.toEpochSecond(ZoneOffset.UTC);
        if (ldt.plusMinutes(1).isAfter(now)) {
            return String.format("%d seconds ago", gap);
        } else if (ldt.plusHours(1).isAfter(now)) {
            return String.format("%d minutes ago", gap / 60);
        } else if (ldt.plusDays(1).isAfter(now)) {
            return String.format("%d hours ago", gap / 3600);
        } else {
            return String.format("%d days ago", gap / 86400);
        }
    }
}
