package com.scalablet.spm.model.db;

import lombok.Data;

/**
 * Column definition
 *
 * @author abomb4 2020-08-10 01:37:48 +0800
 */
@Data
public class Column {
    /** snake_case column name */
    private String columnCode;
    /** Column name localized */
    private String columnDisplayName;
    /** Description, optional */
    private String description;
    /** Table belongs to */
    private String tableCode;
    /** Is not null */
    private boolean notNull;
    /** Data type */
    private EnumColumnDataType dataType;
    /**
     * String value max length, or numeric precision.
     * varchar(${maxLength}), decimal(${maxLength}, ${scale})
     */
    private int maxLength;
    /** Decimal value scale */
    private int scale;
    /** Position in table */
    private int position;
}
