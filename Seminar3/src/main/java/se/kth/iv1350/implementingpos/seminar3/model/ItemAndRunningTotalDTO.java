package se.kth.iv1350.linnea.seminar3.model;

/**
 * Class to encapsulate an item and a running total.
 */
public class ItemAndRunningTotalDTO {
    private final ItemDTO item;
    private final Amount runningTotal;
    private final Amount runningVat;
    
    /**
     * Creates new instance.
     * 
     * @param item current item being purchased.
     * @param runningTotal running total of current sale.
     */
    public ItemAndRunningTotalDTO (ItemDTO item, Amount runningTotal, Amount runningVat){
        this.item = item;
        this.runningTotal = runningTotal;
        this.runningVat = runningVat;
    }
    
    /**
     * Returns all information in a String.
     * 
     * @return String with all information.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Item ID: " + item.getIdentifier() + "\n");
        builder.append("Item name: " + item.getName() + "\n");
        builder.append("Item cost: " + item.getPrice().plus(item.getVat()).toString() + "\n");
        builder.append("VAT: " + item.getVatRate() + "% \n");
        builder.append("Item description: " + item.getDescription() + "\n");
        builder.append("\n");
        builder.append("Total cost (incl VAT): " + runningTotal.toString() + "\n");
        builder.append("Total VAT: " + runningVat.toString() + "\n");
        return builder.toString();
    }
    
    /**
     * Returns the item attribute.
     * 
     * @return the item.
     */
    public ItemDTO getItem(){
        return item;
    }
    
    /**
     * Returns the runningTotal attribute.
     * 
     * @return the running total.
     */
    public Amount getRunningTotal(){
        return runningTotal;
    }

}
