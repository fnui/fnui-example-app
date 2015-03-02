package fnui.exampleapp

import grails.validation.Validateable

@Validateable
class AddReplyCommand {
    String reply

    static constraints = {
        reply nullable: true, blank: true
    }
}
