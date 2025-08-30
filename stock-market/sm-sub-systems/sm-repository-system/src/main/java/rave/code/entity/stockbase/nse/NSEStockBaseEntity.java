package rave.code.entity.stockbase.nse;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_stock_base")
@Access(AccessType.FIELD)
public class NSEStockBaseEntity extends AbstractNSEStockBaseEntity {

    @Column(name = "isi_number")
    private String ISINumber;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "series")
    private String series;
    @Column(name = "date_of_listing")
    private Date dateOfListing;
    @Column(name = "paid_up_value")
    private int paidUpValue;
    @Column(name = "face_value")
    private int faceValue;
    @Column(name = "market_lot")
    private int marketLot;

    public String getISINumber() {return ISINumber;}
    public void setISINumber(String ISINumber) {
        this.ISINumber = ISINumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getDateOfListing() {
        return dateOfListing;
    }

    public void setDateOfListing(Date dateOfListing) {
        this.dateOfListing = dateOfListing;
    }

    public int getPaidUpValue() {
        return paidUpValue;
    }

    public void setPaidUpValue(int paidUpValue) {
        this.paidUpValue = paidUpValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getMarketLot() {
        return marketLot;
    }

    public void setMarketLot(int marketLot) {
        this.marketLot = marketLot;
    }
}
