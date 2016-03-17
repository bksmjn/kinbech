package com.codebhatti.kinbech.controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.h2.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codebhatti.kinbech.service.ImageService;

@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	//@RequestMapping(value="/Images/{productId}", method=RequestMethod.GET)
	public void getImage(@PathVariable("productId")Long productId,
			HttpServletResponse response) throws IOException {
		
		BufferedImage image=imageService.getImageByProductId(productId);
		byte[] buffer=((DataBufferByte)image.getData().getDataBuffer()).getData();
		
		response.setContentType("image/jpeg");
		response.setContentLength(buffer.length);
		response.setHeader("Content-Disposition", "inline; filename=\"image\"");
		
		InputStream ins=new ByteArrayInputStream(buffer);
		IOUtils.copy(ins, response.getOutputStream());
		/*response.getOutputStream().write(buffer);
		response.getOutputStream().close();*/
	}
}
