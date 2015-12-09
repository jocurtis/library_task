$(document).ready(function() {
	$(".borrowed-books").click(function(event) {
		var button = $(event.target);
		var personId = button.data("personId");
		
		if (button.parent().children("ul").length > 0) {
			$.each(button.parent().children(".borrowed-book-list"), function(i, child) {
				child.remove();
			});
			
			return;
		}
		
		$.getJSON("borrowedBooks?personId=" + personId, function(result) {
			var bookList = document.createElement("ul");
			$(bookList).addClass("borrowed-book-list");
			
			$.each(result, function(i, book) {
				var li = document.createElement("li");
				$(li).text(book.title + " - " + book.author.firstName + " " + book.author.lastName);
				$(bookList).append(li);
			});
			button.parent().append(bookList);
		});
	});
});