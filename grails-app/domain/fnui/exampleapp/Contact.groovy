package fnui.exampleapp

class Contact {
    String name

    Gender gender
    String street
    String zipCode
    String city
    String email
    String phoneNumber

    Date birthday

    static constraints = {
        name nullable: false, blank: false
        gender nullable: false
        street nullable: true, blank: true
        zipCode nullable: true, blank: true
        city nullable: true, blank: true
        email nullable: false, blank: false
        phoneNumber nullable: true, blank: true, matches: /\+\d+/
        birthday nullable: true, permissions: ['birthday_officer']
    }

    String toString() {
        "${name} (${email})"
    }
}