package com.codebhatti.kinbech.service;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Tek Ale
 *
 */
public interface ImageService {
	/**
	 * @param The id of the product 
	 * @return BufferedImage object which contains the image associated with the product
	 * @throws IOException
	 */
	public BufferedImage getImageByProductId(Long productId) throws IOException;
}
