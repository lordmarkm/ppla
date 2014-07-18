package com.ppla.security.reference;

/**
 * @author mbmartinez
 */
public abstract class Roles {

    public static final String ADMIN = "ADMIN"; 
    public static final String OPERATOR = "OPERATOR";

    public static String asRole(String role) {
        return "ROLE_" + role;
    }
}
