package au.com.pjwin.esportfeeds.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "service", strict = false)
data class Service @JvmOverloads constructor(

        @field:Element(name = "workspace")
        var workspace: Workspace? = null
)

@Root(name = "workspace", strict = false)
data class Workspace @JvmOverloads constructor(

        @field:Element(name = "title")
        var title: String = "",

        @field:ElementList(inline = true)
        var collections: List<CategoryCollection>? = null
)