package com.codebhatti.kinbech.serviceimpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.ProductCopy;
import com.codebhatti.kinbech.repository.ProductRepository;
import com.codebhatti.kinbech.service.ProductCopyService;
import com.codebhatti.kinbech.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCopyService productCopyService;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public Product saveOrUpdate(Product product) throws IllegalStateException, IOException {
		List<ProductCopy> newProductCopies = new ArrayList<>();

		if (product != null && product.getQuantityWhenUpload() != null) {
			for (int i = 0; i < product.getQuantityWhenUpload(); i++) {
				ProductCopy newCopy = new ProductCopy();
				newCopy.setProduct(product);
				System.out.println(newCopy.printAsString());
				newProductCopies.add(newCopy);
			}
		}
		
		product.setProductCopyList(newProductCopies);
		Product savedProduct = productRepository.save(product);
		//productCopyService.addProductCopies(savedProduct);
		String imagePath = saveImage(product.getImageFile(), savedProduct.getProductId());
		savedProduct.setImagePath(imagePath);
		savedProduct=productRepository.save(product);
		return savedProduct;
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public Product findByProductId(Long productId) {
		return productRepository.findOne(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	private String saveImage(MultipartFile imageFile, Long productId) throws IllegalStateException, IOException {
		String rootDir = servletContext.getRealPath("/")+"products"+File.separator+"images";
		File dir=new File(rootDir);
		if(!dir.exists())
			dir.mkdirs();
		String ext = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().length()-3);
		File imgFile = new File(dir.getAbsolutePath()+File.separator+"product_"+productId+"."+ext);
		System.out.println(imgFile.getAbsolutePath());
		imageFile.transferTo(imgFile);
		return imgFile.getAbsolutePath();
	}
}
