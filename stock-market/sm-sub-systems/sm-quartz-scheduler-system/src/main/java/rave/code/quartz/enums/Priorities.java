package rave.code.quartz.enums;

public enum Priorities {

    LOW(1), MID(5), HIGH(10);

    private int priority;

    private Priorities(int priority){
        this.priority = priority;
    }

    public int get() {
        return priority;
    }
}
