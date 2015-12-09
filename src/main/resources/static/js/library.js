$(document).ready(function() {
	$(".borrowed-books").click(function(event) {
		var button = $(event.target);
		var personId = button.data("personId");
		var bookListId = "borrowed-book-list-" + personId;

		if ($("#" + bookListId).length > 0) {
			$("#" + bookListId).remove();
			return;
		}

		$.getJSON("borrowedBooks?personId=" + personId, function(result) {
			var bookList = document.createElement("ul");
			$(bookList).attr("id", bookListId);

			$.each(result, function(i, book) {
				var li = document.createElement("li");
				$(li).text(book.title + " - " + book.author.firstName + " " + book.author.lastName);
				$(bookList).append(li);
			});
			button.parents("tr").children("td").first().append(bookList);
		});
	});
});
