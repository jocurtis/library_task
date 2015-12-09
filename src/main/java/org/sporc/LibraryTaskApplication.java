package org.sporc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryTaskApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(LibraryTaskApplication.class, args);
    }
    
	@Bean
	public CommandLineRunner init(BookRepository bookRepository, PersonRepository personRepository) {
		return (args) -> {
			Person bowie = personRepository.save(new Person("David", "Bowie", "0426 342 433", "bowie@space.org"));
			Person newton = personRepository.save(new Person("Isaac", "Newton", "314", "newton@trinity.ox.ac.uk"));
			Person aubrey = personRepository.save(new Person("Jack", "Aubrey", "5291", "jack@surprise.mod.uk"));
			Person shakespeare = personRepository.save(new Person("William", "Shakespeare", "2", "bill@globe.org"));

			Book ducksInSpace = bookRepository.save(new Book("Ducks In Space", "978-1595430502", newton));
			Book goneWithTheWind = bookRepository.save(new Book("Gone With The Wind", "978-1451635621", aubrey));
			Book spaceAdventures = bookRepository.save(new Book("The Space Adventures of David Bowie", "978-0756662776", bowie));
			Book hamlet = bookRepository.save(new Book("Hamlet", "978-0743477123", shakespeare));
			Book actionZebra = bookRepository.save(new Book("Action Zebra", "978-0307988706", newton));
			Book freakyOutHere = bookRepository.save(new Book("It's Freaky Out Here", "978-0823428670", bowie));
			Book kapital = bookRepository.save(new Book("Das Kapital", "978-1453886328", newton));
			Book twilight = bookRepository.save(new Book("Twilight", "978-0316015844", shakespeare));
			
			ducksInSpace.borrow(bowie);
			bookRepository.save(ducksInSpace);
			
			goneWithTheWind.borrow(newton);
			bookRepository.save(goneWithTheWind);
			
			spaceAdventures.borrow(newton);
			bookRepository.save(spaceAdventures);
			
			hamlet.borrow(bowie);
			bookRepository.save(hamlet);

			actionZebra.borrow(aubrey);
			bookRepository.save(actionZebra);

			freakyOutHere.borrow(newton);
			bookRepository.save(freakyOutHere);
			
			kapital.borrow(shakespeare);
			bookRepository.save(kapital);
			
			twilight.borrow(aubrey);
			bookRepository.save(twilight);
		};
	}
}
