package demo

import grails.transaction.Transactional

@Transactional
class DemoService {

    String serviceMethod() {
        return "Grails is Groovy"

    }
}
