import org.jooq.*;
import org.jooq.impl.DSL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Logger;

import static jooq.base.Tables.TABLE_1;
import static jooq.base.tables.Clients.CLIENTS;

//import static org.jooq.sources.tables.Clients.CLIENTS;
//import static org.jooq.sources.tables.Table_1.TABLE_1;


public class Application {
    public static Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws Exception {

        String user = "postgres";
        String password = "1234";
        String url = "jdbc:postgresql://127.0.0.1:5432/TESRT";

        try (Connection con = DriverManager.getConnection(url, user, password)){
            DSLContext dsl = DSL.using(con, SQLDialect.POSTGRES_9_5);

            List<CardsRecords> result = dsl.select().from(TABLE_1).fetch().into(CardsRecords.class);
            result.forEach(cardReq -> {
                log.info("ID: "+cardReq.getId()
                        +" Aliace: "+cardReq.getCardAliace()
                        +" Date :"+cardReq.getDate()
                        +"\n===========================================");
            });

            System.out.println();

            List<Clients> res2 = dsl.select(CLIENTS.ID.as("id"),CLIENTS.FIRST_NAME,
                    TABLE_1.CARD_ALIACE,TABLE_1.ID.as("cardId")).from(CLIENTS)
                    .leftJoin(TABLE_1).on(CLIENTS.CARD_ID.eq(TABLE_1.ID))
                    .where(TABLE_1.CARD_ALIACE.eq("MIR"))
                    .fetch().into(Clients.class);

            res2.forEach(cardReq -> {
                log.info("ID: "+cardReq.getId()
                        +" First Name: "+cardReq.getFirstName()
                        +" Aliace: "+cardReq.getCardAliace()
                        +" CardID :"+cardReq.getCardId()
                        +"\n===========================================");
            });

            System.out.println();

            dsl.select(CLIENTS.ID.as("id"),CLIENTS.FIRST_NAME,
                    TABLE_1.CARD_ALIACE,TABLE_1.ID.as("cardId")).from(CLIENTS)
                    .leftJoin(TABLE_1).on(CLIENTS.CARD_ID.eq(TABLE_1.ID))
                    .where(TABLE_1.CARD_ALIACE.eq("MIRYL"))
                    .queryTimeout(60000).fetch();

            /*dsl.insertInto(TABLE_1).columns(TABLE_1.ID,TABLE_1.CARD_ALIACE,TABLE_1.DATE)
                    .values(3728,"VISA CLASSIC","17.09.2017").execute();*/
        }
    }
}