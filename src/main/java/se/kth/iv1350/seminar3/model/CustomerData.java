package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.dto.CustomerDTO;

public class CustomerData {
    /**
     * creates the CustomerDTO here. If wanting to add method to edit the DTO before adding it to customerRegistry it should be done outside the registry. 
     * @param bikeBrand The Bikebrand.
     * @param bikeModel The bike model.
     * @param bikeSerialNo The bikes serial number.
     * @param email Customers email.
     * @param name Customers name
     * @param phoneNumber Customers phone number.
     * @return CustomerDTO the DTO are created and returned.
     */
    public CustomerDTO createCustomerDTO(String bikeBrand, int bikeModel, int bikeSerialNo, String email, String name, String phoneNumber){
        return new CustomerDTO(bikeBrand, bikeModel, bikeSerialNo, email, name, phoneNumber);
    }
}
