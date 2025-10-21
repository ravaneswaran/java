package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.List;

@Service
public class NSEPriceSpurtLWR20Service extends AbstractNSEPriceSpurtService {

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findPriceSpurtsLWR20();
    }
}
