package demo

class RiderTagLib {
    static namespace = "r"
    static defaultEncodeAs = [taglib:'html']
    static encodeAsForTags = [image: [tagLib:'raw'], otherTagName: [taglib:'none']]

    def image = { attrs ->
        Rider rider = attrs.rider
        if(rider) {
            out << """<img src="${rider.image}" alt="${rider.name}"/>"""
        }
    }
}
