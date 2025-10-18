package rave.code.admin.web.service;

import java.util.List;

public abstract class AbstractAdminService<S, T> {

    public abstract List<T> transformEntities(List<S> entities);
}
