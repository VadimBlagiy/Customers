package ua.test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.test.task.model.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
