interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        return "Customer#" + id + " - Shivangi Mukherjee";
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection - dependency provided from outside, not created inside
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomer(int id) {
        System.out.println(customerRepository.findCustomerById(id));
    }
}

class Exercise14 {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository); // injected here

        service.printCustomer(101);
    }
}
