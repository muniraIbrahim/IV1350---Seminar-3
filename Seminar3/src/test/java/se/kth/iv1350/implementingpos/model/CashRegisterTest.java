package se.kth.iv1350.implementingpos.model;

import se.kth.iv1350.implementingpos.model.Amount;
import se.kth.iv1350.implementingpos.model.CashRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashRegisterTest {
    private CashRegister register;
    
    @BeforeEach
    public void setUp() {
        register = new CashRegister();
    }
    
    @AfterEach
    public void tearDown() {
        register = null;
    }

    @Test
    public void testCashRegisterInitializesToZero() {
        Amount expectedResult = new Amount(0);
        Amount result = register.getBalance();
        assertEquals(expectedResult, result, "CashRegister does not initialize to 0.");
    }    
    
    @Test
    public void testAddPaymentNonZero() {
        Amount expectedResult = new Amount(100);
        register.addPayment(expectedResult);
        Amount result = register.getBalance();
        assertEquals(expectedResult, result, "addPayment does not return correct value.");
    }
    
    @Test
    public void testAddPaymentZero() {
        Amount expectedResult = new Amount(0);
        register.addPayment(expectedResult);
        Amount result = register.getBalance();
        assertEquals(expectedResult, result, "addPayment does not return correct value.");
    }
    
}
