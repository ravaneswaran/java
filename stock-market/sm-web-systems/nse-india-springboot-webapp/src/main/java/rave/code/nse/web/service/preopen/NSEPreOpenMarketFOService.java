package rave.code.nse.web.service.preopen;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.page.preopen.PreOpenMarketFOWebPage;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;

import java.util.List;

@Service
public class NSEPreOpenMarketFOService extends AbstractNSEPreOpenMarketService<PreOpenMarketFOWebPage> {

   private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

   @Override
   public PreOpenMarketFOWebPage getWebPage() {
      PreOpenMarketFOWebPage preOpenMarketFOWebPage = new PreOpenMarketFOWebPage();
      preOpenMarketFOWebPage.setNsePreOpenMarketModels(this.transformEntities(this.getEntities()));
      return preOpenMarketFOWebPage;
   }

   @Override
   public List<NSEPreOpenMarketDetailEntity> getEntities() {
      return nsePreOpenMarketDetailRepository.findPreOpenMarketFOs();
   }

}
