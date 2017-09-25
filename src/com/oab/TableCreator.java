package com.oab;

/**
 * Created by bao on 2017/6/24.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("argument: annotated class");
            System.exit(0);
        }

        for (String arg : args) {
            Class<?> clazz = Class.forName(arg);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotation in class " + arg);
                continue;
            }

            String name = dbTable.name();

        }
    }
}
