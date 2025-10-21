package rave.code.nse.web.service.top20;

import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.service.AbstractNSEService;

import java.util.List;

public abstract class AbstractNSETop20Service<T, W> extends AbstractNSEService<NSETop20DetailEntity, T, W> {

    public abstract List<T> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities);

}
