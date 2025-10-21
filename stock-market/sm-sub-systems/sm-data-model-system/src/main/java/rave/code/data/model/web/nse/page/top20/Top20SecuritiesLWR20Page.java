package rave.code.data.model.web.nse.page.top20;

import rave.code.data.model.web.nse.page.NSEWebPage;

public class Top20SecuritiesLWR20Page extends NSEWebPage {

    public Top20SecuritiesLWR20Page() {
        this.setSecurityLessThan20(true);
    }

}
