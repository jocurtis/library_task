package org.sporc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long bookId;
    private String title;
    private String ISBN;
    
    @ManyToOne
    @JoinColumn(name="authorId")
    private Person author;

    @ManyToOne
    @JoinColumn(name="borrowerId")
    private Person borrower;
    
    protected Book() {}

    public Book(String title, String ISBN, Person author) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
    }

    public void borrow(Person borrower) {
    	this.borrower = borrower;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s", title, author);
    }

    public String getTitle() {
		return title;
	}
    
    public Person getAuthor() {
		return author;
	}
    
    public String getISBN() {
		return ISBN;
	}
}

