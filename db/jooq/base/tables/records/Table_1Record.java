/*
 * This file is generated by jOOQ.
 */
package jooq.base.tables.records;


import javax.annotation.Generated;

import jooq.base.tables.Table_1;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Table_1Record extends UpdatableRecordImpl<Table_1Record> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1441326277;

    /**
     * Setter for <code>public.TABLE_1.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.TABLE_1.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.TABLE_1.CARD_ALIACE</code>.
     */
    public void setCardAliace(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.TABLE_1.CARD_ALIACE</code>.
     */
    public String getCardAliace() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.TABLE_1.DATE</code>.
     */
    public void setDate(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.TABLE_1.DATE</code>.
     */
    public String getDate() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Table_1.TABLE_1.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Table_1.TABLE_1.CARD_ALIACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Table_1.TABLE_1.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCardAliace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCardAliace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Table_1Record value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Table_1Record value2(String value) {
        setCardAliace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Table_1Record value3(String value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Table_1Record values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Table_1Record
     */
    public Table_1Record() {
        super(Table_1.TABLE_1);
    }

    /**
     * Create a detached, initialised Table_1Record
     */
    public Table_1Record(Integer id, String cardAliace, String date) {
        super(Table_1.TABLE_1);

        set(0, id);
        set(1, cardAliace);
        set(2, date);
    }
}