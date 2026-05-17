package se.kth.iv1350.seminar3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.RepairOrderDTO;

class RepairOrderRegistryTest{

    private RepairOrderRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new RepairOrderRegistry();
    }

    @Test
    void testAddAndFindPhone() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        RepairOrderDTO result = registry.findRepairOrder("07502823043");
        assertNotNull(result,"Repairorder null");
        assertEquals("07502823043", result.getCustomerPhone());
        assertEquals(1, result.getRepairOrderId(),"RepairOrderId not 1.");
    }

    @Test
    void testFindRepairOrderById() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        RepairOrderDTO result = registry.findRepairOrder(1);
        assertNotNull(result,"Repairorder null");
        assertEquals(1, result.getRepairOrderId(),"Repairorderid not 1.");
    }

    

}