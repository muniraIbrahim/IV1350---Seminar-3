package se.kth.iv1350.linnea.seminar3.view;

import se.kth.iv1350.linnea.seminar3.controller.Controller;
import se.kth.iv1350.linnea.seminar3.model.Amount;
import se.kth.iv1350.linnea.seminar3.model.ItemAndRunningTotalDTO;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to
 * all system operations in the Controller.
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance of View.
     * 
     * @param contr Controller that is used for all operations.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    /**
     * Performs a fake sale, calls all the system operations in the controller.
     */
    public void runFakeExecution(){
        contr.startSale();
        ItemAndRunningTotalDTO multipleItem = contr.enterIdentifier("abc123");
        System.out.println("Add 1 item with item id abc123:");
        System.out.println(multipleItem.toString());
        multipleItem = contr.enterIdentifier("abc123");
        System.out.println("Add 1 item with item id abc123:");
        System.out.println(multipleItem.toString());
        ItemAndRunningTotalDTO singleItem = contr.enterIdentifier("def456");
        System.out.println("Add 1 item with item id def456:");
        System.out.println(singleItem.toString());
        System.out.println("End sale:");
        Amount totalPrice = contr.endSale();
        System.out.println("Total cost (incl VAT): " + totalPrice.toString() + "\n");
        Amount paidAmount = new Amount(10000);
        System.out.println("Customer pays " + paidAmount + ":");
        Amount change = contr.pay(paidAmount);
        System.out.println("Change to give the customer: " + change);

    }

}
