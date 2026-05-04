package se.kth.iv1350.seminar3.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.RepairOrderDTO;
import se.kth.iv1350.seminar3.integration.CustomerRegistry;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.integration.RepairOrderRegistry;

public class ControllerTest {
    private Controller contr;

    @BeforeEach
    public void setUp(){
        CustomerRegistry customReg = new CustomerRegistry();
        RepairOrderRegistry repairOrdReg = new RepairOrderRegistry();
        Printer printer = new Printer();

        contr = new Controller(customReg, repairOrdReg, printer);
    }

    @Test
    void testfindCustomer(){
        CustomerDTO testCustomer= contr.findCustomer("674525343");
        assertNull(testCustomer);
        contr.addCustomerData("Monster", 2545, 109497, "dan.frees@gmail.com", "Dan Frees", "07502823043");
        CustomerDTO testCustomer2 = contr.findCustomer("07502823043");
        assertNotNull(testCustomer2);
        assertEquals("07502823043",testCustomer2.getPhoneNumber());
    }

    @Test
    void testAddCustomer(){
        contr.addCustomerData("Monster", 2545, 109497, "dan.frees@gmail.com", "Dan Frees", "07502823043");
        CustomerDTO testCustomer = contr.findCustomer("07502823043");
        assertNotNull(testCustomer);
        assertEquals("Monster", testCustomer.getBikeBrand());
        assertEquals(2545, testCustomer.getBikeModel());
        assertEquals(109497, testCustomer.getBikeSerialNo());
    }

    @Test
    void testCreateRepairOrder(){
        contr.createRepairOrder("brakes do not work.", 109497, "07502823043", 1);
        RepairOrderDTO repairOrder = contr.findRepairOrder("07502823043");
        assertNotNull(repairOrder);
        assertEquals("brakes do not work.", repairOrder.getCustomerDescr());
    }
    @Test
    void testFindRepairOrder() {
        contr.createRepairOrder("brakes do not work.",109497,"07502823043",1);
        RepairOrderDTO repairOrder = contr.findRepairOrder("07502823043");
        assertNotNull(repairOrder);
        assertEquals("07502823043", repairOrder.getCustomerPhone());
        assertEquals("brakes do not work.", repairOrder.getCustomerDescr());
    }

    @Test
    void testFindAllRepairOrders(){
        contr.createRepairOrder("brakes do not work.",109497,"07502823043",1);
        contr.createRepairOrder("chains are broken.",23442,"0302843343",4);
        List<RepairOrderDTO> repairList = contr.findAllRepairOrders();
        assertNotNull(repairList);
        assertEquals(2, repairList.size());
        assertEquals("07502823043", repairList.get(0).getCustomerPhone());
        assertEquals("0302843343", repairList.get(1).getCustomerPhone());
    }

    @Test
    void testAddDiagnosticResults(){
        contr.createRepairOrder("brakes do not work.",109497,"07502823043",1);
        contr.addDiagnosticResults(1, "brake string has losen up.");
        RepairOrderDTO repairOrder = contr.findRepairOrder("07502823043");
        assertNotNull(repairOrder);
        assertEquals("brake string has losen up.", repairOrder.getDiagnosticResults());
    }

    @Test
    void testAddRepairTask(){
        contr.createRepairOrder("chains are broken.",23442,"0302843343",4);
        contr.addRepairTask(4, "Change brake string.");
        RepairOrderDTO repairOrder = contr.findRepairOrder("0302843343");
        assertNotNull(repairOrder);
        assertEquals("Change brake string.", repairOrder.getRepairTask());
    }

    @Test
    void testRepairOrderAcceptedTrue() {
        contr.createRepairOrder("brakes do not work.", 109497, "07502823043", 1);
        contr.repairOrderAccepted(1, true);
        RepairOrderDTO order = contr.findRepairOrder("07502823043");
        assertTrue(order.isAccepted());
    }
    
    @Test
    void testRepairOrderAcceptedFalse() {
        contr.createRepairOrder("brakes do not work.", 109497, "07502823043", 1);
        contr.repairOrderAccepted(1, false);
        RepairOrderDTO order = contr.findRepairOrder("07502823043");
        assertFalse(order.isAccepted());
    }

}
