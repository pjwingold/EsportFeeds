package au.com.pjwin.esportfeeds.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "collection", strict = false)
data class CategoryCollection @JvmOverloads constructor(

        @field:Attribute(name = "href")
        var href: String = "",

        @field:Element(name = "id")
        var id: String = "",

        @field:Element(name = "title")
        var title: String = "",

        @field:Element(name = "accept", required = false)
        var accept: String? = null,

        @field:Element(name = "abbreviatedName", required = false)
        var abbrName: String? = null,

        @field:Element(required = false)
        var categories: CategoryDetails? = null
)

@Root(name = "categories", strict = false)
data class CategoryDetails @JvmOverloads constructor(

        @field:Attribute(name = "scheme")
        var scheme: String = "",

        @field:Attribute(name = "fixed")
        var fixed: String = "",

        @field:Element
        var category: Category? = null
)

@Root(name = "category", strict = false)
data class Category @JvmOverloads constructor(

        @field:Attribute(name = "term")
        var term: String = ""
)
