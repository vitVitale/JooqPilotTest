/*
 * This file is generated by jOOQ.
 */
package jooq.base;


import javax.annotation.Generated;

import jooq.base.tables.Clients;
import jooq.base.tables.Viewcardinfo;
import jooq.base.tables.records.ClientsRecord;
import jooq.base.tables.records.ViewcardinfoRecord;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ClientsRecord> ID_PKEY = UniqueKeys0.ID_PKEY;
    public static final UniqueKey<ViewcardinfoRecord> VIEWCARDINFO_PKEY = UniqueKeys0.VIEWCARDINFO_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ClientsRecord, ViewcardinfoRecord> CLIENTS__CARD_ID_FKEY = ForeignKeys0.CLIENTS__CARD_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<ClientsRecord> ID_PKEY = Internal.createUniqueKey(Clients.CLIENTS, "ID_pkey", Clients.CLIENTS.ID);
        public static final UniqueKey<ViewcardinfoRecord> VIEWCARDINFO_PKEY = Internal.createUniqueKey(Viewcardinfo.VIEWCARDINFO, "ViewCardInfo_pkey", Viewcardinfo.VIEWCARDINFO.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ClientsRecord, ViewcardinfoRecord> CLIENTS__CARD_ID_FKEY = Internal.createForeignKey(jooq.base.Keys.VIEWCARDINFO_PKEY, Clients.CLIENTS, "CLIENTS__Card_ID_fkey", Clients.CLIENTS.CARD_ID);
    }
}