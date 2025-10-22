package rave.code.entity.bse;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_active_500")
@Access(AccessType.FIELD)
public class BSEActive500Entity extends StockMarketActiveEntity {}