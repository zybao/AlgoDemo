package com.oab;

/**
 * Created by bao on 2017/6/24.
 */
@DBTable(name = "MENBER")
public class Menber {
    @SQLString(20)
    String firstName;
    @SQLString(20)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, costraints = @Constraints(primaryKey = true))
    String handle;

    static int menberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMenberCount() {
        return menberCount;
    }
}
