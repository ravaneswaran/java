package rave.code.entity.bse;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_active_100")
@Access(AccessType.FIELD)
public class BSEActive100Entity extends StockMarketActiveEntity {}