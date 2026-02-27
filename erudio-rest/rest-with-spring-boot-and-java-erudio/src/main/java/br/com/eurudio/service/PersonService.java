package br.com.eurudio.service;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eurudio.exception.ResourceNotFoundException;
import br.com.eurudio.model.Person;
import br.com.eurudio.repository.PersonRepository;


@Service
public class PersonService {
    private Logger logger =  Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;


    public Person findById(Long id){
        logger.info("Finding one Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Person> findAll(){
        logger.info("Finding all People!");
            return repository.findAll();

    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return repository.save(person);
    } 

    public Person update(Person person) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));;
        entity.updateFromDto(person);
        return repository.save(entity);
    } 

    public void delete(Long id){
        logger.info("Deleting one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
