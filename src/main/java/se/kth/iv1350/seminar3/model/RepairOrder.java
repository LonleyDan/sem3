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
}
