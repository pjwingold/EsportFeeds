package au.com.pjwin.esportfeeds.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "link", strict = false)
public class Link {

    @Attribute(name = "rel")
    private String rel;

    @Attribute(name = "title", required = false)
    private String title;

    @Attribute(name = "type", required = false)
    private String type;

    @Attribute(name = "href")
    private String href;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
