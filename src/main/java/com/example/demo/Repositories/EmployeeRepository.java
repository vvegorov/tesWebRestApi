package com.example.demo.Repositories;

import com.example.demo.Model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lubov on 30.08.20.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
