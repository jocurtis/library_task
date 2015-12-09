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

			ducksInSpace.borrow(bowie);
			bookRepository.save(ducksInSpace);

			hamlet.borrow(bowie);
			bookRepository.save(hamlet);

			actionZebra.borrow(bowie);
			bookRepository.save(actionZebra);
			
			goneWithTheWind.borrow(newton);
			bookRepository.save(goneWithTheWind);
		};
	}
}
