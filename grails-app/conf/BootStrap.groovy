import fnui.adminlte.security.PermissionsInitializer
import fnui.adminlte.security.SecurityRole
import fnui.adminlte.security.SecurityUser
import fnui.adminlte.security.SecurityUserSecurityRole
import fnui.exampleapp.Contact
import fnui.exampleapp.Gender
import org.codehaus.groovy.grails.commons.GrailsApplication

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->

        PermissionsInitializer.initializePermission(grailsApplication.controllerClasses)

        def user = new SecurityUser().with {
            username = 'test'
            password = 'test'
            save(failOnError: true)
        }

        SecurityRole.list().each { role ->
            SecurityUserSecurityRole.create(user, role)
        }

        def rand = new Random(314159265359L)
        def surnames = ['Müller', 'Maier', 'Schulze', 'Schmidt', 'Bauer', 'Schröder', 'Wilke', 'Zimmmermann', 'Hammer', 'Lehmann', 'Hoffmann', 'Lawrence', 'Sanchez', 'Krause', 'Kranau', 'Krüger', 'Kaiser', 'Freitag', 'Baker']
        def femaleNames = ['Martina', 'Barbara', 'Claudia', 'Christine', 'Kira', 'Heidi', 'Maria', 'Vong', 'Pauline', 'Charly', 'Elfriede', 'Jenifer', 'Sabine', 'Sarah', 'Daniela', 'Fatima', 'Hati', 'Ami', 'Penny']
        def maleNames = ['Maik', 'Silvio', 'Peter', 'Paul', 'Howard', 'Richard', 'Anton', 'Oskar', 'Erik', 'Hans', 'Helmut', 'Charly', 'Daniel', 'George', 'Herny']

        def streets = ['Schlossallee', 'Parkstraße', 'Hauptstraße', 'Turmstraße', 'Elli-Vogt-Straße', 'Parkweg', 'Goetheplatz', 'Opernplatz', 'Neue Straße', 'Potsdamer Straße', 'Oranienstraße', 'Alleestraßenchaussee', 'Broken Boulevard']
        def emails = ['@gmail.com', '@hotmail.com', '@yahoo.com', '@office.com', '@fu-berlin.de', '@live.com', '@web.com', '@stuart.com']
        def cities = ['Berlin', 'New York', 'London', 'Paris', 'Madrid', 'Hamburg', 'Frankfurt', 'Bernau', 'Amsterdam', 'Cern', 'Dortmund', 'Erfurt', 'Freiburg', 'Golm', 'Heidelberg', 'Sydney', 'Tokyo']

        Closure<String> selectRandom = { List<String> list -> list[rand.nextInt(list.size())] }

        45.times {
            def male = rand.nextBoolean()
            def firstName = male ? selectRandom(maleNames) : selectRandom(femaleNames)
            def surname = selectRandom(surnames)

            new Contact().with {
                name = "$firstName $surname"
                gender = male ? Gender.MALE : Gender.FEMALE
                street = "${selectRandom(streets)} ${rand.nextInt(187)+1}"
                zipCode = 10000 + rand.nextInt(80000)
                city = selectRandom(cities)
                email = "${firstName.toLowerCase()}.${surname.toLowerCase()}${selectRandom(emails)}"
                phoneNumber = "+49${1000000000 + rand.nextInt(1000000000)}"
                birthday = Date.parse('d.M.yyyy', "${rand.nextInt(27)+1}.${rand.nextInt(12)+1}.19${rand.nextInt(95)}")
                save(failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
