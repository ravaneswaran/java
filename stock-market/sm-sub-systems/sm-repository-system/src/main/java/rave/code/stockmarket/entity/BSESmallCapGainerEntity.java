package rave.code.stockmarket.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_small_cap_gainer")
@Access(AccessType.FIELD)
public class BSESmallCapGainerEntity extends StockMarketGainerEntity {}