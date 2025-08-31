package rave.code.utility.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

/**
 * Hello world!
 */
public class JavaUtilLogDecor extends Formatter {

    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[92m";
    private static final String YELLOW = "\u001B[93m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String WHITE = "\u001B[97m";
    private static final String BLACK = "\u001B[30m";
    private static final String RESET = "\u001B[0m";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {

        String color;
        switch (record.getLevel().getName()) {
            case "SEVERE":
                color = RED;
                break;
            case "WARN":
                color = YELLOW;
                break;
            case "INFO":
                color = GREEN;
                break;
            case "CONFIG":
                color = BLUE;
                break;
            default:
                color = RESET;
        }

        String timestamp = this.dateFormat.format(new Date(record.getMillis()));
        String loggerName = record.getLoggerName();
        if (loggerName == null) {
            loggerName = record.getSourceClassName();
        }

        return String.format("%s%s[%s] %s - %s%s%n",
                color,
                timestamp,
                record.getLevel().getName(),
                loggerName,
                formatMessage(record),
                RESET
        );
    }

    public static void setupLogDecor() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.INFO);
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler h : handlers) {
            h.setFormatter(new JavaUtilLogDecor());
        }
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
    }
}
