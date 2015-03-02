package fnui.exampleapp

import grails.validation.Validateable

@Validateable
class CreateCustomerCommand {
    String name
    Gender gender
    String email

    static constraints = {
        name nullable: false, blank: false
        gender nullable: false
        email nullable: false, blank: false
    }
}
