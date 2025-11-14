package rave.code.nse.web.service.preopen;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.preopen.PreOpenMarketSMEWebPage;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.util.List;

@Service
public class NSEPreOpenMarketSMEService extends AbstractNSEPreOpenMarketService<PreOpenMarketSMEWebPage> {

    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    @Override
    public PreOpenMarketSMEWebPage getWebPage() {
        List<NSEPreOpenMarketDetailEntity> entities = this.getEntities();
        PreOpenMarketSMEWebPage preOpenMarketSMEWebPage = new PreOpenMarketSMEWebPage();
        preOpenMarketSMEWebPage.setNsePreOpenMarketModels(this.transformEntities(entities));
        preOpenMarketSMEWebPage.setNseStockModels(this.getNSEStockModels(entities));
        return preOpenMarketSMEWebPage;
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> getEntities() {
        return nsePreOpenMarketDetailRepository.findPreOpenMarketSMEs();
    }

}
