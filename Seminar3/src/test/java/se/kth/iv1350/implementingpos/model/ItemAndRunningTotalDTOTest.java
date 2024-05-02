package se.kth.iv1350.implementingpos.model;

import se.kth.iv1350.implementingpos.model.Amount;
import se.kth.iv1350.implementingpos.model.ItemAndRunningTotalDTO;
import se.kth.iv1350.implementingpos.model.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemAndRunningTotalDTOTest {
    private ItemAndRunningTotalDTO instanceToTest;
    private ItemDTO item;
    private Amount runningTotal;
    private Amount runningVat;
    
    @BeforeEach
    public void setUp() {
        item = new ItemDTO("BigWheel Oatmeal", "abc123", new Amount(2821), "BigWheel Oatmeal 500 g, "
                    + "whole grain oats, high fiber, gluten free", 6);
        runningTotal = new Amount(10000);
        runningVat = new Amount(10000);
        instanceToTest = new ItemAndRunningTotalDTO(item, runningTotal, runningVat);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }

    @Test
    public void testToString() {
        String string = instanceToTest.toString();
        assertTrue(string.contains(item.getIdentifier()), "String does not contain item identifier.");  
        assertTrue(string.contains(item.getName()), "String does not contain item name.");
        assertTrue(string.contains(item.getPrice().plus(item.getVat()).toString()), "String does not contain item price.");
        assertTrue(string.contains(Integer.toString(item.getVatRate())), "String does not contain VAT rate.");
        assertTrue(string.contains(item.getDescription()), "String does not contain item description.");
        assertTrue(string.contains(runningTotal.toString()), "String does not contain running total.");
        assertTrue(string.contains(runningVat.toString()), "String does not contain running VAT.");
    }
    
}
