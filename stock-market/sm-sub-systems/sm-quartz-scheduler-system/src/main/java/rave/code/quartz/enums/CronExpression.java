package rave.code.quartz.enums;

public enum CronExpression {

    NOW("* * * ? * SUN-SAT"),
    EVERY_3RD_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS("* */3 * * * ?"),
    EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS("* */5 * * * ?"),
    EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY("* */3 * ? * MON-FRI"),
    EVERY_5TH_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY("* */5 * ? * MON-FRI"),
    EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM("* 15-59/3 9-10 ? * MON-FRI"),
    EVERY_3RD_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM("* */3 10-16 ? * MON-FRI"),
    EVERY_5TH_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_9_15AM_TO_10AM("* 15-59/5 9-10 ? * MON-FRI"),
    EVERY_5TH_MINUTE_OF_THE_CLOCK_FROM_MONDAY_TO_FRIDAY_BETWEEN_10AM_TO_4PM("* */5 10-16 ? * MON-FRI"),
    AT_8AM_MONDAY_TO_FRIDAY("0 0 8 ? * MON-FRI"),
    AT_4PM_MONDAY_TO_FRIDAY("0 0 16 ? * MON-FRI"),

    AT_06_PM_MONDAY_TO_FRIDAY("0 0 18 ? * MON-FRI"),
    BETWEEN_08_45_TO_08_59_AM_MONDAY_TO_FRIDAY("0 45-59 8 ? * MON-FRI"),
    BETWEEN_09_00_TO_09_08_AM_MONDAY_TO_FRIDAY("0 00-08 9 ? * MON-FRI"),
    BETWEEN_02_05_TO_02_20_PM_MONDAY_TO_FRIDAY("0 05-20 14 ? * MON-FRI");

    private String cronExpression;

    private CronExpression(String cronExp){
        this.cronExpression = cronExp;
    }

    @Override
    public String toString() {
        return this.cronExpression;
    }
}
