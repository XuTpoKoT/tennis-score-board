package com.tsb.util;

public class JspPath {
    private static final String pathJsp = "/%s.jsp";

    public static String getPathJsp(String content) {
        return String.format(pathJsp, content);
    }
}
