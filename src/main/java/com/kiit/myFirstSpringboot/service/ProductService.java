package com.kiit.myFirstSpringboot.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;

import com.kiit.myFirstSpringboot.exception.ProductNotFoundException;
import com.kiit.myFirstSpringboot.model.Product;
import com.kiit.myFirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository ;
	
	private static final Logger logger= Logger.getLogger(ProductService.class);
	public Product addProduct(Product product) {	
		logger.info("Service Method for Add Product API request for Product" + product.getProductId());
		return productRepository.save(product);
	}
	
	public Product getProduct(int id) { 
		return productRepository.findById(id).get();
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}

	public List<Product> addMultipleProductsByRequestBody(List<Product> products) {
		
		return productRepository.saveAll(products);
	}

	public Product getProductByID(int pno) {
	    return productRepository.findById(pno).orElse(null);
	}

	public Product getSingleProduct(int productID) {

		Optional<Product> product1= productRepository.findById(productID);
		if(product1.isPresent()) {
			return product1.get();
		}
		else throw new ProductNotFoundException("requested product doesn't exit");
	}

	public Product updateProduct(int prodId, Product newValue) {
		Product productFromDb = getProduct(prodId);
		productFromDb.setProductCategory(newValue.getProductCategory());
		productFromDb.setProductDescription(newValue.getProductDescription());
		productFromDb.setProductPrice(newValue.getProductPrice());
		productFromDb.setProductTitle(newValue.getProductTitle());
		return productRepository.save(productFromDb);
	}

	public void deleteProduct(int prodId) {
		productRepository.deleteById(prodId);
	}

	public List<String> getCategories() {
		return productRepository.getCategories();
	}

	public List<Product> searchProduct(String searchString) {
		return productRepository.findByProductDescriptionContaining(searchString);
	}

	public Page<Product> getProductByPagination(int pageNumber, int pageSize) {
		return productRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	
}
