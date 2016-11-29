package demo

class Team {
    String name
    String description

    static constraints = {
        name unique: true
        description nullable: true, widget: 'textArea'
    }

    static hasMany = [riders: Rider]

    static mapping = {
        description type: 'text'
    }
}
