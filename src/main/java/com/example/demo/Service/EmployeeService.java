package com.example.demo.Service;

import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by lubov on 04.09.20.
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> emploeeList = employeeRepository.findAll();

        if (emploeeList.size() > 0) {
            return emploeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }

    }

    public EmployeeEntity getEmployeeById(long id) throws RecordNotFoundException {

        Optional<EmployeeEntity> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }

    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = employeeRepository.findById(entity.getId());

        if (employee.isPresent()) {
            EmployeeEntity newEntity = employee.get();

            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());

            employeeRepository.save(newEntity);

            return newEntity;

        } else {
            entity = employeeRepository.save(entity);

            return entity;
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Not employee record for given id");
        }
    }


    public EmployeeEntity addEmployee(EmployeeEntity entity) throws RecordNotFoundException {
        return employeeRepository.save(entity);
    }

}
