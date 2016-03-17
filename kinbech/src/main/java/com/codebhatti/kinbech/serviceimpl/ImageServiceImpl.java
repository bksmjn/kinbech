package com.codebhatti.kinbech.serviceimpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.service.ImageService;
import com.codebhatti.kinbech.service.ProductService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ProductService productService;
	
	@Override
	public BufferedImage getImageByProductId(Long productId) throws IOException {
		Product product=productService.findByProductId(productId);
		File file=new File(product.getImagePath());
		BufferedImage image = ImageIO.read(file);
		return image;
	}

}
