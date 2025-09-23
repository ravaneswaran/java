package rave.code.entity.quartz;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import rave.code.entity.quartz.id.QuartzTriggerId;

@Entity
@Table(name = "QUARTZ_SIMPROP_TRIGGERS")
public class QuartzSimplePropertiesTriggerEntity {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    @Column(name = "STR_PROP_1")
    private String stringProperty1;
    @Column(name = "STR_PROP_2")
    private String stringProperty2;
    @Column(name = "STR_PROP_3")
    private String stringProperty3;
    @Column(name = "INT_PROP_1")
    private int integerProperty1;
    @Column(name = "INT_PROP_2")
    private int integerProperty2;
    @Column(name = "LONG_PROP_1")
    private long longProperty1;
    @Column(name = "LONG_PROP_2")
    private long longProperty2;
    @Column(name = "DEC_PROP_1")
    private double decimalProperty1;
    @Column(name = "DEC_PROP_2")
    private double decimalProperty2;
    @Column(name = "BOOL_PROP_1")
    private String booleanProperty1;
    @Column(name = "BOOL_PROP_2")
    private String booleanProperty2;

    public QuartzTriggerId getQuartzTriggerId() {
        return quartzTriggerId;
    }

    public void setQuartzTriggerId(QuartzTriggerId quartzTriggerId) {
        this.quartzTriggerId = quartzTriggerId;
    }

    public String getStringProperty1() {
        return stringProperty1;
    }

    public void setStringProperty1(String stringProperty1) {
        this.stringProperty1 = stringProperty1;
    }

    public String getStringProperty2() {
        return stringProperty2;
    }

    public void setStringProperty2(String stringProperty2) {
        this.stringProperty2 = stringProperty2;
    }

    public String getStringProperty3() {
        return stringProperty3;
    }

    public void setStringProperty3(String stringProperty3) {
        this.stringProperty3 = stringProperty3;
    }

    public int getIntegerProperty1() {
        return integerProperty1;
    }

    public void setIntegerProperty1(int integerProperty1) {
        this.integerProperty1 = integerProperty1;
    }

    public int getIntegerProperty2() {
        return integerProperty2;
    }

    public void setIntegerProperty2(int integerProperty2) {
        this.integerProperty2 = integerProperty2;
    }

    public long getLongProperty1() {
        return longProperty1;
    }

    public void setLongProperty1(long longProperty1) {
        this.longProperty1 = longProperty1;
    }

    public long getLongProperty2() {
        return longProperty2;
    }

    public void setLongProperty2(long longProperty2) {
        this.longProperty2 = longProperty2;
    }

    public double getDecimalProperty1() {
        return decimalProperty1;
    }

    public void setDecimalProperty1(double decimalProperty1) {
        this.decimalProperty1 = decimalProperty1;
    }

    public double getDecimalProperty2() {
        return decimalProperty2;
    }

    public void setDecimalProperty2(double decimalProperty2) {
        this.decimalProperty2 = decimalProperty2;
    }

    public String getBooleanProperty1() {
        return booleanProperty1;
    }

    public void setBooleanProperty1(String booleanProperty1) {
        this.booleanProperty1 = booleanProperty1;
    }

    public String getBooleanProperty2() {
        return booleanProperty2;
    }

    public void setBooleanProperty2(String booleanProperty2) {
        this.booleanProperty2 = booleanProperty2;
    }
}
