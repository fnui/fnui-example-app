package fnui.exampleapp

import fnui.core.annotations.UserInterface
import grails.transaction.Transactional
import org.apache.catalina.User

@Transactional
@UserInterface({
    navigation = ['category':'Customer Care', 'name': 'Requests']
    permissions = ['customer_care']
})
class RequestService {

    List<Request> listRequests() {
        Request.list()
    }

    Request showRequest(Request request) {
        request
    }

    @UserInterface(ignore = true)
    Request createRequest(Request request) {
        request.requestState = RequestState.NEW
        request.save(flush:true)
    }

    @UserInterface({
        requirements = { Request r ->
            r.requestState == RequestState.NEW
        }
    })
    Request addReply(Request request, AddReplyCommand addReplyCommand) {
        request.reply = addReplyCommand.reply
        request.requestState = RequestState.REPLIED
        request.save(flush:true)
    }

    @UserInterface({
        requirements = { Request r ->
            r.requestState == RequestState.REPLIED
        }
        message = 'Request closed.'
    })
    Request closeRequest(Request request) {
        request.requestState = RequestState.CLOSED
        request.save(flush:true)
    }
}