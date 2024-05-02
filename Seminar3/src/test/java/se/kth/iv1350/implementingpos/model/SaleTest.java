package se.kth.iv1350.implementingpos.model;

import se.kth.iv1350.implementingpos.model.LineItem;
import se.kth.iv1350.implementingpos.model.Sale;
import se.kth.iv1350.implementingpos.model.Amount;
import se.kth.iv1350.implementingpos.model.ItemDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
    private Sale sale;
    private ItemDTO item;
    
    @BeforeEach
    public void setUp() {
        sale = new Sale();
        item = new ItemDTO("BigWheel Oatmeal", "abc123", new Amount(2821), "BigWheel Oatmeal 500 g, "
                    + "whole grain oats, high fiber, gluten free", 6);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
        item = null;
    }

    @Test
    public void testSaleSettingDate(){
        LocalDate expectedResult = LocalDate.now();
        LocalDate result = sale.getDateOfSale();
        assertEquals(expectedResult, result, "Date of sale is not set correctly.");
    }
    
    @Test
    public void testSaleSettingTime(){
        LocalTime expectedResult = LocalTime.now().withNano(0);
        LocalTime result = sale.getTimeOfSale().withNano(0);
        assertEquals(expectedResult, result, "Time of sale is not set correctly.");
    }
    
    @Test
    public void testRegisterItemItemNotScannedBefore() {
        LineItem lineItem = new LineItem(item, 1);
        ArrayList<LineItem> itemList = new ArrayList<>();
        itemList.add(lineItem);
        sale.registerItem(item);
        assertEquals(itemList.get(0).getItem(), sale.getItemList().get(0).getItem(), "Registered item not added to list correctly");
    }
   
    @Test
    public void testRegisterItemItemScannedBefore() {
        LineItem lineItem = new LineItem(item, 2);
        ArrayList<LineItem> itemList = new ArrayList<>();
        itemList.add(lineItem);
        sale.registerItem(item);
        sale.registerItem(item);
        assertEquals(itemList.get(0).getItem(), sale.getItemList().get(0).getItem(), "Registered item not added to list correctly.");
        assertEquals(2, sale.getItemList().get(0).getQuantity(), "Register item not updating quantity correctly.");
    }
    
    @Test
    public void testRegisterItemRunningTotalAndVatCalculations() {
        sale.registerItem(item);
        Amount expectedRunningTotal = item.getPrice().plus(item.getVat());
        Amount expectedRunningVat = item.getVat();
        Amount resultRunningTotal = sale.getRunningTotal();
        Amount resultRunningVat = sale.getRunningVat();
        assertEquals(expectedRunningTotal, resultRunningTotal, "Register item not calculating running total correctly.");
        assertEquals(expectedRunningVat, resultRunningVat, "Register item not calculating running VAT correctly.");
    }
            
    
}
