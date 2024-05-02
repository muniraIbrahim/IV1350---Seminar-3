package se.kth.iv1350.implementingpos.integration;

import se.kth.iv1350.implementingpos.integration.ExternalInventorySystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.implementingpos.model.Amount;
import se.kth.iv1350.implementingpos.model.ItemDTO;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem instanceToTest;
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new ExternalInventorySystem();
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }

    @Test
    public void testFindItemExists() {
        String itemIdentifier = "abc123";
        String expResult = itemIdentifier;
        String result = instanceToTest.findItem(itemIdentifier).getIdentifier();
        assertEquals(expResult, result, "Existing ItemDTO not found.");
    }
    
    @Test
    public void testFindItemNotFound(){
        String itemIdentifier = "wrong itemIdentifier";
        ItemDTO expResult = null;
        ItemDTO result = instanceToTest.findItem(itemIdentifier);
        assertEquals(expResult, result, "Non existing ItemDTO doesn't return null.");
    }
}
