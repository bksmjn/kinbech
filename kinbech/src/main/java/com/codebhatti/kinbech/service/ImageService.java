package com.codebhatti.kinbech.service;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ImageService {
	public BufferedImage getImageByProductId(Long productId) throws IOException;
}
