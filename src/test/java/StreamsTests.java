import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Test;
import utills.Utill;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static jooq.base.tables.Clients.CLIENTS;
import static jooq.base.tables.Viewcardinfo.VIEWCARDINFO;


public class StreamsTests {
    Logger LOG = Logger.getLogger(Application.class.getName());
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/TestBase";
    private static DSLContext dslContext;

    static {
        try {
            dslContext = DSL.using(DriverManager.getConnection(URL, USER, PASSWORD), SQLDialect.POSTGRES_10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cards> emps = Arrays.asList(
            new Cards(1005, "RUB"),
            new Cards(23, "EUR"),
            new Cards(365, "RUB"),
            new Cards(75, "USD"),
            new Cards(63, "EUR")
    );

    //========================================================================================
    //========================================================================================

    //@Test
    public void creation() throws IOException {
        System.out.println();
        List list1 = emps.stream().sorted(Comparator.comparing(Cards::getCurruncy)).collect(Collectors.toList());
        emps.stream().anyMatch(cards -> cards.getCurruncy().equals("RUB"));

    }

    @Test
    public void jooqTest_1() {
        List<CardsRecords> result = dslContext.select().from(VIEWCARDINFO).fetch().into(CardsRecords.class);
        result.forEach(cardReq -> {
            LOG.info("ID: " + cardReq.getId()
                    + " Aliace: " + cardReq.getCardAliace()
                    + " Date :" + cardReq.getDate()
                    + "\n===========================================");
        });
    }

    @Test
    public void jooqTest_2() {
        List<Clients> res2 = dslContext.select(CLIENTS.ID.as("id"), CLIENTS.FIRST_NANE,
                VIEWCARDINFO.CARDALIACE, VIEWCARDINFO.ID.as("cardId")).from(CLIENTS)
                .leftJoin(VIEWCARDINFO).on(CLIENTS.CARD_ID.eq(VIEWCARDINFO.ID))
                .where(VIEWCARDINFO.CARDALIACE.eq("MIR"))
                .fetch().into(Clients.class);

        res2.forEach(cardReq -> {
            LOG.info("ID: " + cardReq.getId()
                    + " First Name: " + cardReq.getFirstName()
                    + " Aliace: " + cardReq.getCardAliace()
                    + " CardID :" + cardReq.getCardId()
                    + "\n===========================================");
        });
    }

    @Test
    public void jooqTest_3() {
        dslContext.insertInto(VIEWCARDINFO).columns(VIEWCARDINFO.ID, VIEWCARDINFO.CARDALIACE, VIEWCARDINFO.DATA)
                .values(8922, "VISA CLASSIC", "17.09.2017").execute();
    }

    @Test
    public void jooqTest_4() {
        dslContext.deleteFrom(VIEWCARDINFO).where(VIEWCARDINFO.ID.eq(8922)).execute();
    }

    @Test
    public void jooqTest_5() {
        dslContext.update(CLIENTS)
                .set(CLIENTS.FIRST_NANE, "Herman")
                .set(CLIENTS.LAST_NAME, "Hesse")
                .where(CLIENTS.CARD_ID.eq(2736))
                .execute();
    }

    @Test
    public void testOfActiveWaitCheck() {
        Assert.assertTrue("Потрачено! ", Utill.activeWaitCheck(false, () -> "1".equals("one")));
        LOG.info("Success !!");
    }

    private Select queryWithArgsNameCard(String name, String cardAliace) {
        Select selectQuery = dslContext.select(CLIENTS.ID.as("id"), CLIENTS.FIRST_NANE,
                VIEWCARDINFO.CARDALIACE, VIEWCARDINFO.ID.as("cardId")).from(CLIENTS)
                .leftJoin(VIEWCARDINFO).on(CLIENTS.CARD_ID.eq(VIEWCARDINFO.ID))
                .where(VIEWCARDINFO.CARDALIACE.eq(cardAliace)).and(CLIENTS.FIRST_NANE.eq(name));
        return selectQuery;
    }

    @Test
    public void testActWaitRequest() {
        Select selectQuery = queryWithArgsNameCard("HERMAN", "VISA");

        Assert.assertTrue("Потрачено! ", Utill.activeWaitCheck(true, () ->
                selectQuery.fetch().isNotEmpty()
        ));
        LOG.info("Success !!");
        List<Clients> client = selectQuery.fetch().into(Clients.class);
        System.out.println();
    }
}
