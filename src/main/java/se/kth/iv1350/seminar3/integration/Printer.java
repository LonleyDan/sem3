package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.RepairOrderDTO;

public class Printer {

    /**
     * Prints out the repairOrder data.
     * 
     * @param repairOrderDTO
     */
    public void printOut(RepairOrderDTO repairOrderDTO){
        // wont print out customer information assuming the ID is correct. 
        System.out.println("Repair Order");
        System.out.println("ID: " + repairOrderDTO.getRepairOrderId());
        System.out.println("Status: " + repairOrderDTO.getStatus());
        System.out.println("Diagnostic Results: " + repairOrderDTO.getDiagnosticResults());
        System.out.println("Accepted: " + repairOrderDTO.isAccepted());
    }
}
