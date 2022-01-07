package com.gussoft.utils;

public class knowSO {
    public static void main(String[] args) {
        boolean is64bit = false;
        if (System.getProperty("os.name").contains("Windows")) {
            is64bit = (System.getenv("ProgramFiles(x86)") != null);
        } else {
            is64bit = (System.getProperty("os.Arch").contains("64"));
        }
        System.out.println("is64bit = " + is64bit);
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("java.specification.version"));
        System.out.println(System.getProperty("Sun.Arch.data.model"));
    }
}
