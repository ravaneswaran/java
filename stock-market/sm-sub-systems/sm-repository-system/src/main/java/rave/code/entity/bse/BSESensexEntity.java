package rave.code.entity.bse;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_sensex")
@Access(AccessType.FIELD)
public class BSESensexEntity extends StockMarketActiveEntity {}
