package migros.b2b.portal.operation.services;

import migros.b2b.portal.operation.entities.Customer;

public interface ICustomerService {
    Customer getCustomer(String email);
}
