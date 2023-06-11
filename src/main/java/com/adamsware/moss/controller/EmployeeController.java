package com.adamsware.moss.controller;

import com.adamsware.moss.model.Employee;
import com.adamsware.moss.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adamsware.moss.constant.RestPathConstant.*;

@RestController
@RequestMapping (EMPLOYEE)
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping(SAVE)
    public void save (@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping(GETALL)
    public List <Employee> getAll () {
        return employeeService.getAll();
    }






}
