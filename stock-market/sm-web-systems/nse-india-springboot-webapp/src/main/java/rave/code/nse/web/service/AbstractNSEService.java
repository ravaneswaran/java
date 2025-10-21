package rave.code.nse.web.service;

import rave.code.data.model.web.nse.page.NSEWebPage;

public abstract class AbstractNSEService<S, T> {

    public abstract NSEWebPage getWebPageModel();
}