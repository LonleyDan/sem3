package se.kth.iv1350.seminar3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.RepairOrderDTO;

public class RepairOrderTest {

    private RepairOrder repairOrder;

    @BeforeEach
    void setUp() {
        repairOrder = new RepairOrder();
    
    }

    @Test
    void testAddDiagnosticResults() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        repairOrder.addDiagnosticResults(order, "brake string are loose");
        assertEquals("brake string are loose", order.getDiagnosticResults(),"Inccorrect diagnostic results.");
    }


    @Test
    void testAddRepairTask() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        repairOrder.addRepairTask(order, "replace chain",500);
        repairOrder.addRepairTask(order, "replace chain",500);
        assertEquals("replace chain", order.getRepairTask(), "Repairtask not found");
        assertEquals("Ready for approval", order.getStatus(), "Status wasn't Ready for approval");
        assertEquals(500, order.getRepairCost(),"Not 500 as cost");
    }

    @Test
    void testUpdateRepairOrderAccepted() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        repairOrder.updateRepairOrder(order, true);
        assertTrue(order.isAccepted(),"Accept repairorder not true.");
        assertEquals("Accepted", order.getStatus(),"Repair order wasn't accepted");
    }

    @Test
    void testUpdateRepairOrderRejected() {
        RepairOrderDTO order = new RepairOrderDTO("brakes do not work.", 109497, "07502823043", 1);
        repairOrder.updateRepairOrder(order, false);
        assertFalse(order.isAccepted(),"Accept repairorder not false.");
        assertEquals("Rejected", order.getStatus(),"Repair order wasn't rejected");
    }
}
