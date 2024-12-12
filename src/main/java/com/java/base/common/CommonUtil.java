package com.java.base.common;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jimjian on 2016/10/20.
 */
public class CommonUtil {
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public void Money() {
        //        元
        BigDecimal bigDecimal = new BigDecimal("88.11");
//        bigDecimal=bigDecimal.movePointLeft(2);
        bigDecimal = bigDecimal.movePointRight(2);
        System.out.println(bigDecimal.longValue());
    }
}
