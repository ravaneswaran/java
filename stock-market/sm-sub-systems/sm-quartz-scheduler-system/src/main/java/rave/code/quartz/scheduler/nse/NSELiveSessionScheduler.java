package rave.code.quartz.scheduler.nse;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.jobs.nse.csv.live.etf.NSEExchangeTradedFundDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.mainboard.NSEMainBoardDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.sme.NSESMEDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.spurts.NSEPriceSpurtSPGtr20DetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.spurts.NSEPriceSpurtSPLwr20DetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.spurts.NSEVolumeSpurtsDetailEntityMakerJob;
import rave.code.quartz.jobs.nse.csv.live.top20.gainers.*;
import rave.code.quartz.jobs.nse.csv.live.top20.losers.*;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class NSELiveSessionScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(NSELiveSessionScheduler.class.toString());

    public NSELiveSessionScheduler(Scheduler scheduler) {
        super(scheduler);
    }

    @Override
    public void scheduleJobs() {

        JobDetail nseExchangeTradedFundDetailEntityMakerJobDetail1 = newJob(NSEExchangeTradedFundDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_ETF_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseExchangeTradedFundDetailEntityMakerJobDetail2 = newJob(NSEExchangeTradedFundDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_ETF_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseExchangeTradedFundDetailEntityMakerJobDetail3 = newJob(NSEExchangeTradedFundDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_ETF_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseMainBoardDetailEntityMakerJobDetail1 = newJob(NSEMainBoardDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_MAIN_BOARD_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseMainBoardDetailEntityMakerJobDetail2 = newJob(NSEMainBoardDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_MAIN_BOARD_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseMainBoardDetailEntityMakerJobDetail3 = newJob(NSEMainBoardDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_MAIN_BOARD_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseSMEDetailEntityMakerJobDetail1 = newJob(NSESMEDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SME_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSMEDetailEntityMakerJobDetail2 = newJob(NSESMEDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SME_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSMEDetailEntityMakerJobDetail3 = newJob(NSESMEDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SME_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nsePriceSpurtSPGtr20DetailEntityMakerJobDetail1 = newJob(NSEPriceSpurtSPGtr20DetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_PRICE_SPURT_SP_GTR_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nsePriceSpurtSPGtr20DetailEntityMakerJobDetail2 = newJob(NSEPriceSpurtSPGtr20DetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_PRICE_SPURT_SP_GTR_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nsePriceSpurtSPGtr20DetailEntityMakerJobDetail3 = newJob(NSEPriceSpurtSPGtr20DetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_PRICE_SPURT_SP_GTR_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nsePriceSpurtSPLwr20DetailEntityMakerJobDetail1 = newJob(NSEPriceSpurtSPLwr20DetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_PRICE_SPURT_SP_LWR_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nsePriceSpurtSPLwr20DetailEntityMakerJobDetail2 = newJob(NSEPriceSpurtSPLwr20DetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_PRICE_SPURT_SP_LWR_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nsePriceSpurtSPLwr20DetailEntityMakerJobDetail3 = newJob(NSEPriceSpurtSPLwr20DetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_PRICE_SPURT_SP_LWR_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseVolumeSpurtsDetailEntityMakerJobDetail1 = newJob(NSEVolumeSpurtsDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_VOLUME_SPURT_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseVolumeSpurtsDetailEntityMakerJobDetail2 = newJob(NSEVolumeSpurtsDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_VOLUME_SPURT_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseVolumeSpurtsDetailEntityMakerJobDetail3 = newJob(NSEVolumeSpurtsDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_VOLUME_SPURT_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseBankNiftyTop20GainerDetailEntityMakerJobDetail1 = newJob(NSEBankNiftyTop20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_BANK_NIFTY_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseBankNiftyTop20GainerDetailEntityMakerJobDetail2 = newJob(NSEBankNiftyTop20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_BANK_NIFTY_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseBankNiftyTop20GainerDetailEntityMakerJobDetail3 = newJob(NSEBankNiftyTop20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_BANK_NIFTY_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseFuturesAndOptionTop20GainerDetailEntityMakerJobDetail1 = newJob(NSEFuturesAndOptionTop20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_FO_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseFuturesAndOptionTop20GainerDetailEntityMakerJobDetail2 = newJob(NSEFuturesAndOptionTop20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_FO_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseFuturesAndOptionTop20GainerDetailEntityMakerJobDetail3 = newJob(NSEFuturesAndOptionTop20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_FO_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseNifty50Top20GainerDetailEntityMakerJobDetail1 = newJob(NSENifty50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_50_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNifty50Top20GainerDetailEntityMakerJobDetail2 = newJob(NSENifty50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_50_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNifty50Top20GainerDetailEntityMakerJobDetail3 = newJob(NSENifty50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_50_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseNiftyNext50Top20GainerDetailEntityMakerJobDetail1 = newJob(NSENiftyNext50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_NEXT_50_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNiftyNext50Top20GainerDetailEntityMakerJobDetail2 = newJob(NSENiftyNext50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_NEXT_50_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNiftyNext50Top20GainerDetailEntityMakerJobDetail3 = newJob(NSENiftyNext50Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_NEXT_50_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseSecGtr20Top20GainerDetailEntityMakerJobDetail1 = newJob(NSESecGtr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_GTR_20_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecGtr20Top20GainerDetailEntityMakerJobDetail2 = newJob(NSESecGtr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_GTR_20_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecGtr20Top20GainerDetailEntityMakerJobDetail3 = newJob(NSESecGtr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_GTR_20_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseSecLwr20Top20GainerDetailEntityMakerJobDetail1 = newJob(NSESecLwr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_LWR_20_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecLwr20Top20GainerDetailEntityMakerJobDetail2 = newJob(NSESecLwr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_LWR_20_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecLwr20Top20GainerDetailEntityMakerJobDetail3 = newJob(NSESecLwr20Top20GainerDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_LWR_20_GAINER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseBankNiftyTop20LoserDetailEntityMakerJobDetail1 = newJob(NSEBankNiftyTop20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_BANK_NIFTY_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseBankNiftyTop20LoserDetailEntityMakerJobDetail2 = newJob(NSEBankNiftyTop20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_BANK_NIFTY_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseBankNiftyTop20LoserDetailEntityMakerJobDetail3 = newJob(NSEBankNiftyTop20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_BANK_NIFTY_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseFuturesAndOptionTop20LoserDetailEntityMakerJobDetail1 = newJob(NSEFuturesAndOptionTop20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_FO_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseFuturesAndOptionTop20LoserDetailEntityMakerJobDetail2 = newJob(NSEFuturesAndOptionTop20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_FO_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseFuturesAndOptionTop20LoserDetailEntityMakerJobDetail3 = newJob(NSEFuturesAndOptionTop20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_FO_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseNifty50Top20LoserDetailEntityMakerJobDetail1 = newJob(NSENifty50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_50_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNifty50Top20LoserDetailEntityMakerJobDetail2 = newJob(NSENifty50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_50_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNifty50Top20LoserDetailEntityMakerJobDetail3 = newJob(NSENifty50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_50_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseNiftyNext50Top20LoserDetailEntityMakerJobDetail1 = newJob(NSENiftyNext50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_NEXT_50_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNiftyNext50Top20LoserDetailEntityMakerJobDetail2 = newJob(NSENiftyNext50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_NEXT_50_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseNiftyNext50Top20LoserDetailEntityMakerJobDetail3 = newJob(NSENiftyNext50Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_NEXT_50_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseSecGtr20Top20LoserDetailEntityMakerJobDetail1 = newJob(NSESecGtr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_GTR_20_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecGtr20Top20LoserDetailEntityMakerJobDetail2 = newJob(NSESecGtr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_GTR_20_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecGtr20Top20LoserDetailEntityMakerJobDetail3 = newJob(NSESecGtr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_GTR_20_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        JobDetail nseSecLwr20Top20LoserDetailEntityMakerJobDetail1 = newJob(NSESecLwr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_LWR_20_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecLwr20Top20LoserDetailEntityMakerJobDetail2 = newJob(NSESecLwr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_LWR_20_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();
        JobDetail nseSecLwr20Top20LoserDetailEntityMakerJobDetail3 = newJob(NSESecLwr20Top20LoserDetailEntityMakerJob.class)
                .withIdentity(QuartzJob.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_LWR_20_LOSER_TOP_20_JOB.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName()).storeDurably()
                .build();

        Trigger nseExchangeTradedFundDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_ETF_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseExchangeTradedFundDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_ETF_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseExchangeTradedFundDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_ETF_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseMainBoardDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_MAIN_BOARD_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseMainBoardDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_MAIN_BOARD_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseMainBoardDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_MAIN_BOARD_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseSMEDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SME_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseSMEDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SME_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseSMEDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SME_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nsePriceSpurtSPGtr20DetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_PRICE_SPURT_GTR_20_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nsePriceSpurtSPGtr20DetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_PRICE_SPURT_GTR_20_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nsePriceSpurtSPGtr20DetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_PRICE_SPURT_GTR_20_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nsePriceSpurtSPLwr20DetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_PRICE_SPURT_LWR_20_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nsePriceSpurtSPLwr20DetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_PRICE_SPURT_LWR_20_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nsePriceSpurtSPLwr20DetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_PRICE_SPURT_LWR_20_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseVolumeSpurtsDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_VOLUME_SPURT_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseVolumeSpurtsDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_VOLUME_SPURT_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseVolumeSpurtsDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_VOLUME_SPURT_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseBankNiftyTop20GainerDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_BANK_NIFTY_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseBankNiftyTop20GainerDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_BANK_NIFTY_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseBankNiftyTop20GainerDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_BANK_NIFTY_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseFuturesAndOptionTop20GainerDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_FO_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseFuturesAndOptionTop20GainerDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_FO_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseFuturesAndOptionTop20GainerDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_FO_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseNifty50Top20GainerDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_50_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseNifty50Top20GainerDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_50_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseNifty50Top20GainerDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_50_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseNiftyNext50Top20GainerDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_NEXT_50_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseNiftyNext50Top20GainerDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_NEXT_50_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseNiftyNext50Top20GainerDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_NEXT_50_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseSecGtr20Top20GainerDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_GTR_20_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseSecGtr20Top20GainerDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_GTR_20_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseSecGtr20Top20GainerDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_GTR_20_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseSecLwr20Top20GainerDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_LWR_20_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseSecLwr20Top20GainerDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_LWR_20_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseSecLwr20Top20GainerDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_LWR_20_TOP_20_GAINER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseBankNiftyTop20LoserDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_BANK_NIFTY_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseBankNiftyTop20LoserDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_BANK_NIFTY_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseBankNiftyTop20LoserDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_BANK_NIFTY_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseFuturesAndOptionTop20LoserDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_FO_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseFuturesAndOptionTop20LoserDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_FO_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseFuturesAndOptionTop20LoserDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_FO_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseNifty50Top20LoserDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_50_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseNifty50Top20LoserDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_50_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseNifty50Top20LoserDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_50_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseNiftyNext50Top20LoserDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_NIFTY_NEXT_50_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseNiftyNext50Top20LoserDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_NIFTY_NEXT_50_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseNiftyNext50Top20LoserDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_NIFTY_NEXT_50_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseSecGtr20Top20LoserDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_GTR_20_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseSecGtr20Top20LoserDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_GTR_20_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseSecGtr20Top20LoserDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_GTR_20_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        Trigger nseSecLwr20Top20LoserDetailEntityMakerJobTriggerOne = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_1_SECURITY_LWR_20_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_09_15_AM_TO_09_59_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_1_LIVE_SESSION.get())
                .build();
        Trigger nseSecLwr20Top20LoserDetailEntityMakerJobTriggerTwo = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_2_SECURITY_LWR_20_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_10_00_AM_TO_12_59_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_2_LIVE_SESSION.get())
                .build();
        Trigger nseSecLwr20Top20LoserDetailEntityMakerJobTriggerThree = newTrigger()
                .withIdentity(QuartzTrigger.NSE_T_PLUS_0_LIVE_SESSION_SLOT_3_SECURITY_LWR_20_TOP_20_LOSER_TRIGGER.getShortName(), QuartzGroup.NSE_LIVE_SESSION.getShortName())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.NSE_T_PLUS_0_LIVE_SESSION_BETWEEN_13_00_PM_TO_13_30_PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.NSE_T_PLUS_0_SLOT_3_LIVE_SESSION.get())
                .build();

        try {

            this.scheduler.scheduleJob(nseExchangeTradedFundDetailEntityMakerJobDetail1, nseExchangeTradedFundDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseExchangeTradedFundDetailEntityMakerJobDetail2, nseExchangeTradedFundDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseExchangeTradedFundDetailEntityMakerJobDetail3, nseExchangeTradedFundDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseMainBoardDetailEntityMakerJobDetail1, nseMainBoardDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseMainBoardDetailEntityMakerJobDetail2, nseMainBoardDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseMainBoardDetailEntityMakerJobDetail3, nseMainBoardDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseSMEDetailEntityMakerJobDetail1, nseSMEDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseSMEDetailEntityMakerJobDetail2, nseSMEDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseSMEDetailEntityMakerJobDetail3, nseSMEDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nsePriceSpurtSPGtr20DetailEntityMakerJobDetail1, nsePriceSpurtSPGtr20DetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nsePriceSpurtSPGtr20DetailEntityMakerJobDetail2, nsePriceSpurtSPGtr20DetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nsePriceSpurtSPGtr20DetailEntityMakerJobDetail3, nsePriceSpurtSPGtr20DetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nsePriceSpurtSPLwr20DetailEntityMakerJobDetail1, nsePriceSpurtSPLwr20DetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nsePriceSpurtSPLwr20DetailEntityMakerJobDetail2, nsePriceSpurtSPLwr20DetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nsePriceSpurtSPLwr20DetailEntityMakerJobDetail3, nsePriceSpurtSPLwr20DetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseVolumeSpurtsDetailEntityMakerJobDetail1, nseVolumeSpurtsDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseVolumeSpurtsDetailEntityMakerJobDetail2, nseVolumeSpurtsDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseVolumeSpurtsDetailEntityMakerJobDetail3, nseVolumeSpurtsDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseBankNiftyTop20GainerDetailEntityMakerJobDetail1, nseBankNiftyTop20GainerDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseBankNiftyTop20GainerDetailEntityMakerJobDetail2, nseBankNiftyTop20GainerDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseBankNiftyTop20GainerDetailEntityMakerJobDetail3, nseBankNiftyTop20GainerDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseFuturesAndOptionTop20GainerDetailEntityMakerJobDetail1, nseFuturesAndOptionTop20GainerDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20GainerDetailEntityMakerJobDetail2, nseFuturesAndOptionTop20GainerDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20GainerDetailEntityMakerJobDetail3, nseFuturesAndOptionTop20GainerDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseNifty50Top20GainerDetailEntityMakerJobDetail1, nseNifty50Top20GainerDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseNifty50Top20GainerDetailEntityMakerJobDetail2, nseNifty50Top20GainerDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseNifty50Top20GainerDetailEntityMakerJobDetail3, nseNifty50Top20GainerDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseNiftyNext50Top20GainerDetailEntityMakerJobDetail1, nseNiftyNext50Top20GainerDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseNiftyNext50Top20GainerDetailEntityMakerJobDetail2, nseNiftyNext50Top20GainerDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseNiftyNext50Top20GainerDetailEntityMakerJobDetail3, nseNiftyNext50Top20GainerDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseSecGtr20Top20GainerDetailEntityMakerJobDetail1, nseSecGtr20Top20GainerDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseSecGtr20Top20GainerDetailEntityMakerJobDetail2, nseSecGtr20Top20GainerDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseSecGtr20Top20GainerDetailEntityMakerJobDetail3, nseSecGtr20Top20GainerDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseSecLwr20Top20GainerDetailEntityMakerJobDetail1, nseSecLwr20Top20GainerDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseSecLwr20Top20GainerDetailEntityMakerJobDetail2, nseSecLwr20Top20GainerDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseSecLwr20Top20GainerDetailEntityMakerJobDetail3, nseSecLwr20Top20GainerDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseBankNiftyTop20LoserDetailEntityMakerJobDetail1, nseBankNiftyTop20LoserDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseBankNiftyTop20LoserDetailEntityMakerJobDetail2, nseBankNiftyTop20LoserDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseBankNiftyTop20LoserDetailEntityMakerJobDetail3, nseBankNiftyTop20LoserDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseFuturesAndOptionTop20LoserDetailEntityMakerJobDetail1, nseFuturesAndOptionTop20LoserDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20LoserDetailEntityMakerJobDetail2, nseFuturesAndOptionTop20LoserDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseFuturesAndOptionTop20LoserDetailEntityMakerJobDetail3, nseFuturesAndOptionTop20LoserDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseNifty50Top20LoserDetailEntityMakerJobDetail1, nseNifty50Top20LoserDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseNifty50Top20LoserDetailEntityMakerJobDetail2, nseNifty50Top20LoserDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseNifty50Top20LoserDetailEntityMakerJobDetail3, nseNifty50Top20LoserDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseNiftyNext50Top20LoserDetailEntityMakerJobDetail1, nseNiftyNext50Top20LoserDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseNiftyNext50Top20LoserDetailEntityMakerJobDetail2, nseNiftyNext50Top20LoserDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseNiftyNext50Top20LoserDetailEntityMakerJobDetail3, nseNiftyNext50Top20LoserDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseSecGtr20Top20LoserDetailEntityMakerJobDetail1, nseSecGtr20Top20LoserDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseSecGtr20Top20LoserDetailEntityMakerJobDetail2, nseSecGtr20Top20LoserDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseSecGtr20Top20LoserDetailEntityMakerJobDetail3, nseSecGtr20Top20LoserDetailEntityMakerJobTriggerThree);

            this.scheduler.scheduleJob(nseSecLwr20Top20LoserDetailEntityMakerJobDetail1, nseSecLwr20Top20LoserDetailEntityMakerJobTriggerOne);
            this.scheduler.scheduleJob(nseSecLwr20Top20LoserDetailEntityMakerJobDetail2, nseSecLwr20Top20LoserDetailEntityMakerJobTriggerTwo);
            this.scheduler.scheduleJob(nseSecLwr20Top20LoserDetailEntityMakerJobDetail3, nseSecLwr20Top20LoserDetailEntityMakerJobTriggerThree);

        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }

    }
}