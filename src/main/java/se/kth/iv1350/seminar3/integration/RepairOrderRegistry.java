package se.kth.iv1350.seminar3.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar3.dto.RepairOrderDTO;

/**
 * RepairOrderRegistry contaions all repairOrderDTO. 
 * Have method to search for single repairorder for receptionist/customer
 * Technican can retrive all repairorders and update diagnosticresults and repairtasks.
 */
public class RepairOrderRegistry {
    /**
     * List of all repairOrderDTO.
     */
    private List<RepairOrderDTO> repairlist = new ArrayList<>();
    
    /**
     * Add repairorderDTO to the list.
     * @param repairOrderDTO
     */
    public void addRepairOrder(RepairOrderDTO repairOrderDTO){
        repairlist.add(repairOrderDTO);
    }

    /**
     * Find repairOrder with customers phonen number.
     * 
     * @param customerphone The repairOrderId.
     * @return RepairOrderDTO.
     */
    public RepairOrderDTO findRepairOrder(String customerphone){
        for (RepairOrderDTO repairs:repairlist){
            if(repairs.getCustomerPhone().equals(customerphone)){
                return repairs;
            }
        }
        return null;
    }

    /**
     * Find repairOrder with repairOrderId.
     * 
     * @param repairOrderId The repairOrderId.
     * @return RepairOrderDTO.
     */
    public RepairOrderDTO findRepairOrder(int repairOrderId){
        for (RepairOrderDTO repairs:repairlist){
            if(repairs.getRepairOrderId() == (repairOrderId)){
                return repairs;
            }
        }
        return null;
    }



    /**
     * Returns the list of repairOrders.
     * 
     * @return the repairOrderDTO list.
     */
    public List<RepairOrderDTO> findAllRepairOrders() {
        return repairlist;
    }

    /**
     * Adding the diagnosticresults to the correspondig repairOrderId.
     * 
     * @param repairOrderId The repairOrderId.
     * @param diagTaskResults The diagnostics of the bike.
     */
    public void addDiagnosticResults(int repairOrderId, String diagTaskResults) {
        for (RepairOrderDTO updateDiagnostic : repairlist) {
            if (updateDiagnostic.getRepairOrderId() == repairOrderId) {
                updateDiagnostic.setDiagnosticResults(diagTaskResults);
                return;
            }
        }
    }

    /**
     * Adds the repair task to the corresponding repairOrderID and also updates the status because it is last step before approval by customer.
     * 
     * @param repairOrderId The repairOrderId.
     * @param repairTask The task needed to repair the bike.
     */
    public void addRepairTask(int repairOrderId, String repairTask) {
        for (RepairOrderDTO updateRepairTask : repairlist) {
            if (updateRepairTask.getRepairOrderId() == repairOrderId) {
                updateRepairTask.setRepairTask(repairTask);
                updateRepairTask.setStatus("Ready for approval");
                return;
            }
        }
    }

    /**
     * Updates the repairOrderDTO depedning on if it is accepted or not. 
     * 
     * @param repairOrderId The repairOrderId.
     * @param repairOrderAccepted If customer accepter the repairder or not.
     */
    public void updateRepairOrder(int repairOrderId, boolean repairOrderAccepted){
        for (RepairOrderDTO updateRepairTask : repairlist) {
            if (updateRepairTask.getRepairOrderId() == repairOrderId) {
                if(repairOrderAccepted == true){
                    updateRepairTask.setAccepted(repairOrderAccepted);
                    updateRepairTask.setStatus("Accepted"); 
                }else{
                    updateRepairTask.setAccepted(repairOrderAccepted);
                    updateRepairTask.setStatus("Rejected");
                }
                return;
            }
        }
    }
}
