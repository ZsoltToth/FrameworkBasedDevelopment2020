package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Gate;
import hu.uni.eszterhazy.framework.model.Permissions;
import hu.uni.eszterhazy.framework.model.User;
import hu.uni.eszterhazy.framework.service.exceptions.AccessDeniedException;

public interface AccessControlManagerService {

    void requestAccess(String user, int gate) throws AccessDeniedException;

    void grantPermisson(String user, Permissions permission);

}
