package com.adamsware.moss.service;

import com.adamsware.moss.model.Customer;
import com.adamsware.moss.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public boolean createCustomer (Customer customer) {

        List<Customer> customers =
                customerRepository.findAll().stream()
                        .filter(
                                eachCustomer -> eachCustomer.getFirstname().equals(customer.getFirstname()) &&
                                eachCustomer.getLastname().equals(customer.getLastname()))
                        .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(customers)) {
            customer.setCreateDate(new Date());
            customer.setBirthDate(new Date());
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public boolean deleteById(Long id) {

        try {
            Customer customer = new Customer();
            customer.setId(id);
            customerRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
