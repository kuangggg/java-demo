import java.util.logging.Level;
import java.util.logging.Logger;

public class OriginLog {

    public static void main(String[] args) {

//        Logger.getGlobal().setLevel(Level.OFF);
        // 全局日志
        Logger.getGlobal().info("my global log");

        Logger.getLogger(OriginLog.class.getName()).info("my log");

    }
}
