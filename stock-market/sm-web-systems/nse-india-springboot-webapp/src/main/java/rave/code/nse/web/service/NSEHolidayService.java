package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.nse.web.model.HolidayDetailModel;
import rave.code.nse.web.model.WebPage;
import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.stockmarket.repository.HolidayRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NSEHolidayService extends AbstractNSEService<HolidayEntity, List<HolidayDetailModel>> {

    private static final Logger LOGGER = Logger.getLogger(NSEHolidayService.class.getName());

    private HolidayRepository holidayRepository = new HolidayRepository();

    @Override
    public WebPage getWebPageModel() {
        return null;
    }

    public List<HolidayDetailModel> listHolidays()  {
        List<HolidayEntity> entities = this.holidayRepository.findAll();
        List<HolidayDetailModel> holidayDetailModels = new ArrayList<>();
        for (HolidayEntity holidayEntity : entities) {
            HolidayDetailModel holidayDetailModel = new HolidayDetailModel();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, YYYY");
            try {
                Date holiDate =  simpleDateFormat.parse(holidayEntity.getHolidate());
                holidayDetailModel.setHolidate(holiDate);
                holidayDetailModels.add(holidayDetailModel);
            } catch (ParseException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
            }
        }
        return holidayDetailModels;
    }
}
