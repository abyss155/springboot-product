//package com.kiit.myFirstSpringboot.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.kiit.myFirstSpringboot.exception.ProductNotFoundException;
//import com.kiit.myFirstSpringboot.model.Product;
//import com.kiit.myFirstSpringboot.response.ErrorResponse;
//import com.kiit.myFirstSpringboot.service.ProductService;
//import com.kiit.myFirstSpringboot.util.APIError;
//
//@Controller
//public class ProductController {
//	
//	@Autowired
//	ProductService productService;
//	
//	private static final Logger logger= Logger.getLogger(ProductController.class);
//	
//	@RequestMapping("/test")
//	public String test(Model model)
//	{
//		Product product=new Product();
//		product.setProductCategory("Electronics");
//		product.setProductDescription("Dell Inspiron 15 Laptop");
//		product.setProductId(1);
//		product.setProductPrice(300);
//		product.setProductTitle("Laptop");
//		model.addAttribute("product",product);
//		return "Test";
//	}
//	
//
//	@PostMapping("/addProduct")
//	@ResponseBody
//	public String addProduct()
//	{
//		Product product=new Product();
//		product.setProductCategory("Electronics");
//		product.setProductDescription("Dell Inspiron 15 Laptop");
//		product.setProductId(1);
//		product.setProductPrice(300.0);
//		product.setProductTitle("Laptop");
//		productService.addProduct(product);
//		return "Product Added Successfully";
//	}
//	
//	@RequestMapping("/addProduct1")
//	@ResponseBody
//	public String addProduct1()
//	{
//		Product product=Product.builder()
//				.productCategory("jewelry")
//				.productPrice(150)	
//				.productTitle("Gold Ring")
//				.productDescription("22kt gold finger ring")
//				.build();
//		productService.addProduct(product);
//		return "Product Added Successfully";
//	}
//	
//	@GetMapping("/getProduct")
//	@ResponseBody
//	public Product getProduct()
//	{
//		
//		return productService.getProduct(1);
//	}
//	
//	@PostMapping("/addProductByRequestParam")
//	@ResponseBody
//	public String addProductByRequestParam(@RequestParam("a") String title,
//										   @RequestParam("b") String description,
//										   @RequestParam("c") String category,
//										   @RequestParam("d") double price )
//			
//	{
//		Product product=Product.builder()
//				.productCategory(category)
//				.productPrice(price)	
//				.productTitle(title)
//				.productDescription(description)
//				.build();
//		productService.addProduct(product);
//		return "Product Added Successfully";
//	}
//	
//	
//	@PostMapping("/addProductByPathVariable/{a}/{b}/{c}/{d}")
//	@ResponseBody
//	public Product addProductByPathVariable(@PathVariable("a") String title,
//									 	   @PathVariable("b") String description,
//										   @PathVariable("c") String category,
//										   @PathVariable("d") double price )
//			
//	{
//		Product product=Product.builder()
//				.productCategory(category)
//				.productPrice(price)	
//				.productTitle(title)
//				.productDescription(description)
//				.build();
//		return productService.addProduct(product);
//	}
//	
//	@PostMapping("/addProductByRequestBody")
//	@ResponseBody
//	public ResponseEntity<?> addProductByRequestBody(@RequestBody @Valid Product product , BindingResult bindingResult )
//			
//	{
//		logger.info("Controller Method for Add Product API request for Product" + product.getProductId());
//		if(bindingResult.hasErrors())
//		{
//			List<APIError> errors = new ArrayList<>();
//			for(FieldError error : bindingResult.getFieldErrors())
//			{
//				APIError error1 = new APIError(error.getDefaultMessage(), error.getField(),error.getRejectedValue());
//				errors.add(error1);
//			}
//			return new ResponseEntity<List<APIError>>(errors,HttpStatus.BAD_REQUEST); 
//		}
//		Product product1 = productService.addProduct(product);
//		logger.info("Product Added Successfully c" + product.getProductId());
//		return new ResponseEntity<Product>(product1,HttpStatus.CREATED);
//	}
//	
//	
//	@PostMapping("/addMultipleProductsByRequestBody")
//	@ResponseBody
//	public List<Product> addMultipleProductsByRequestBody(@RequestBody List<Product> products)
//			
//	{
//		List<Product> products1 = productService.addMultipleProductsByRequestBody(products);
//		return products1;
//	}
//	
//	
//	
//	@GetMapping("/getProducts")
//	@ResponseBody
//	public List<Product> getProducts()
//			
//	{
//		List<Product> products= productService.getProducts();
//		return products;
//	}
//
//	@GetMapping("/getProductByID")
//	@ResponseBody
//	ResponseEntity<Product> getProductByID(@RequestParam("pno") int pno)
//			
//	{
//		Product product = productService.getProductByID(pno);
//		return new ResponseEntity<Product> (product, HttpStatus.OK);
//	}
//	
//	@GetMapping("/products/{productID}")
//	@ResponseBody
//	public ResponseEntity<?> getSingleProduct(@PathVariable int productID) {
//		try {
//			return new ResponseEntity<Product>(productService.getSingleProduct(productID), HttpStatus.OK);
//		}
//		catch (ProductNotFoundException e){
//			ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),false);
//			return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@PutMapping("/updateProduct/{prodId}")
//	public ResponseEntity<Product> updateProduct(@PathVariable int prodId, @RequestBody Product newValue)
//	{
//		return new ResponseEntity<Product>(productService.updateProduct(prodId,newValue),HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/deleteProduct/{prodId}")
//	public ResponseEntity<String> deleteProduct(@PathVariable int prodId)
//	{
//		productService.deleteProduct(prodId);
//		return new ResponseEntity<String>("Product Deleted with ID"+prodId ,HttpStatus.OK);
//	}
//	
//	@GetMapping("/getCategories")
//	ResponseEntity <List<String>> getCategories()
//	{
//		List<String> categories = productService.getCategories();
//		return new ResponseEntity <List<String>> (categories ,HttpStatus.OK);
//	} 
//	
//	
//	@GetMapping("/searchProduct/{searchString}")
//	ResponseEntity <List<Product>> searchProduct(@PathVariable String searchString)
//	{
//		List<Product> productList= productService.searchProduct(searchString);
//		return new ResponseEntity <List<Product>> (productList ,HttpStatus.OK);	
//	}
//	
//	@GetMapping("/getProductByPagination/{pageNumber}/{pageSize}")
//	ResponseEntity <Page<Product>> getProductByPagination(@PathVariable int pageNumber, @PathVariable int pageSize)
//	{
//		Page<Product> productPage= productService.getProductByPagination(pageNumber,pageSize);
//		return new ResponseEntity <Page<Product>> (productPage ,HttpStatus.OK);	
//	}
//}
//
//
//
//
///*
//{
//    "productTitle": "Ring",
//    "productDescription": "Made from 24Karat Gold ",
//    "productCategory": "Jewelry",
//    "productPrice": 1660.0
//}
//
//[
//    {
//        "productTitle": "Portable HDD",
//        "productDescription": "WD 2TB Portable HDD",
//        "productCategory": "Electronics",
//        "productPrice": 300.0
//    },
//    {
//        "productTitle": "Portable HDD",
//        "productDescription": "Sandisk 2TB Portable HDD",
//        "productCategory": "Electronics",
//        "productPrice": 190.0
//    },
//    {
//        "productTitle": "TV",
//        "productDescription": "56 inch LED TV Sony",
//        "productCategory": "Electronics",
//        "productPrice": 1590.0
//    },
//    {
//        "productTitle": "Hp Pavilion",
//        "productDescription": "win 11 16GB ram, 512 SSD",
//        "productCategory": "Electronics",
//        "productPrice": 499.0
//    }
//   ]
//*/
