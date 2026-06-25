package rave.code.nse.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.nse.web.service.rest.NSEPriceSpurtRESTService;

import java.util.List;
import java.util.Map;

@RestController
public class NationalStockExchangeRESTController {

    @Autowired
    private NSEPriceSpurtRESTService nsePriceSpurtRESTService;

}
