package com.hendisantika.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.entity.Customers;
import com.hendisantika.repository.CustomerRepository;

@Service
public class CustomerService extends AbstractService<Customers, Long> {

    @Autowired
    private CustomerRepository customersRepository;

    @Override
    protected JpaRepository<Customers, Long> getRepository() {
        return customersRepository;
    }

}