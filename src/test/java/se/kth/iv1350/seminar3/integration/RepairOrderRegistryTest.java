package se.kth.iv1350.seminar3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        assertNotNull(result);
        assertEquals("07502823043", result.getCustomerPhone());
        assertEquals(1, result.getRepairOrderId());
    }

    @Test
    void testFindRepairOrderById() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        RepairOrderDTO result = registry.findRepairOrder(1);
        assertNotNull(result);
        assertEquals(1, result.getRepairOrderId());
    }

    @Test
    void testAddDiagnosticResults() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        registry.addDiagnosticResults(1, "brake string are loose");
        RepairOrderDTO result = registry.findRepairOrder(1);
        assertEquals("brake string are loose", result.getDiagnosticResults());
    }


    @Test
    void testAddRepairTask() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        registry.addRepairTask(1, "replace chain");
        RepairOrderDTO result = registry.findRepairOrder(1);
        assertEquals("replace chain", result.getRepairTask());
        assertEquals("Ready for approval", result.getStatus());
    }

    @Test
    void testUpdateRepairOrderAccepted() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        registry.updateRepairOrder(1, true);
        RepairOrderDTO result = registry.findRepairOrder(1);
        assertTrue(result.isAccepted());
        assertEquals("Accepted", result.getStatus());
    }

    @Test
    void testUpdateRepairOrderRejected() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        registry.addRepairOrder(order);
        registry.updateRepairOrder(1, false);
        RepairOrderDTO result = registry.findRepairOrder(1);
        assertFalse(result.isAccepted());
        assertEquals("Rejected", result.getStatus());
    }

}