package rave.code.admin.web.service;

import java.util.List;

public abstract class AbstractAdminService<S, T, W>{

    public abstract W getWebPage();

    public abstract List<S> getEntities();

    public abstract List<T> transformEntities(List<S> entities);
}
