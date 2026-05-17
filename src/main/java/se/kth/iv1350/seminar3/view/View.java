package se.kth.iv1350.seminar3.view;

import java.util.List;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.RepairOrderDTO;

/** 
 * The View class represents the UI for the application.
 * Sends user interacions to the controller.
*/
public class View {
    private Controller contr;

    /**
     * Creates a new instance of the View.
     *
     * @param contr  controller that view uses to perform operations.
     */
    public View(Controller contr){
        this.contr=contr;
    }

    /**
     * Hardcodded method for testing
     */
    public void Test(){
        // add customer
        contr.addCustomerData("Monster", 2545, 109497, "dan.frees@gmail.com", "Dan Frees", "07502823043");
        // find Customer
        CustomerDTO customer = contr.findCustomer("07502823043");
        System.out.println(customer.getName());
        // create repairorder
        contr.createRepairOrder("brakes do not work.", 109497, "07502823043", 1);
        // find repairorder with phonenumber
        RepairOrderDTO repairOrder = contr.findRepairOrder("07502823043");
        System.out.println(repairOrder.getCustomerPhone());
        // find all repairorders as list
        contr.createRepairOrder("chains are broken.", 116397, "075035623043", 2);
        List<RepairOrderDTO> repairList = contr.findAllRepairOrders();
        for (RepairOrderDTO orders:repairList){
            System.err.println("******");
            System.err.println(orders.getCustomerPhone());
        }
        contr.addDiagnosticResults(1, "brake string has losen up.");
        contr.addRepairTask(1, "Change brake string.", 800);
        List<RepairOrderDTO> repairlist2 = contr.findAllRepairOrders();
        for (RepairOrderDTO orders:repairlist2){
            System.err.println("*******");
            System.err.println(orders.getDiagnosticResults());
            System.err.println(orders.getRepairTask());
        }
        contr.repairOrderAccepted(1, true);
        contr.repairOrderAccepted(2, false);
        List<RepairOrderDTO> repairlist3 = contr.findAllRepairOrders();
        for (RepairOrderDTO orders:repairlist3){
            System.err.println("------");
            System.err.println(orders.isAccepted());
        }
    }
}
