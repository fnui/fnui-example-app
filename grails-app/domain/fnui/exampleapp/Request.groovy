package fnui.exampleapp

class Request {
    String subject

    RequestState requestState

    String message
    String reply

    static belongsTo = [customer: Customer]

    static constraints = {
        subject nullable: false, blank: false
        requestState nullable: false
        message nullable: true, blank: true, displayList: false
        reply nullable: true, blank: true, displayList: false
    }
}