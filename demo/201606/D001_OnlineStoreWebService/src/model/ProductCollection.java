package model;

import java.io.Serializable;
import java.util.List;

public class ProductCollection implements Serializable{
	private static final long serialVersionUID = 1L;
	List<Product> listXXW = null;
	Product[] productCollectionXXW  = null;
	public ProductCollection(int size) {
		productCollectionXXW = new Product[size];
	}
	public void addProducts(List<Product> list) {
		for (int index = 0; index < list.size(); index ++) {
			productCollectionXXW[index] = list.get(index);
			listXXW = list;
		}
	}
	public List<Product> getProductXXW() {
		return listXXW;
	}
}
