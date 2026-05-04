package se.kth.iv1350.seminar3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.CustomerDTO;

public class CustomerRegistryTest{
    private CustomerRegistry customReg;

    @BeforeEach
    public void setUp(){
        customReg = new CustomerRegistry();
    }

    @Test
    void testFindCustomer(){
        customReg.addCustomer(new CustomerDTO("Monster", 2545, 109497,"dan.frees@gmail.com", "Dan Frees", "07502823043"));
        CustomerDTO testCustomer = customReg.findCustomer("07502823043");
        assertNotNull(testCustomer);
        assertEquals("07502823043", testCustomer.getPhoneNumber());
    }

    @Test
    void testAddCustomer(){
        customReg.addCustomer(new CustomerDTO("Redbull", 2545, 193832,"many.forge@outlook.com", "Many Forge", "0670383043"));
        CustomerDTO testCustomer = customReg.findCustomer("0670383043");
        assertNotNull(testCustomer);
        assertEquals("Redbull", testCustomer.getBikeBrand());
        assertEquals("0670383043", testCustomer.getPhoneNumber());
        assertEquals("many.forge@outlook.com", testCustomer.getEmail());
    }

}

   