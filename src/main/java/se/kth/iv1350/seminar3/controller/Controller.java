package se.kth.iv1350.seminar3.controller;

import java.util.List;

import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.RepairOrderDTO;
import se.kth.iv1350.seminar3.integration.CustomerRegistry;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.integration.RepairOrderRegistry;
import se.kth.iv1350.seminar3.model.RepairOrder;


/**
 * Controller class that calls model and integration requested by view. 
 */
public class Controller {
    private RepairOrder repairOrder;
    final private CustomerRegistry customReg;
    final private RepairOrderRegistry repairOrdReg;
    final private Printer printer;
    
    /**
     * Creates the instances for the registries and printer.
     * @param customReg
     * @param repairOrdReg
     * @param printer
     */
    public Controller(CustomerRegistry customReg, RepairOrderRegistry repairOrdReg, Printer printer){
        repairOrder = new RepairOrder();
        this.customReg = customReg;
        this.repairOrdReg = repairOrdReg;
        this.printer = printer;
    }

    /**
     * Registry searches for customerDTO by using the entered phone number.
     * @param phoneNumber Customers phone number.
     * @return CustomerDTo back. 
     */
    public CustomerDTO findCustomer(String phoneNumber){
        return customReg.findCustomer(phoneNumber);
    }

    /**
     * Customerdata creates new DTO that is then added to customerRegistry.
     * 
     * @param bikeBrand The Bikebrand.
     * @param bikeModel The bike model.
     * @param bikeSerialNo The bikes serial number.
     * @param email Customers email.
     * @param name Customers name
     * @param phoneNumber Customers phone number.
     */
    public void addCustomerData(String bikeBrand, int bikeModel, int bikeSerialNo, String email, String name, String phoneNumber ){
        CustomerDTO  customerDTO = new CustomerDTO(bikeBrand, bikeModel, bikeSerialNo, email, name, phoneNumber);
        customReg.addCustomer(customerDTO);
    }

    /**
     * RepairOrder creates new DTO that is then added to repairOrderRegistry.
     * 
     * @param customerDescr the problem of the bike.
     * @param bikeSerialNo the serial number of the bike.
     * @param customerPhone The customers phonenumber.
     * @param repairOrderId the repair order id.
     */
    public void createRepairOrder(String customerDescr, int bikeSerialNo,  String customerPhone, int repairOrderId){
        RepairOrderDTO repairOrderDTO = repairOrder.creatRepairOrderDTO(customerDescr, bikeSerialNo,customerPhone, repairOrderId);
        repairOrdReg.addRepairOrder(repairOrderDTO);
    }

    /**
     * Find the repair order with the given customer phone number.
     * 
     * @param customerPhone
     * @return repairOrderDTo 
     */
    public RepairOrderDTO findRepairOrder(String customerPhone){
        return repairOrdReg.findRepairOrder(customerPhone);
    }


    /**
     * Method to get all repairOrders.
     * 
     * @return ArrayList of all repairOrders
     */
    public List<RepairOrderDTO> findAllRepairOrders(){
        return repairOrdReg.findAllRepairOrders();
    }  

    /**
     * Add the diagnostic results to repairOrderDTO with the chosen ID.
     * 
     * @param repairOrderId The repairOrderId.
     * @param diagTaskResults The diagnostics of the bike.
     */
    public void addDiagnosticResults(int repairOrderId, String diagTaskResults){
        RepairOrderDTO repairOrderDTO = repairOrdReg.findRepairOrder(repairOrderId);
        repairOrder.addDiagnosticResults(repairOrderDTO, diagTaskResults);
    }

    /**
     * Add the repair task to repairOrderDTo with the chosen ID.
     * 
     * @param repairOrderId The repairOrderId.
     * @param repairTask The task needed to repair the bike.
     */
    public void addRepairTask(int repairOrderId, String repairTask, int repairCost){
        RepairOrderDTO repairOrderDTO = repairOrdReg.findRepairOrder(repairOrderId);
        repairOrder.addRepairTask(repairOrderDTO, repairTask, repairCost);
    }

    /**
     * If accepted it prints out the repairOrder.
     * If rejected it updates the repairOrder.
     * 
     * @param repairOrderId
     * @param repairOrderAccepted
     */
    public void repairOrderAccepted(int repairOrderId,Boolean repairOrderAccepted){
        RepairOrderDTO repairOrderDTO = repairOrdReg.findRepairOrder(repairOrderId);
        if (repairOrderAccepted == true){
            repairOrder.updateRepairOrder(repairOrderDTO, repairOrderAccepted);
            printer.printOut(repairOrderDTO);
        }else{
            repairOrder.updateRepairOrder(repairOrderDTO, repairOrderAccepted);
        }
    }
}
