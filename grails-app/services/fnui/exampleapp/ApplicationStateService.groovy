package fnui.exampleapp

import fnui.core.annotations.UserInterface
import grails.util.Environment
import grails.util.Metadata
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.GrailsPlugin


@UserInterface({
    permissions = ['user']
})
class ApplicationStateService {

    GrailsApplication grailsApplication

    ApplicationInfo showApplicationInfo() {
        def info = new ApplicationInfo()
        def appMetadata = Metadata.getCurrent()
        info.with {
            name = appMetadata['app.name']
            appVersion = appMetadata['app.version']
            grailsVersion = appMetadata['app.grails.version']
            groovyVersion = GroovySystem.version
            jvmVersion = System.getProperty('java.version')
            reloadingActive = Environment.reloadingAgentEnabled
            countController = grailsApplication.controllerClasses.size()
            countDomains = grailsApplication.domainClasses.size()
            countServices = grailsApplication.serviceClasses.size()
            countTagLibraries = grailsApplication.tagLibClasses.size()
            plugins = grailsApplication.mainContext.pluginManager.allPlugins
        }

        return info
    }
}

class ApplicationInfo {
    String name
    String appVersion
    String grailsVersion
    String groovyVersion
    String jvmVersion
    Boolean reloadingActive
    Integer countController
    Integer countDomains
    Integer countServices
    Integer countTagLibraries

    List<GrailsPlugin> plugins
}