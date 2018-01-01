
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bid</title>
<link rel="stylesheet" href="assets/demo.css">
<link rel="stylesheet" href="assets/form-labels-on-top.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="assets/bidItem.js"></script>
</head>
<body>

	<div class="main-content">

		<!-- You only need this form and the form-labels-on-top.css -->

		<form class="form-labels-on-top" id="bidItemForm" method="post"
			action="#">

			<div class="form-title-row">
				<h1>Bid Item</h1>
			</div>

			<div class="form-row">
				<label> <span>Title of Book</span></label> <input type="text"
					id="title">
			</div>

			<div class="form-row">
				<label> <span>Comments </span> <textarea id="comments"
						rows="5"></textarea>
				</label>
			</div>

			<div class="form-row">
				<label> <span>Price in $</span></label> <input type="number"
					step="any" id="price">

			</div>

			<div class="form-row">
				<button type="submit" id="bidItem">Submit Form</button>
				<button type="button" id="back">Some other time</button>
			</div>

		</form>

	</div>

</body>
</html>