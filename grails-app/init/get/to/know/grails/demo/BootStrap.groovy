package get.to.know.grails.demo

import demo.Team
import groovy.json.JsonSlurper
import org.grails.io.support.DefaultResourceLoader

class BootStrap {

    def init = { servletContext ->
        if (!Team.count()) {
            def tourData = new DefaultResourceLoader().getResource('/tourData.json')
            def json = new JsonSlurper().parse(tourData.inputStream)
            json.teams.each { Map team ->
                println "Creating team: $team.name with ${team.riders.size()} riders"
                def newTeam = new Team(name: team.name.trim(), description: team.description)
                team.riders.each { Map rider ->
                    newTeam.addToRiders(rider)
                }
                newTeam.save(failOnError: true)
            }
        }

    }
    def destroy = {
    }
}
