package proflaut_Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product_Dto")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prod_Id;
	private String prod_Type;
	@Override
	public String toString() {
		return "Product [prod_Id=" + prod_Id + ", prod_Type=" + prod_Type + ", prod_name=" + prod_name + ", p=" + p
				+ "]";
	}
	private String prod_name;
	@OneToMany(cascade = CascadeType.ALL)
	List<Subproduct> p;
	public int getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(int prod_Id) {
		this.prod_Id = prod_Id;
	}
	public String getProd_Type() {
		return prod_Type;
	}
	public void setProd_Type(String prod_Type) {
		this.prod_Type = prod_Type;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public List<Subproduct> getP() {
		return p;
	}
	public void setP(List<Subproduct> p) {
		this.p = p;
	} 
	

}
