<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Item</title>

<link rel="stylesheet" href="assets/demo.css">
<link rel="stylesheet" href="assets/form-labels-on-top.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="assets/post.js"></script>
</head>
<body>
	<div class="main-content">

		<!-- You only need this form and the form-labels-on-top.css -->

		<form class="form-labels-on-top" method="post" action="#">

			<div class="form-title-row">
				<h1>Post Item</h1>
			</div>

			<div class="form-row">
				<label> <span>Book Title</span> <input type="text"
					id="bookname">
				</label>
			</div>

			<div class="form-row">
				<label> <span>Author</span> <input type="text" id="author">
				</label>
			</div>

			<div class="form-row">
				<label> <span>Edition</span> <input type="number" step="any"
					id="edition">
				</label>
			</div>

			<div class="form-row">
				<label> <span>Category</span> <input type="text"
					id="category">
				</label>
			</div>

			<div class="form-row">
				<label> <span>Comments </span> <textarea id="comments"
						rows="5"></textarea>
				</label>
			</div>

			<div class="form-row">
				<button type="button" id="post_item">Submit Form</button>
			</div>

		</form>

	</div>

</body>
</html>