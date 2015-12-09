package org.sporc;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long personId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<Book> authored;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "borrower")
    private List<Book> borrowed;
    
    protected Person() {}

    public Person(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public long getPersonId() {
		return personId;
	}
    
    public String getFirstName() {
		return firstName;
	}
    
    public String getLastName() {
		return lastName;
	}
    
    public String getPhoneNumber() {
		return phoneNumber;
	}
    
    public String getEmailAddress() {
		return emailAddress;
	}
    
    @JsonIgnore
    public List<Book> getBorrowed() {
		return borrowed;
	}
    
    @JsonIgnore
    public List<Book> getAuthored() {
    	return authored;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}

