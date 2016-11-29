package demo

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RiderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Rider.list(params), model:[riderCount: Rider.count()]
    }

    def show(Rider rider) {
        respond rider
    }

    def create() {
        respond new Rider(params)
    }

    @Transactional
    def save(Rider rider) {
        if (rider == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rider.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rider.errors, view:'create'
            return
        }

        rider.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rider.label', default: 'Rider'), rider.id])
                redirect rider
            }
            '*' { respond rider, [status: CREATED] }
        }
    }

    def edit(Rider rider) {
        respond rider
    }

    @Transactional
    def update(Rider rider) {
        if (rider == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (rider.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond rider.errors, view:'edit'
            return
        }

        rider.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rider.label', default: 'Rider'), rider.id])
                redirect rider
            }
            '*'{ respond rider, [status: OK] }
        }
    }

    @Transactional
    def delete(Rider rider) {

        if (rider == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        rider.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rider.label', default: 'Rider'), rider.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rider.label', default: 'Rider'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
