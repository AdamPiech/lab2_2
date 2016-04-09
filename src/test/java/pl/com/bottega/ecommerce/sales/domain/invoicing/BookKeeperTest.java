package pl.com.bottega.ecommerce.sales.domain.invoicing;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BookKeeperTest {

	private BookKeeper bookKeeper;
	private TaxPolicy taxPolicy;
	private InvoiceRequest invoiceRequest;
	
	@Before
	public void start () {	
		bookKeeper = new BookKeeper();
		taxPolicy = MyMock.getTaxPolicy();
		invoiceRequest = MyMock.getInvoiceFactory();
	}
	
	@Test
	public void testFirst () {
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoiceRequest.getClient().getName(), Matchers.is("Client"));
	}
	
	@Test
	public void testSecond () {
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoice.getGros(), Matchers.is(new Money(new BigDecimal(1000), Currency.getInstance("PLN"))));
	}
	
	@Test
	public void testThird () {
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoice.getItems().get(0).getProduct(), Matchers.is(MyMock.getMockProductData()));
	}
	
	@Test
	public void testFourth () {
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoice.getNet(), Matchers.is(new Money(new BigDecimal(1000), Currency.getInstance("PLN"))));
	}
}
