package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.Matchers;
import org.junit.Test;

public class MoneyTest {

	@Test(expected = IllegalArgumentException.class)
	public void additionExceptionTest() {
		Money firstMoney = new Money(new BigDecimal(1500), Currency.getInstance("EUR"));
		Money secondMoney = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
		firstMoney.add(secondMoney);
	}

	@Test(expected = IllegalArgumentException.class)
	public void subtractExceptionTest() {
		Money firstMoney = new Money(new BigDecimal(1500), Currency.getInstance("EUR"));
		Money secondMoney = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
		firstMoney.subtract(secondMoney);
	}

	@Test
	public void additionTest() {
		Money firstMoney = new Money(new BigDecimal(1500), Currency.getInstance("USD"));
		Money secondMoney = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
		Money result = firstMoney.add(secondMoney);
		assertThat(result, Matchers.is(new Money(new BigDecimal(2500), Currency.getInstance("USD"))));
		assertThat(firstMoney.getCurrency().getCurrencyCode(), Matchers.is("USD"));
	}
	
	@Test
	public void subtractTest() {
		Money firstMoney = new Money(new BigDecimal(1500), Currency.getInstance("USD"));
		Money secondMoney = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
		Money result = firstMoney.subtract(secondMoney);
		assertThat(result, Matchers.is(new Money(new BigDecimal(500), Currency.getInstance("USD"))));
		assertThat(firstMoney.getCurrency().getCurrencyCode(), Matchers.is("USD"));
	}

}
