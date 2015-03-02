package fnui.exampleapp

class Customer {
    Contact contact

    Long requestsSent = 0

    static hasMany = [requests:Request]

    static constraints = {
        contact nullable: false
    }
}