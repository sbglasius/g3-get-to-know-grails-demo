package demo

import grails.validation.Validateable

class DemoController {
    def demoService

    def index(Person person) {
        respond([person:person])
    }

    def save(Person person) {
        if(person.hasErrors()) {
            respond([person: person], view: 'index')
            return
        }
        respond([person: person])
    }

    def call() {
        render(text: demoService.serviceMethod())
    }
}

class Person implements Validateable {
    String name
    int age

    Address address

    static constraints = {
        name nullable: false
        age min: 0
        address nullable: true
    }

}
class Address implements Validateable {
    String street
    String zip
    String city
}
