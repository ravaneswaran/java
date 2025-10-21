package rave.code.entity.bse.csv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bse_day_price_detail")
@Access(AccessType.FIELD)
public class BSEDayPriceDetailEntity extends AbstractBSECSVEntity {

    @ManyToOne
    @JoinColumn(name = "stock_base_id", nullable=false)
    private BSEStockBaseEntity bseStockBaseEntity;
    @Column(name = "traded_date")
    private Date tradedDate;
    @Column(name = "business_date")
    private Date businessDate;
    @Column(name = "segment")
    private String segment;
    @Column(name = "financial_instrument_type")
    private String financialInstrumentType;
    @Column(name = "financial_instrument_id")
    private String financialInstrumentId;
    @Column(name = "isi_number")
    private String ISINumber;
    @Column(name = "ticker_symbol")
    private String tickerSymbol;
    @Column(name = "security_series")
    private String securitySeries;
    @Column(name = "expiry_date")
    private Date expiryDate;
    @Column(name = "financial_instrument_actual_expiry_date")
    private Date financialInstrumentActualExpiryDate;
    @Column(name = "strike_price")
    private double strikePrice;
    @Column(name = "option_type")
    private String optionType;
    @Column(name = "financial_instrument_name")
    private String financialInstrumentName;
    @Column(name = "open_price")
    private double openPrice;
    @Column(name = "high_price")
    private double highPrice;
    @Column(name = "low_price")
    private double lowPrice;
    @Column(name = "close_price")
    private double closePrice;
    @Column(name = "last_price")
    private double lastPrice;
    @Column(name = "previous_close_price")
    private double previousClosePrice;
    @Column(name = "underlying_price")
    private double underlyingPrice;
    @Column(name = "settlement_price")
    private double settlementPrice;
    @Column(name = "open_interest")
    private double openInterest;
    @Column(name = "change_in_open_interest")
    private String changeInOpenInterest;
    @Column(name = "total_traded_volume")
    private double totalTradedVolume;
    @Column(name = "total_traded_value")
    private double totalTradedValue;
    @Column(name = "total_number_of_transaction_executed")
    private int totalNumberOfTransactionsExecuted;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "new_board_lot_quantity")
    private String newBoardLotQuantity;

    public BSEStockBaseEntity getBseStockBaseEntity() {
        return bseStockBaseEntity;
    }

    public void setBseStockBaseEntity(BSEStockBaseEntity bseStockBaseEntity) {
        this.bseStockBaseEntity = bseStockBaseEntity;
    }

    public Date getTradedDate() {
        return tradedDate;
    }

    public void setTradedDate(Date tradedDate) {
        this.tradedDate = tradedDate;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getFinancialInstrumentType() {
        return financialInstrumentType;
    }

    public void setFinancialInstrumentType(String financialInstrumentType) {
        this.financialInstrumentType = financialInstrumentType;
    }

    public String getFinancialInstrumentId() {
        return financialInstrumentId;
    }

    public void setFinancialInstrumentId(String financialInstrumentId) {
        this.financialInstrumentId = financialInstrumentId;
    }

    public String getISINumber() {
        return ISINumber;
    }

    public void setISINumber(String ISINumber) {
        this.ISINumber = ISINumber;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getSecuritySeries() {
        return securitySeries;
    }

    public void setSecuritySeries(String securitySeries) {
        this.securitySeries = securitySeries;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getFinancialInstrumentActualExpiryDate() {
        return financialInstrumentActualExpiryDate;
    }

    public void setFinancialInstrumentActualExpiryDate(Date financialInstrumentActualExpiryDate) {
        this.financialInstrumentActualExpiryDate = financialInstrumentActualExpiryDate;
    }

    public double getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(double strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getFinancialInstrumentName() {
        return financialInstrumentName;
    }

    public void setFinancialInstrumentName(String financialInstrumentName) {
        this.financialInstrumentName = financialInstrumentName;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public double getUnderlyingPrice() {
        return underlyingPrice;
    }

    public void setUnderlyingPrice(double underlyingPrice) {
        this.underlyingPrice = underlyingPrice;
    }

    public double getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(double settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public double getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(double openInterest) {
        this.openInterest = openInterest;
    }

    public String getChangeInOpenInterest() {
        return changeInOpenInterest;
    }

    public void setChangeInOpenInterest(String changeInOpenInterest) {
        this.changeInOpenInterest = changeInOpenInterest;
    }

    public double getTotalTradedVolume() {
        return totalTradedVolume;
    }

    public void setTotalTradedVolume(double totalTradedVolume) {
        this.totalTradedVolume = totalTradedVolume;
    }

    public double getTotalTradedValue() {
        return totalTradedValue;
    }

    public void setTotalTradedValue(double totalTradedValue) {
        this.totalTradedValue = totalTradedValue;
    }

    public int getTotalNumberOfTransactionsExecuted() {
        return totalNumberOfTransactionsExecuted;
    }

    public void setTotalNumberOfTransactionsExecuted(int totalNumberOfTransactionsExecuted) {
        this.totalNumberOfTransactionsExecuted = totalNumberOfTransactionsExecuted;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getNewBoardLotQuantity() {
        return newBoardLotQuantity;
    }

    public void setNewBoardLotQuantity(String newBoardLotQuantity) {
        this.newBoardLotQuantity = newBoardLotQuantity;
    }
}
