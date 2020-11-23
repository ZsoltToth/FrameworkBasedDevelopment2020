package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.exceptions.UnknownCountryException;
import hu.uni.eszterhazy.framework.model.Address;

import java.util.Collection;

/**
 * DAO = Data Access Object
 *  - Create
 *  - Read
 *  - Update
 *  - Delete
 */
public interface AddressDao {


    void createAddress(Address address) throws UnknownCountryException;

    Collection<Address> readAll();

}
