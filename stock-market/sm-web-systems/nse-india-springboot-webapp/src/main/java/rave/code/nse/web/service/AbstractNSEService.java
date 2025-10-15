package rave.code.nse.web.service;

import rave.code.nse.web.model.WebPage;

public abstract class AbstractNSEService<S, T> {

    public abstract WebPage getWebPageModel();
}