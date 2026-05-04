package se.kth.iv1350.seminar3.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar3.dto.CustomerDTO;

/**
 * CustomerRegistry stores customerDTO and search for customers using their phonenumber
 */

public class CustomerRegistry {
    /**
     *  A list that contains all customersDTO
     */ 
    private List<CustomerDTO> customerList = new ArrayList<>();

    /**
     * Goes through each DTO in the list and checks if the phonenumber is equal any phonenumber registred.
     * @param phoneNumber The number searched for.
     * @return customerDTO that match phonenumber
     */
    public CustomerDTO findCustomer(String phoneNumber){
        for (CustomerDTO customer:customerList){
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Adds customerDTO to the list.
     * @param customerDTO to be added.
     */
    public void addCustomer(CustomerDTO customerDTO) {
        customerList.add(customerDTO);
    }

}
