package com.kiit.myFirstSpringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiit.myFirstSpringboot.exception.ProductNotFoundException;
import com.kiit.myFirstSpringboot.model.Product;
import com.kiit.myFirstSpringboot.response.ErrorResponse;
import com.kiit.myFirstSpringboot.service.ProductService;
import com.kiit.myFirstSpringboot.util.APIError;

@Controller
public class ProductControllerFE {
	
	@Autowired
	ProductService productService;
	
	private static final Logger logger= Logger.getLogger(ProductControllerFE.class);
	
	@RequestMapping("/showProducts")
	public String showProducts(Model model)
	{
		List<Product> products=productService.getProducts();
		model.addAttribute("products",products);
		return "AllProducts";   //html file - name of the html file 
	}
	
	

	@RequestMapping("/addProductForm")
	public String addProductForm(Model model)
	{
		Product product = new Product();
		model.addAttribute("product",product);
		return "AddProductForm";
	}

	
	@PostMapping("/addProductByRequestBody")
	public String addProductByRequestBody(@ModelAttribute @Valid Product product , BindingResult bindingResult )
			
	{
		logger.info("Controller Method for Add Product API request for Product" + product.getProductId());
		if(bindingResult.hasErrors())
		{
			List<APIError> errors = new ArrayList<>();
			for(FieldError error : bindingResult.getFieldErrors())
			{
				APIError error1 = new APIError(error.getDefaultMessage(), error.getField(),error.getRejectedValue());
				errors.add(error1);
			}
			return "AddProductForm";
		}
		Product product1 = productService.addProduct(product);
		logger.info("Product Added Successfully c" + product.getProductId());
		return "redirect:/showProducts"; //endpoint  -->>redirect: endpoint name
	}
	
	@RequestMapping("/deleteProduct/{prodId}")
	public String deleteProduct(@PathVariable int prodId)
	{
		productService.deleteProduct(prodId);
		return "redirect:/showProducts";
	}
	
	@RequestMapping("/updateProductForm/{prodId}")
	public String updateProductForm(@PathVariable int prodId, Model model) {
	    Product existingProduct = productService.getProductByID(prodId);
	    model.addAttribute("product", existingProduct);
	    return "UpdateProductForm"; // This is the new HTML form you’ll create next
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product updatedProduct) {
	    productService.updateProduct(updatedProduct.getProductId(), updatedProduct);
	    return "redirect:/showProducts";
	}

	@GetMapping("/getCategories")
	ResponseEntity <List<String>> getCategories()
	{
		List<String> categories = productService.getCategories();
		return new ResponseEntity <List<String>> (categories ,HttpStatus.OK);
	} 
	
	
	@GetMapping("/searchProduct/{searchString}")
	ResponseEntity <List<Product>> searchProduct(@PathVariable String searchString)
	{
		List<Product> productList= productService.searchProduct(searchString);
		return new ResponseEntity <List<Product>> (productList ,HttpStatus.OK);	
	}
	
	@GetMapping("/getProductByPagination/{pageNumber}/{pageSize}")
	ResponseEntity <Page<Product>> getProductByPagination(@PathVariable int pageNumber, @PathVariable int pageSize)
	{
		Page<Product> productPage= productService.getProductByPagination(pageNumber,pageSize);
		return new ResponseEntity <Page<Product>> (productPage ,HttpStatus.OK);	
	}
}




/*
{
    "productTitle": "Ring",
    "productDescription": "Made from 24Karat Gold ",
    "productCategory": "Jewelry",
    "productPrice": 1660.0
}

[
    {
        "productTitle": "Portable HDD",
        "productDescription": "WD 2TB Portable HDD",
        "productCategory": "Electronics",
        "productPrice": 300.0
    },
    {
        "productTitle": "Portable HDD",
        "productDescription": "Sandisk 2TB Portable HDD",
        "productCategory": "Electronics",
        "productPrice": 190.0
    },
    {
        "productTitle": "TV",
        "productDescription": "56 inch LED TV Sony",
        "productCategory": "Electronics",
        "productPrice": 1590.0
    },
    {
        "productTitle": "Hp Pavilion",
        "productDescription": "win 11 16GB ram, 512 SSD",
        "productCategory": "Electronics",
        "productPrice": 499.0
    }
   ]
*/
