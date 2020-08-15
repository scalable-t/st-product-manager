package com.scalablet.spm.storage;

import com.scalablet.spm.model.db.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Storage api for Model
 *
 * @author yangrl14628 2020-08-12 10:38:47
 */
public interface ModelStorage {

    /**
     * Save a table model, contains all columns
     *
     * @param table Table model
     * @return id
     */
    Long save(Table table);

    /**
     * Remove a table
     *
     * @param id id to remove
     */
    void delete(String id);

    /**
     * Update a table, remove all columns as request
     *
     * @param table Table will update to
     */
    void update(Table table);

    /**
     * List all tables. I think this project may not contains TOO MANY TABLES, so return all.
     *
     * @return All tables
     */
    List<Table> listTables();

    /**
     * Load a table
     *
     * @param id id
     * @return Table info
     */
    Table loadTable(String id);
}
