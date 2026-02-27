package br.com.eurudio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eurudio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
