package ua.test.task.service;

import ua.test.task.dto.CustomerRequest;
import ua.test.task.model.Customer;

import java.util.List;

public interface BusinessLogicService {
    List<Customer> findAll();

    Customer findById(long Id);

    Customer createCustomer(CustomerRequest customerRequest);

    Customer updateCustomer(long id, CustomerRequest customerRequest);

    Customer softDelete(long id, CustomerRequest customerRequest);


}
