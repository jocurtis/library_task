package org.sporc;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);
    List<Person> findByFirstName(String firstName);
}
