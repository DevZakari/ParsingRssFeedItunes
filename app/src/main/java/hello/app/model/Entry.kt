package hello.app.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "entry", strict = false)
data class Entry @JvmOverloads constructor(
    @field:Element(name = "id", required = false)
    var id: String? = null,

    @field:Element(name = "title", required = false)
    var title: String? = null,

    @field:Element(name = "name", required = false)
    var name: String? = null,


    @field:Element(name = "category", required = false)
    var category: Category? = null,

)
