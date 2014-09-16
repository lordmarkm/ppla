package com.ppla.security.reference;

/**
 * @author mbmartinez
 */
public abstract class Roles {

    public static final String ADMIN = "ADMIN";
    public static final String MANAGER = "ROLE_MANAGER";
    public static final String OPERATOR = "ROLE_OPERATOR";
    public static final String WAREHOUSE = "ROLE_WAREHOUSE";
    public static final String MIXER = "ROLE_MIXER";
    public static final String EXTRUDER = "ROLE_EXTRUDER";
    public static final String PRINTER = "ROLE_PRINTER";
    public static final String CUTTER = "ROLE_CUTTER";

    public static String asRole(String role) {
        return "ROLE_" + role;
    }
}
