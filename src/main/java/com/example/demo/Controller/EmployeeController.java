package com.example.demo.Controller;

import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Model.UserProfile;
import com.example.demo.Service.EmployeeService;
import com.example.demo.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lubov on 04.09.20.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = employeeService.getAllEmployees();

        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee) throws RecordNotFoundException {

        EmployeeEntity ubdated = employeeService.createOrUpdateEmployee(employee);

        return new ResponseEntity<EmployeeEntity>(ubdated, new HttpHeaders(), HttpStatus.OK);


    }

    @PutMapping("/employee/add")
    public ResponseEntity<EmployeeEntity> addEmployeePUT(@RequestBody EmployeeEntity employee) throws RecordNotFoundException {

        return new ResponseEntity<EmployeeEntity>(employeeService.addEmployee(employee), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeId(@PathVariable("id") Long id) throws RecordNotFoundException {

        employeeService.deleteEmployeeById(id);

        return HttpStatus.FORBIDDEN;
    }

//    @RequestMapping("/api/users/me")
//    public ResponseEntity<UserProfile> profile() {
//        //Build some dummy data to return for testing
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String email = user.getUsername() + "@howtodoinjava.com";
//
//        UserProfile profile = new UserProfile();
//        profile.setName(user.getUsername());
//        profile.setEmail(email);
//
//        return ResponseEntity.ok(profile);
//    }

}
