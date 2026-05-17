package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.dto.RepairOrderDTO;

public class RepairOrder {
    
    /**
     * Createing the repairOrderDTO outside registry. 
     * 
     * @param customerDescr the problem of the bike.
     * @param bikeSerialNo the serial number of the bike.
     * @param customerPhone The customers phonenumber.
     * @param repairOrderId the repair order id.
     * @return repairOrderDTO.
     */
    public RepairOrderDTO creatRepairOrderDTO(String customerDescr, int bikeSerialNo, String customerPhone, int repairOrderId){
        return new RepairOrderDTO(customerDescr, bikeSerialNo, customerPhone,repairOrderId);
    }

    /**
     * Adding the diagnosticresults to the correspondig repairOrderId.
     * 
     * @param repairOrderId The repairOrderId.
     * @param diagTaskResults The diagnostics of the bike.
     */
    public void addDiagnosticResults(RepairOrderDTO repairOrderDTO, String diagTaskResults) {
        repairOrderDTO.setDiagnosticResults(diagTaskResults);
    }

    /**
     * Adds the repair task to the corresponding repairOrderID and also updates the status because it is last step before approval by customer.
     * 
     * @param repairOrderId The repairOrderId.
     * @param repairTask The task needed to repair the bike.
     */
    public void addRepairTask(RepairOrderDTO repairOrderDTO, String repairTask, int repairCost) {
        repairOrderDTO.setRepairTask(repairTask);
        repairOrderDTO.setRepairCost(repairCost);
        repairOrderDTO.setStatus("Ready for approval");
    }

    /**
     * Updates the repairOrderDTO depedning on if it is accepted or not. 
     * 
     * @param repairOrderId The repairOrderId.
     * @param repairOrderAccepted If customer accepter the repairder or not.
     */
    public void updateRepairOrder(RepairOrderDTO repairOrderDTO, boolean repairOrderAccepted){

        if(repairOrderAccepted == true){
            repairOrderDTO.setAccepted(repairOrderAccepted);
            repairOrderDTO.setStatus("Accepted"); 
        }else{
            repairOrderDTO.setAccepted(repairOrderAccepted);
            repairOrderDTO.setStatus("Rejected");
        }
    }
}
