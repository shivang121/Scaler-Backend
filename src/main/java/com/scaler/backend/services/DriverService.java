package com.scaler.backend.services;

import com.scaler.backend.dto.DriverResponse;
import com.scaler.backend.exceptions.PersonDoesNotContainValidNameException;
import com.scaler.backend.exceptions.PersonDoesNotContainValidPhoneNumberException;
import com.scaler.backend.model.Driver;
import com.scaler.backend.model.Person;
import com.scaler.backend.repository.DriverRepository;
import com.scaler.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;


    @Autowired
    private PersonRepository personRepository;
    public DriverResponse addDriverService(Person person) throws PersonDoesNotContainValidNameException, PersonDoesNotContainValidPhoneNumberException {

        System.out.println(person);

        if(person.getName().equals("")){
            throw new PersonDoesNotContainValidNameException("Please enter valid name");
        }
        if(Long.toString(person.getPhoneNumber()).isEmpty()){
            throw new PersonDoesNotContainValidPhoneNumberException("Please enter Phone Number");
        }

        Person newPerson = personRepository.save(person);
        System.out.println(newPerson);
        Driver driver = new Driver();
        driver.setPerson(newPerson);

        Driver ResponseDriver = driverRepository.save(driver);

        DriverResponse driverResponse = new DriverResponse();
        driverResponse.setSuccess(true);
        driverResponse.setMessage("Added Driver");
        driverResponse.setDriver(ResponseDriver);
        return driverResponse;
    }
}
