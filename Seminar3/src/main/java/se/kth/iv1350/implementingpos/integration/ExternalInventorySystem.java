package se.kth.iv1350.implementingpos.integration;

import se.kth.iv1350.implementingpos.model.Amount;
import se.kth.iv1350.implementingpos.model.ItemDTO;
import se.kth.iv1350.implementingpos.model.SaleDTO;

/**
 * Handles all communication with the external inventory system.
 */
public class ExternalInventorySystem {
    private ItemDTO[] itemArray;
    
    /**
     * Creates an instance of ExternalInventorySystem. Since it does not have a database
     * to communicate with, some ItemDTOs will be created an kept in an array to simulate
     * the fetching from the database.
     */
    public ExternalInventorySystem(){
        this.itemArray = createItemArray();
    }
    
    private ItemDTO[] createItemArray() { 
        ItemDTO[] itemArray = {
            new ItemDTO("BigWheel Oatmeal", "abc123", new Amount(2821), "BigWheel Oatmeal 500 g, "
                    + "whole grain oats, high fiber, gluten free", 6),
            new ItemDTO("YouGoGo Blueberry", "def456", new Amount(1406), "YouGoGo Blueberry 240 g, "
                    + "low sugar youghurt, 29 blueberry flavour", 6),
            };
        return itemArray;
    }
    
    /**
     * Searches the array of ItemDTOs to find an item with the given item identifier. If not found it returns null.
     * 
     * @param itemIdentifier item identifier of the searched item.
     * @return the searched item as ItemDTO, if not found it returns null.
     */
    public ItemDTO findItem(String itemIdentifier){
        for (ItemDTO item : itemArray) {
            if (item.getIdentifier().equals(itemIdentifier)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Updates the external inventory system with quantities sold during sale.
     * 
     * @param sale the current sale.
     */
    public void update(SaleDTO sale){
        
    }

}
