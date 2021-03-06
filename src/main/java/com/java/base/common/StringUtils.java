package com.java.base.common;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StringUtils {

    private StringUtils() {
    }

    public static String defaultString(final String str, final String defaultStr) {
        return str == null ? defaultStr : str;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String toString(final Object object) {
        if (object == null) {
            return "null";
        }
        return object.toString();
    }

    public static List<String> splitAndTrim(String value, String separator) {
        if(isEmpty(value)) {
            return Collections.emptyList();
        }
        if (separator == null) {
            throw new NullPointerException("separator must not be null");
        }
        final List<String> result = new ArrayList<String>();
        // TODO remove regex 'separator'
        final String[] split = value.split(separator);
        for (String method : split) {
            if (isEmpty(method)) {
                continue;
            }
            method = method.trim();
            if (method.isEmpty()) {
                continue;
            }
            result.add(method);
        }
        return result;
    }

    public static String drop(final String str) {
        return drop(str, 64);
    }

    public static String drop(final String str, final int length) {
        if (str == null) {
            return "null";
        }
        if (length < 0) {
            throw new IllegalArgumentException("negative length:" + length);
        }
        if (str.length() > length) {
            StringBuilder buffer = new StringBuilder(length + 10);
            buffer.append(str, 0, length);
            appendDropMessage(buffer, str.length());
            return buffer.toString();
        } else {
            return str;
        }
    }

    public static void appendDrop(StringBuilder builder, final String str, final int length) {
        if (str == null) {
            return;
        }
        if (length < 0) {
            return;
        }
        if (str.length() > length) {
            builder.append(str, 0, length);
            appendDropMessage(builder, str.length());
        } else {
            builder.append(str);
        }
    }

    private static void appendDropMessage(StringBuilder buffer, int length) {
        buffer.append("...(");
        buffer.append(length);
        buffer.append(')');
    }
}
