package com.adamsware.moss.controller;

import com.adamsware.moss.model.Customer;
import com.adamsware.moss.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adamsware.moss.constant.ResponseMessageConstant.*;
import static com.adamsware.moss.constant.RestPathConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping (CUSTOMER)
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(SAVE)
    public ResponseEntity <?> save (@RequestBody Customer customer) {
        boolean result = customerService.createCustomer(customer);

        if (result) {
            return ResponseEntity.ok().body(CUSTOMER_SAVE_SUCCESS);
        }
        else {
            return ResponseEntity.badRequest().body(CUSTOMER_SAVE_FAILED);
        }
    }

    @GetMapping(GETALL)
    public List <Customer> getAll () {
        return customerService.getAll();
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<?> delete (@RequestParam Long id) {

        if (customerService.deleteById(id)) {
            return ResponseEntity.ok(true);
        }
        else {
            return ResponseEntity.internalServerError().body(false);
        }
    }

}
