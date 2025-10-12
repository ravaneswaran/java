package rave.code.nse.web.service;

import rave.code.nse.web.model.WebPage;

public class AbstractService <S, T> {

    public WebPage getPageModel() {
        WebPage webPage = new WebPage();
        return webPage;
    }
}