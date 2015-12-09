<html>
  <head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/library.js"></script>
	<title>Library</title>
	<style>
	.button-row, .phone-row {
		width: 10em;
	}
	.name-row {
		width: 50%;
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
			<tr><th scope="col">Name</th><th scope="col">Phone</th><th scope="col">Email</th><th></th></tr>
		  </thead>
		  <tbody>
			<#list people as person>
			  <tr>
				<td class="name-row">${person}</td>
				<td class="phone-row">${person.phoneNumber}</td>
				<td>${person.emailAddress}</td>
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
			<tr><th scope="col">Title</th scope="col"><th>Author</th><th scope="col">ISBN</th></tr>
		  </thead>
		  <tbody>
			<#list books as book>
			  <tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.ISBN}</td>
			  </tr>
			</#list>
		  </tbody>
		</table>
	  </div>
	</div>

	<script src="js/bootstrap.min.js"></script>
	</body>
</html>
