<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/library.js"></script>
		<title>Library</title>
	</head>
	<body>
		<h1>People</h1>
		<ul>
			<#list people as person>
			<li>${person} <button type="button" class="btn btn-default borrowed-books" data-person-id="${person.personId}">borrowed books</button></li>
			</#list>
		</ul>
	    
	    <script src="js/bootstrap.min.js"></script>
	</body>
</html>
