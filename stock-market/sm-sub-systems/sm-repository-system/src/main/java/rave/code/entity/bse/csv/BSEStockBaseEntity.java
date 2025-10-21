package rave.code.entity.bse.csv;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bse_stock_base")
@Access(AccessType.FIELD)
public class BSEStockBaseEntity extends AbstractBSECSVEntity {

    @OneToMany(mappedBy = "bseStockBaseEntity")
    private List<BSEDayPriceDetailEntity> bseDayPriceDetailEntities = new ArrayList<>();
    @Column(name = "scrip_code")
    private String scripCode;
    @Column(name = "scrip_name")
    private String scripName;
    @Column(name = "scrip_group")
    private String scripGroup;
    @Column(name = "scrip_type")
    private String scripType;
    @Column(name = "isi_number")
    private String ISINumber;

    public List<BSEDayPriceDetailEntity> getBseDayPriceDetailEntities() {
        return bseDayPriceDetailEntities;
    }

    public void setBseDayPriceDetailEntities(List<BSEDayPriceDetailEntity> bseDayPriceDetailEntities) {
        this.bseDayPriceDetailEntities = bseDayPriceDetailEntities;
    }

    public String getScripCode() {
        return scripCode;
    }

    public void setScripCode(String scripCode) {
        this.scripCode = scripCode;
    }

    public String getScripName() {
        return scripName;
    }

    public void setScripName(String scripName) {
        this.scripName = scripName;
    }

    public String getScripGroup() {
        return scripGroup;
    }

    public void setScripGroup(String scripGroup) {
        this.scripGroup = scripGroup;
    }

    public String getScripType() {
        return scripType;
    }

    public void setScripType(String scripType) {
        this.scripType = scripType;
    }

    public String getISINumber() {
        return ISINumber;
    }

    public void setISINumber(String ISINumber) {
        this.ISINumber = ISINumber;
    }



    public static BSEStockBaseEntity newInstance(String financialInstrumentId, String financialInstrumentName, String securitySeries, String isiNumber) {
        BSEStockBaseEntity bseStockBaseEntity = new BSEStockBaseEntity();
        bseStockBaseEntity.setScripCode(financialInstrumentId);
        bseStockBaseEntity.setScripName(financialInstrumentName);
        bseStockBaseEntity.setScripGroup(securitySeries);
        bseStockBaseEntity.setISINumber(isiNumber);

        return bseStockBaseEntity;
    }
}
