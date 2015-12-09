<html>
  <head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/library.js"></script>
	<title>Library</title>
	<style>
	.button-row {
		width: 10em;
	}
	</style>
  </head>
  <body>

	<ul class="nav nav-tabs">
	  <li class="active"><a data-toggle="tab" href="#people">People</a></li>
	  <li><a data-toggle="tab" href="#books">Books</a></li>
	</ul>

	<div class="tab-content">
	  <div id="people" class="tab-pane active">

		<h1>People</h1>
		<table class="table">
		  <thead>
			<tr><th scope="col">Name</th><th></th></tr>
		  </thead>
		  <tbody>
			<#list people as person>
			  <tr>
				<td>${person}</td>
				<td class="button-row"><button type="button" class="btn btn-default borrowed-books" data-person-id="${person.personId}">borrowed books</button></td>
			  </tr>
			</#list>
		  </tbody>
		</table>
	  </div>

	  <div id="books" class="tab-pane">
		<h1>Books</h1>
		<table class="table">
		  <thead>
			<tr><th scope="col">Title</th><th>Author</th></tr>
		  </thead>
		  <tbody>
			<#list books as book>
			  <tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
			  </tr>
			</#list>
		  </tbody>
		</table>
	  </div>
	</div>

	<script src="js/bootstrap.min.js"></script>
	</body>
</html>
