package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;

public class Top20SecuritiesGTR20Page extends NSEWebPage {

    public Top20SecuritiesGTR20Page() {
        this.setSecurityGreaterThan20(true);
    }
}
