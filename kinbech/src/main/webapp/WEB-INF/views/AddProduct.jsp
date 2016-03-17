<div id="body">

		<div id="productsectionheader">
	ADD A NEW PRODUCT:
	</div>
	<br/><br/>
	<form:form commandName="product" enctype="multipart/form-data" action="Add" method="POST">
	  <fieldset id="productaddbox">
	    <legend>Product iNFO:</legend>
	   	Product Title:<br>
	    <form:input type="text" path="title" /><br><br/>
	    Product Description:<br>
	    <form:textarea name="productdescription" path="description" cols="100px" rows="20px" /><br><br>
	<br/><br/>
		Product Category:<br/>
		<select name="category">
		<option value="Electronics">Electronics</option>
		<option value="Apparel">Apparel</option>
		</select>
		<br/>
		<br/>
		Product Quantity:
		<form:input type="text" path="quantityWhenUpload" name="quantity"/><br/><br/>
		Upload An Image<br/><form:input path="imageFile" type="file" name="image" /><br/><br/>
	    <input type="submit" value="Submit">
	  </fieldset>

	</form>
	</div>

