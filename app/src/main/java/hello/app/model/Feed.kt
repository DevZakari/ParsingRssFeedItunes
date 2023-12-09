package hello.app.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "feed", strict = false)
data class Feed @JvmOverloads constructor(
    @field:ElementList(inline = true, required = false)
    var entry: List<Entry>? = null
)