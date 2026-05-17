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

    
}
