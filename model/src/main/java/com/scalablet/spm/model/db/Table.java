package com.scalablet.spm.model.db;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Table model
 *
 * @author abomb4 2020-08-10 01:30:26 +0800
 */
@Data
public class Table implements Serializable {

    private static final long serialVersionUID = -6075038032657766298L;

    /** id */
    private Long id;
    /** snake_case table name */
    private String tableCode;
    /** Localized table name */
    private String tableDisplayName;
    /** Columns in this table */
    private List<Column> columns;
    /** Description, optional */
    private String description;

    /**
     * Get the column name in Camel format with the first letter lowercase.
     *
     * @return The column name in Camel format with the first letter lowercase.
     */
    public String getTableCodeCamelCaseLower() {
        return getTableCodeCamelCase(false);
    }

    /**
     * Get the column name in Camel format with the first letter uppercase.
     *
     * @return The column name in Camel format with the first letter uppercase.
     */
    public String getTableCodeCamelCaseUpper() {
        return getTableCodeCamelCase(true);
    }

    // -=-=-=-=-=-=-=-=-=-=-=- Helpers -=-=-=-=-=-=-=-=-=-=-=-
    /**
     * Get the column name in Camel format.
     *
     * @param firstUppercase The first letter should be uppercase
     * @return name
     */
    private String getTableCodeCamelCase(boolean firstUppercase) {
        if (tableCode == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(tableCode.length());
        boolean upNext = firstUppercase;
        for (char c : tableCode.toCharArray()) {
            if ('_' == c) {
                upNext = true;
            } else {
                sb.append(upNext ? Character.toUpperCase(c) : c);
                upNext = false;
            }
        }
        return sb.toString();
    }
}
