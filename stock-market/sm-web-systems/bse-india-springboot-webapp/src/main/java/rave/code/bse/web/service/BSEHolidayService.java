package rave.code.bse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.HolidayDetailModel;
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
public class BSEHolidayService extends AbstractBSEService<HolidayEntity, HolidayDetailModel, Object> {

    private static final Logger LOGGER = Logger.getLogger(BSEHolidayService.class.getName());

    private HolidayRepository holidayRepository = new HolidayRepository();

    @Override
    public Object getWebPage() {
        return null;
    }

    @Override
    public List<HolidayEntity> getEntities() {
        return this.holidayRepository.findAll();
    }

    @Override
    public List<HolidayDetailModel> transformEntities(List<HolidayEntity> entities) {
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

    public List<HolidayDetailModel> listHolidays()  {
        return this.transformEntities(this.getEntities());
    }
}
