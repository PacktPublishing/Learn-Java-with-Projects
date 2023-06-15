package ch12.exercises;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Exercise12_2 {
}


class EventLogger {
    private HashMap<String, LocalDateTime> eventLog;

    public EventLogger() {
        eventLog = new HashMap<>();
    }

    public void logEvent(String event, LocalDateTime eventTime) {
        eventLog.put(event, eventTime);
    }
}
