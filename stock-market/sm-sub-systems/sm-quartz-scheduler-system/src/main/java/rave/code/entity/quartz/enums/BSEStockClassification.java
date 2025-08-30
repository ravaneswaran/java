package rave.code.entity.quartz.enums;

public enum BSEStockClassification {

    A("A","Normal Equity (fully listed shares)"),
    B("B","Partly paid-up equity shares"),
    D("D","Debt Instruments (Debentures, Bonds, NCDs)"),
    F("F","SME / Fixed Income segment"),
    G("G","Government securities"),
    M("M","Mutual Fund units"),
    N("N","Non-convertible debentures (NCDs)"),
    P("P","Preference shares"),
    R("R","Rights entitlement"),
    T("T","Trade-to-Trade (sometimes used as alias of Y)"),
    W("W","Warrants"),
    X("X","Permitted Security (listed elsewhere, allowed for trading on BSE)"),
    XT("XT","Permitted Security – Trade-to-Trade (T2T)"),
    XY("XY","Permitted Security in T2T"),
    Z("Z","Non-compliant companies, traded only in T2T"),
    ZP("ZP","Partly Paid-up shares in Z group"),
    DEFAULT("NEW","New Series by NSE");

    private String segmentTypeSrs;
    private String description;


    private BSEStockClassification(String segmentTypeSrs, String description) {
        this.segmentTypeSrs = segmentTypeSrs;
        this.description = description;
    }

    public String getSegmentTypeSrs(){
        return this.segmentTypeSrs;
    }

    public String getDescription(){
        return this.description;
    }

    public static final BSEStockClassification getClassification(String segmentTypeSrs){
        BSEStockClassification[] bseStockClassifications = BSEStockClassification.values();
        for (BSEStockClassification bseStockClassification: bseStockClassifications) {
            if(segmentTypeSrs.equals(bseStockClassification.getSegmentTypeSrs())){
                return bseStockClassification;
            }
        }
        return BSEStockClassification.DEFAULT;
    }
}
