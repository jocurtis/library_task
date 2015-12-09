package org.sporc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LibraryController {

	private BookRepository bookRepository;
	private PersonRepository personRepository;

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	@Autowired
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping(path = "/")
    public String index(Model model) {
		model.addAttribute("people", getPersonRepository().findAll());
        return "index";
    }

	@RequestMapping(path = "/borrowedBooks", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBorrowedBooks(@RequestParam Long personId) {
		return getBookRepository().findByBorrower(getPersonRepository().findOne(personId));
	}	
}
