package se.kth.iv1350.seminar3.dto;

/**
 * The RepairOrderDTO contains the information of the repair order. 
 * Have getter and setters because the techincan need to update the diagnostic results, status and task.
 * Receptionist have to update if customer accepted or not. 
 */
public class RepairOrderDTO {
    private String customerDescr;
    private int bikeSerialNo;
    private int repairOrderId;
    private String status;
    private String customerPhone;
    private boolean accepted;
    private String diagnosticResults;
    private String repairTask;
    private int repairCost;

    /**
     * Create repairOrderDTO that contains information of the bike, customer and the problem. 
     * Then it also contains the status of the repairorder. 
     * When technican have handle the order the repairtask and diagnostic is updated. 
     * Last if customerr accept the order or reject.
     * 
     * Each property has own setter and getter.
     * 
     * @param customerDescr the problem of the bike.
     * @param bikeSerialNo the serial number of the bike.
     * @param customerPhone The customers phonenumber.
     * @param repairOrderId the repair order id.
     */
    public RepairOrderDTO(String customerDescr, int bikeSerialNo,String customerPhone,int repairOrderId) {
        this.customerDescr = customerDescr;
        this.bikeSerialNo = bikeSerialNo;
        this.customerPhone = customerPhone;
        this.repairOrderId = repairOrderId;
        this.status = "null";
        this.accepted = true;
        this.diagnosticResults = "";
        this.repairTask = "";
        this.repairCost = 0;
    }

    //Used Source action to quickly generate constructors, getter and setter for each property.
    public String getCustomerDescr() {
        return customerDescr;
    }

    public void setCustomerDescr(String customerDescr) {
        this.customerDescr = customerDescr;
    }

    public int getBikeSerialNo() {
        return bikeSerialNo;
    }

    public void setBikeSerialNo(int bikeSerialNo) {
        this.bikeSerialNo = bikeSerialNo;
    }

    public int getRepairOrderId() {
        return repairOrderId;
    }

    public void setRepairOrderId(int repairOrderId) {
        this.repairOrderId = repairOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getDiagnosticResults() {
        return diagnosticResults;
    }

    public void setDiagnosticResults(String diagnosticResults) {
        this.diagnosticResults = diagnosticResults;
    }

    public String getRepairTask() {
        return repairTask;
    }

    public void setRepairTask(String repairTask) {
        this.repairTask = repairTask;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }
    
}
