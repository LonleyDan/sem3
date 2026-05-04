package se.kth.iv1350.seminar3.main;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.integration.*;
import se.kth.iv1350.seminar3.view.View;

/**
 * Main to start the application.
 */
public class Main {
    /**
     * creates registries, printer, controller and view. Then runs hardcodded test from view. 
     * @param args commandline not used. 
     */
    public static void main(String[] args) {
        CustomerRegistry customReg = new CustomerRegistry();
        RepairOrderRegistry repairOrdReg = new RepairOrderRegistry();
        Printer printer = new Printer();
        Controller contr = new Controller(customReg, repairOrdReg, printer);
        View view = new View(contr);
        view.Test();
    }
}
