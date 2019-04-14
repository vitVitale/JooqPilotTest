package utills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class Utill {
    private static final Logger LOG = LoggerFactory.getLogger(Utill.class);

    @FunctionalInterface
    public interface WaitingResponseFromQuery<T> {
        T getResult(Map m);
    }

    @FunctionalInterface
    public interface WaitingResponse<T> {
        T getResult();
    }

    @Deprecated
    public static <T> boolean activeWaitCheck(T expectedVal, Utill.WaitingResponseFromQuery<T> actualVal) {
        return activeWaitCheck(expectedVal, actualVal);
    }

    public static <T> boolean activeWaitCheck(T expectedVal, Utill.WaitingResponse<T> actualVal) {
        return activeWaitCheck(expectedVal, actualVal, 3000);
    }

    public static <T> boolean activeWaitCheck(T exitValue, Utill.WaitingResponse<T> checkedValue, long waitReplication) {
        int tryCounter = 0;
        long timeOutTime = System.currentTimeMillis() + 40000L;
        while (timeOutTime > System.currentTimeMillis()) {
            if (exitValue.equals(checkedValue.getResult())) {
                return true;
            }
            try {
                Thread.sleep(waitReplication);
            } catch (InterruptedException ex) {
                LOG.error("Error " + ex);
                Thread.currentThread().interrupt();
            }
            System.out.println(String.format("\n===== Попытка номер: %d =====",++tryCounter));
        }
        return false;
    }
}
