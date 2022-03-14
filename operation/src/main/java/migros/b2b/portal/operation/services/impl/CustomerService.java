package migros.b2b.portal.operation.services.impl;

import migros.b2b.portal.model.exceptions.EntityNotFoundException;
import migros.b2b.portal.operation.entities.Customer;
import migros.b2b.portal.operation.repositories.ICustomerRepository;
import migros.b2b.portal.operation.services.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer getCustomer(String email) {
        Optional<Customer> customer = customerRepository.findById(email);

        return customer.orElseThrow(EntityNotFoundException::new);
    }
}
