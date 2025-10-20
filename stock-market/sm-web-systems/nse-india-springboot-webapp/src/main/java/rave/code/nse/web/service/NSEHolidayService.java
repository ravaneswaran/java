package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.entity.nse.webpage.HolidayEntity;
import rave.code.nse.web.model.WebPage;
import rave.code.website.data.model.groww.HolidayModel;

import java.util.List;

@Service
public class NSEHolidayService extends AbstractNSEService<HolidayEntity, List<HolidayModel>> {

    @Override
    public WebPage getWebPageModel() {
        return null;
    }
}
