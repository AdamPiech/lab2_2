package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MyMock {
	private static ProductData productData = new ProductData(Id.generate(),
			new Money(new BigDecimal(1000), Currency.getInstance("PLN")), "Standard Product", ProductType.STANDARD, new Date());

	static public TaxPolicy getTaxPolicy() {
		return new TaxPolicyMock();
	}

	static public ProductData getMockProductData() {
		return productData;
	}

	static public ClientData getMockClientData() {
		return new ClientData(Id.generate(), "Client");
	}

	static public InvoiceRequest getInvoiceFactory() {
		InvoiceRequest request = new InvoiceRequest(getMockClientData());
		request.add(new RequestItem(getMockProductData(), 100, new Money(new BigDecimal(1000))));
		return request;
	}
}

class TaxPolicyMock implements TaxPolicy {
	public Tax calculateTax(ProductType productType, Money net) {
		return new Tax(new Money(new BigDecimal(1000), Currency.getInstance("PLN")), "Tax Test");
	}
}