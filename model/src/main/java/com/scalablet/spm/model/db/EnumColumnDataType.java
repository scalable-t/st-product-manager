package com.scalablet.spm.model.db;

/**
 * Data type
 *
 * @author abomb4 2020-08-10 01:53:49 +0800
 */
public enum EnumColumnDataType {
    /**  */
    VARCHAR("String", "varchar"),
    /**  */
    INTEGER("Integer", "int"),
    /**  */
    LONG("Long", "bigint"),
    /**  */
    DECIMAL("java.math.BigDecimal", "decimal"),

    ;
    private final String javaTypeName;
    private final String mysqlTypeName;

    EnumColumnDataType(String javaTypeName, String mysqlTypeName) {
        this.javaTypeName = javaTypeName;
        this.mysqlTypeName = mysqlTypeName;
    }

    public String getJavaTypeName() {
        return javaTypeName;
    }

    public String getMysqlTypeName() {
        return mysqlTypeName;
    }
}
