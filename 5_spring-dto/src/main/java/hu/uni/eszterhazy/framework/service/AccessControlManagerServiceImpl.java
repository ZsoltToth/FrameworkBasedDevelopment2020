package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Gate;
import hu.uni.eszterhazy.framework.model.Permissions;
import hu.uni.eszterhazy.framework.model.User;
import hu.uni.eszterhazy.framework.service.exceptions.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@Service
public class AccessControlManagerServiceImpl implements AccessControlManagerService{

    private final Collection<User> users;
    private final Collection<Gate> gates;

    public AccessControlManagerServiceImpl() {
        this.users = Arrays.asList(
                new User("john", "John Doe", Arrays.asList(Permissions.FACTORY_BLOCK_A, Permissions.TOP_SECRET_FACILITY)),
                new User("jane", "Jane Doe", Arrays.asList(Permissions.NUCLEAR_SILO)),
                new User("jake", "Jake Doe", Arrays.asList(Permissions.ALL))
        );
        this.gates = Arrays.asList(
                new Gate(0, Permissions.NUCLEAR_SILO),
                new Gate(1,Permissions.TOP_SECRET_FACILITY)
        );

    }

    @Override
    public void requestAccess(String user, int gate) throws AccessDeniedException {
        User u = null;
        Gate g = null;
        for(User usr : this.users){
            if(usr.getUserId().equals(user)){
                u = usr;
            }
        }
        for(Gate gt : this.gates){
            if(gt.getGateNo() == gate){
                g = gt;
            }
        }
        if(u == null){
            throw new AccessDeniedException(String.format("User: %s is not found!", user));
        }
        if(!u.getPermissions().contains(g.getRequiredPermission())){
            throw new AccessDeniedException(String.format("Access Denied for (%s) to %s", u, g));
        }

    }

    @Override
    public void grantPermisson(String user, Permissions permission) {

    }
}
