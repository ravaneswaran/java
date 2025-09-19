delete from QUARTZ_BLOB_TRIGGERS;
delete from QUARTZ_CALENDARS;
delete from QUARTZ_CRON_TRIGGERS;
delete from QUARTZ_FIRED_TRIGGERS;
delete from QUARTZ_LOCKS;
delete from QUARTZ_PAUSED_TRIGGER_GRPS;
delete from QUARTZ_SCHEDULER_STATE;
delete from QUARTZ_SIMPLE_TRIGGERS;
delete from QUARTZ_SIMPROP_TRIGGERS;
delete from QUARTZ_TRIGGERS;
delete from QUARTZ_JOB_DETAILS;


delete from nse_day_block_deal_detail;
delete from nse_day_bulk_deal_detail;
delete from nse_day_short_sell_detail;
delete from nse_etf_detail;
delete from nse_main_board_detail;
delete from nse_pre_open_market_detail;
delete from nse_price_spurt_detail;
delete from nse_sme_detail;
delete from nse_top20_detail;
delete from nse_volume_spurt_detail;
delete from nse_day_price_detail;


select * from QUARTZ_CRON_TRIGGERS;
select SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME from QUARTZ_JOB_DETAILS;
select SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP from QUARTZ_TRIGGERS;