package inventory.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.UuidGenerator;


/*
 * The persistent class for the product database table.
 */
@UuidGenerator(name="UUID")
@XmlRootElement
@Entity
@NamedQueries({
@NamedQuery(name="Product.updateCountForStore", query="UPDATE Product p SET p.productCount = :productCount WHERE p.sku = :sku and p.storeNumber = :storeNumber"),
@NamedQuery(name="Product.findProductCountByStoreNumber", query="SELECT p.productCount FROM Product p WHERE p.sku = :sku and p.storeNumber = :storeNumber") })
@Table(name="PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer sku;

	private Integer productCount;

	private String productName;

	private Integer storeNumber;

	public Product() {
	}

	@Column(name="SKU")
	public Integer getSku() {
		return this.sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public Integer getProductCount() {
		return this.productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name="STORENUMBER")
	public Integer getStoreNumber() {
		return this.storeNumber;
	}

	public void setStoreNumber(Integer storeNumber) {
		this.storeNumber = storeNumber;
	}
}