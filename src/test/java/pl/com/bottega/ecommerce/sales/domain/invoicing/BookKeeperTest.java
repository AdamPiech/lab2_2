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
	private MyMock mock;
	
	@Before
	public void start () {	
		InvoiceRequest invoiceRequest = mock.getInvoiceFactory();
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
		System.out.println(invoice.getClient().getName());
	}
	
	@Test
	public void testFirst () {
		InvoiceRequest invoiceRequest = mock.getInvoiceFactory();
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoiceRequest.getClient().getName(), Matchers.is("Client"));
	}
	
	@Test
	public void testSecond () {
		InvoiceRequest invoiceRequest = mock.getInvoiceFactory();
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoice.getGros(), Matchers.is(new Money(new BigDecimal(1000), Currency.getInstance("PLN"))));
	}
	
	@Test
	public void testThird () {
		InvoiceRequest invoiceRequest = mock.getInvoiceFactory();
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoice.getItems().get(0).getProduct(), Matchers.is(mock.getMockProductData()));
	}
	
	@Test
	public void testFourth () {
		InvoiceRequest invoiceRequest = mock.getInvoiceFactory();
		Invoice invoice = bookKeeper.issuance(invoiceRequest , taxPolicy);
        assertThat(invoice.getNet(), Matchers.is(new Money(new BigDecimal(1000), Currency.getInstance("PLN"))));
	}
}
