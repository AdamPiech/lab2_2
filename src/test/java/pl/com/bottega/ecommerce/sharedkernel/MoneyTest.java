package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Test;

public class MoneyTest {

	@Test(expected = IllegalArgumentException.class)
    public void additionExceptionTest(){
    	Money firstMoney = new Money(new BigDecimal(1500), Currency.getInstance("EUR"));
		Money secondMoney = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
		Money testResult = firstMoney.add(secondMoney);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void subtractExceptionTest(){
    	Money firstMoney = new Money(new BigDecimal(1500), Currency.getInstance("EUR"));
		Money secondMoney = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
		Money testResult = firstMoney.subtract(secondMoney);
    }

}
