package gr.aueb.cf.mobilecontacts.dao;


import gr.aueb.cf.mobilecontacts.model.MobileContact;

import java.util.List;

/**
 * CRUD Public API
 */
public interface IMobileContactDAO {
    // Basic CRUD actions (add, update, delete, getOne, getAll)
    MobileContact insert(MobileContact mobileContact);
    MobileContact update(Long id, MobileContact mobileContact);
    void deleteById(Long id);
    MobileContact getById(Long id);
    List<MobileContact> getAll();

    // Additional contextual CRUD specific to the class
    void deleteByPhoneNumber(String phoneNumber);

    // Additional Queries
    MobileContact getByPhoneNumber(String phoneNumber);     //queries
    boolean userIdExists(Long id);
    boolean phoneNumberExists(String phoneNumber);
}
