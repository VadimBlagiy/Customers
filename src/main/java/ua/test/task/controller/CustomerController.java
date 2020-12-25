package ua.test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.test.task.dto.CustomerRequest;
import ua.test.task.model.Customer;
import ua.test.task.service.CustomerService;

import java.util.List;

@RestController()
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void customerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Object allCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer customerAdd(@RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomerRequest customerRead(@PathVariable(value = "id") long id) {
        Customer customer = customerService.findById(id);
        return new CustomerRequest(customer.getId(), customer.getFullName(), customer.getEmail(), customer.getPhone());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object customerUpdate(@PathVariable(value = "id") long id, @RequestBody CustomerRequest customerRequest) {
        return customerService.updateCustomer(id , customerRequest);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void customerDelete(@PathVariable(value = "id") long id) {
        customerService.deleteById(id);
    }

}
