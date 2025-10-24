package rave.code.nse.web.service.preopen;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.preopen.PreOpenMarketBankNiftyWebPage;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.util.List;

@Service
public class NSEPreOpenMarketBankNiftyService extends AbstractNSEPreOpenMarketService<PreOpenMarketBankNiftyWebPage> {

    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    @Override
    public PreOpenMarketBankNiftyWebPage getWebPage() {
        PreOpenMarketBankNiftyWebPage preOpenMarketBankNiftyWebPage = new PreOpenMarketBankNiftyWebPage();
        preOpenMarketBankNiftyWebPage.setNsePreOpenMarketModels(this.transformEntities(this.getEntities()));
        return preOpenMarketBankNiftyWebPage;
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> getEntities() {
        return nsePreOpenMarketDetailRepository.findPreOpenMarketBankNiftys();
    }

}

