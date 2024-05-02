package se.kth.iv1350.linnea.seminar3.model;

import java.util.ArrayList;

/**
 * Contains information about a single sale.
 */
public class SaleDTO {
    private final Amount runningTotal;
    private final Amount runningVat;
    private final ArrayList<LineItem> itemList;

    /**
     * Creates a new instance.
     * 
     * @param sale the current sale.
     */
    public SaleDTO(Sale sale){
        this.runningTotal = sale.getRunningTotal();
        this.runningVat = sale.getRunningVat();
        this.itemList = sale.getItemList();
    }
    
}
