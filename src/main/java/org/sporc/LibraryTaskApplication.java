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
			Person bowie = personRepository.save(new Person("David", "Bowie"));
			Person newton = personRepository.save(new Person("Isaac", "Newton"));
			Person aubrey = personRepository.save(new Person("Jack", "Aubrey"));
			Person shakespeare = personRepository.save(new Person("William", "Shakespeare"));

			Book ducksInSpace = bookRepository.save(new Book("Ducks In Space", newton));
			Book goneWithTheWind = bookRepository.save(new Book("Gone With The Wind", aubrey));
			Book spaceAdventures = bookRepository.save(new Book("The Space Adventures of David Bowie", bowie));
			Book hamlet = bookRepository.save(new Book("Hamlet", shakespeare));
			Book actionZebra = bookRepository.save(new Book("Action Zebra", newton));
			Book freakyOutHere = bookRepository.save(new Book("It's Freaky Out Here", bowie));
			Book kapital = bookRepository.save(new Book("Das Kapital", newton));
			Book twilight = bookRepository.save(new Book("Twilight", shakespeare));
			
			ducksInSpace.borrow(bowie);
			bookRepository.save(ducksInSpace);

			goneWithTheWind.borrow(newton);
			bookRepository.save(goneWithTheWind);
			
			spaceAdventures.borrow(newton);
			bookRepository.save(spaceAdventures);
			
			hamlet.borrow(bowie);
			bookRepository.save(hamlet);

			actionZebra.borrow(newton);
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
