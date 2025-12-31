package rave.code.entity.nse.csv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nse_ipo_detail")
@Access(AccessType.FIELD)
public class NSEIPODetailEntity extends AbstractNSECSVEntity {

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "security_type")
    private String securityType;
    @Column(name = "issue_price")
    private double issuePrice;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "issue_start_date")
    private Date issueStartDate;
    @Column(name = "issue_end_date")
    private Date issueEndDate;
    @Column(name = "price_range")
    private String priceRange;
    @Column(name = "date_of_listing")
    private Date dateOfListing;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public double getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(double issuePrice) {
        this.issuePrice = issuePrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getIssueStartDate() {
        return issueStartDate;
    }

    public void setIssueStartDate(Date issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public Date getIssueEndDate() {
        return issueEndDate;
    }

    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public Date getDateOfListing() {
        return dateOfListing;
    }

    public void setDateOfListing(Date dateOfListing) {
        this.dateOfListing = dateOfListing;
    }
}
