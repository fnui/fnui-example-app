package fnui.exampleapp

import fnui.core.annotations.UserInterface
import fnui.core.command.ListCommand
import fnui.core.viewmodel.ListViewModel
import grails.transaction.Transactional

@Transactional
@UserInterface({
    navigation = ['category':'Customer Care', 'name': 'Contacts']
    permissions = ['contact']
})
class ContactService {

    ListViewModel<Contact> listContacts(ListCommand listCommand) {
        new ListViewModel<>(Contact.list(listCommand.createListParameter()), Contact.count(), listCommand)
    }

    Contact createContact(Contact newContact) {
        newContact.save(flush: true) ?: newContact
    }

    Contact showContact(Contact contact) {
        contact
    }

    Contact updateContact(Contact contact) {
        contact.save(flush: true) ?: contact
    }

    @UserInterface({
        permissions = ['contact', 'contact_delete']
        requirements = { Contact c ->
            c.name.startsWith('Hans')
        }
        message = 'Contact deleted.'
    })
    void deleteContact(Contact contact) {
        contact.delete()
    }
}