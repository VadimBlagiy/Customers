package ua.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.test.task.dto.CustomerRequest;
import ua.test.task.model.Customer;
import ua.test.task.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements BusinessLogicService {

     private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return  customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setFullName(customerRequest.getFullName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhone(customerRequest.getPhone());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.getOne(id);
        customer.setFullName(customerRequest.getFullName());
        customer.setPhone(customerRequest.getPhone());
            return customerRepository.save(customer);
        }
}
