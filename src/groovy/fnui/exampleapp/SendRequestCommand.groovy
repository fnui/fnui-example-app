package fnui.exampleapp

import grails.validation.Validateable

@Validateable
class SendRequestCommand {
    String subject
    String message

    static constraints = {
        subject nullable: false, blank: false
        message nullable: true, blank: true
    }
}
