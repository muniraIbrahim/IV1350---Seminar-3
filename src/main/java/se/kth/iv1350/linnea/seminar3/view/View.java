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
        System.out.println(itemAndRunningTotalDTOString(multipleItem));
        multipleItem = contr.enterIdentifier("abc123");
        System.out.println("Add 1 item with item id abc123:");
        System.out.println(itemAndRunningTotalDTOString(multipleItem));
        ItemAndRunningTotalDTO singleItem = contr.enterIdentifier("def456");
        System.out.println("Add 1 item with item id def456:");
        System.out.println(itemAndRunningTotalDTOString(singleItem));
        System.out.println("End sale:");
        Amount totalPrice = contr.endSale();
        System.out.println("Total cost (incl VAT): " + totalPrice.toString() + "\n");
        Amount paidAmount = new Amount(10000);
        System.out.println("Customer pays " + paidAmount + ":");
        Amount change = contr.pay(paidAmount);
        System.out.println("Change to give the customer: " + change);

    }
    
    private String itemAndRunningTotalDTOString(ItemAndRunningTotalDTO item){
        StringBuilder builder = new StringBuilder();
        builder.append("Item ID: " + item.getItem().getIdentifier() + "\n");
        builder.append("Item name: " + item.getItem().getName() + "\n");
        builder.append("Item cost: " + item.getItem().getPrice().plus(item.getItem().getVat()).toString() + "\n");
        builder.append("VAT: " + item.getItem().getVatRate() + "% \n");
        builder.append("Item description: " + item.getItem().getDescription() + "\n");
        builder.append("\n");
        builder.append("Total cost (incl VAT): " + item.getRunningTotal().toString() + "\n");
        builder.append("Total VAT: " + item.getRunningVat().toString() + "\n");
        return builder.toString();
    }

}
