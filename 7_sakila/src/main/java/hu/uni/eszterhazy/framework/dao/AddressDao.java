package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Address;

import java.util.Collection;

public interface AddressDao {

    Collection<Address> readAll();

}
