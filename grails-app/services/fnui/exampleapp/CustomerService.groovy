package fnui.exampleapp

import fnui.core.annotations.UserInterface
import fnui.core.command.ListCommand
import fnui.core.viewmodel.ListViewModel
import grails.transaction.Transactional

@Transactional
@UserInterface({
    navigation = ['category':'Customer Care', 'name': 'Customer']
    permissions = ['customer_care']
})
class CustomerService {

    RequestService requestService

    List<Customer> listCustomers() {
        Customer.list()
    }

    Customer showCustomer(Customer customer) {
        customer
    }

    Customer createCustomer(CreateCustomerCommand command) {
        def contact = new Contact()
        contact.name = command.name
        contact.gender = command.gender
        contact.email = command.email

        contact = contact.save()

        if (!contact) {
            throw new RuntimeException()
        }

        def customer = new Customer()
        customer.contact = contact
        customer.save(flush:true)
    }

    Request sendRequest(Customer customer, SendRequestCommand sendRequestCommand) {
        Request request = new Request()
        request.customer = customer
        request.subject = sendRequestCommand.subject
        request.message = sendRequestCommand.message

        requestService.createRequest(request)
    }
}