package rave.code.nse.web.service;

import rave.code.data.model.web.nse.WebPage;

public abstract class AbstractNSEService<S, T> {

    public abstract WebPage getWebPageModel();
}