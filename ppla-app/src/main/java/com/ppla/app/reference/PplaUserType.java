package com.ppla.app.reference;

/**
 * @author Mark
 */
public enum PplaUserType {
    ADMIN,

    /**
     * Same as admin, but can't edit stuff
     */
    MANAGER,

    /**
     * General purpose operator, can oversee processes but not start them
     */
    OPERATOR,

    WAREHOUSE,
    MIXER,
    EXTRUDER,
    CUTTER,
    PRINTER,

    /**
     * Unknown, catch things like "Engineering"
     */
    OTHER
}
