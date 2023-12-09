package hello.app.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "category", strict = false)
data class Category @JvmOverloads constructor(
    @field:Attribute(name = "id", required = false)
    var id: String? = null,

    @field:Attribute(name = "term", required = false)
    var term: String? = null,

    @field:Attribute(name = "scheme", required = false)
    var scheme: String? = null,

    @field:Attribute(name = "label", required = false)
    var label: String? = null
)
