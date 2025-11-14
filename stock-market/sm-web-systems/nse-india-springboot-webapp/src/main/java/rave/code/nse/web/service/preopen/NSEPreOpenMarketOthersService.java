package rave.code.nse.web.service.preopen;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.preopen.PreOpenMarketOthersWebPage;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.util.List;

@Service
public class NSEPreOpenMarketOthersService extends AbstractNSEPreOpenMarketService<PreOpenMarketOthersWebPage> {

    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    @Override
    public PreOpenMarketOthersWebPage getWebPage() {
        List<NSEPreOpenMarketDetailEntity> entities = this.getEntities();
        PreOpenMarketOthersWebPage preOpenMarketOthersWebPage = new PreOpenMarketOthersWebPage();
        preOpenMarketOthersWebPage.setNsePreOpenMarketModels(this.transformEntities(entities));
        preOpenMarketOthersWebPage.setNseStockModels(this.getNSEStockModels(entities));
        return preOpenMarketOthersWebPage;
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> getEntities() {
        return nsePreOpenMarketDetailRepository.findPreOpenMarketOthers();
    }

}
