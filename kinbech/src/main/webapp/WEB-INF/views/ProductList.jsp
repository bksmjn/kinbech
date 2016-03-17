
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="body">
	<div id="productsectionheader">LIST OF PRODUCTS:</div>


	<c:forEach items="${products}" var="product">
		
			<div id="productbox">
				<div class="productimage">
				<a href="/kinbech/products/ProductDetail?productId=${product.productId}">
					<img width="200px" height="200px"
						src="/kinbech/Images/product_${product.productId}.jpg" />
						</a>
				</div>
				<div class="productinfo">

					<div class="producttitle">${product.title}</div>

					<div class="productdetails">${product.description}</div>

					<span class="sellerid"> <strong>Sold By:</strong>${product.sellerId }
					</span>
					<div class="price">
						<strong>Price:</strong>
					</div>

				</div>
			</div>
		
</c:forEach>


</div>