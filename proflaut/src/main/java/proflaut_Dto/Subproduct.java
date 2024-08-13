package proflaut_Dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Subproduct_Dto")
public class Subproduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sub_Id;
	private String sub_brand;
	@Override
	public String toString() {
		return "Subproduct [sub_Id=" + sub_Id + ", sub_brand=" + sub_brand + ", price="
				+ price + "]";
	}
	private double price;
	@ManyToOne(cascade=CascadeType.ALL)
	private Product prod;
	public int getSub_Id() {
		return sub_Id;
	}
	public void setSub_Id(int sub_Id) {
		this.sub_Id = sub_Id;
	}

	public String getSub_brand() {
		return sub_brand;
	}
	public void setSub_brand(String sub_brand) {
		this.sub_brand = sub_brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}

}
