package demo

class Rider {
    String name
    String image
    Integer weight
    Date born

    String toString() {
        name
    }

    static constraints = {
        weight nullable: true
    }

    static belongsTo = [team: Team]
}
