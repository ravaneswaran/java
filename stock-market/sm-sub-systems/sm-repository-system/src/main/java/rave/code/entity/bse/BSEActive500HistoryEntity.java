package rave.code.entity.bse;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "bse_active_500_history")
public class BSEActive500HistoryEntity extends StockMarketActiveHistoryEntity {}