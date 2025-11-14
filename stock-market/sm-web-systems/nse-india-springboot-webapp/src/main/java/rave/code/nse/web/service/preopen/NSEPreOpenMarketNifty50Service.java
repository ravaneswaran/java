package rave.code.nse.web.service.preopen;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.data.model.web.nse.page.preopen.PreOpenMarketNifty50WebPage;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.util.List;

@Service
public class NSEPreOpenMarketNifty50Service extends AbstractNSEPreOpenMarketService<PreOpenMarketNifty50WebPage> {

    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    @Override
    public PreOpenMarketNifty50WebPage getWebPage() {
        List<NSEPreOpenMarketDetailEntity> entities = this.getEntities();
        PreOpenMarketNifty50WebPage preOpenMarketNifty50WebPage = new PreOpenMarketNifty50WebPage();
        preOpenMarketNifty50WebPage.setNsePreOpenMarketModels(this.transformEntities(entities));
        preOpenMarketNifty50WebPage.setNseStockModels(this.getNSEStockModels(entities));
        return preOpenMarketNifty50WebPage;
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> getEntities() {
        return nsePreOpenMarketDetailRepository.findPreOpenMarketNIfty50s();
    }

}
