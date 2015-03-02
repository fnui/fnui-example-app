class UrlMappings {

	static mappings = {
        "/"(controller: 'applicationState') {
            namespace = 'generated'
        }

        "/fnui/$controller/$action?/$id?" {
            namespace = 'generated'
        }

        "/$controller/$action?/$id?(.$format)?"{
        }

        "/$controller/$action?/$id?(.$format)?"{
        }

        "500"(view:'/error')
	}
}
