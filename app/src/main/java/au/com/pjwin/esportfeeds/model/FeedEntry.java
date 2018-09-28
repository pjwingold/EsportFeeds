package au.com.pjwin.esportfeeds.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.Date;
import java.util.List;

@Root(name = "entry", strict = false)
public class FeedEntry {

    @Element(name = "id")
    private String id;

    @Element
    private Title title;

    @Element(name = "updated")
    private Date updated;

    @Element(name = "summary")
    private Summary summary;

    @ElementList(inline = true)
    private List<Link> linkList;

    @Element
    private Source source;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @Root(name = "summary", strict = false)
    public static class Summary {
        @Attribute(name = "type")
        private String type;

        @Text
        private String text;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @Root(name = "source", strict = false)
    public static class Source {

        @Element(name = "id")
        private String id;

        @Element(name = "title")
        private String title;

        @Element(required = false)
        private Published published;

        @Element(name = "updated")
        private Date updated;

        @Element(name = "rights")
        private String rights;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Date getUpdated() {
            return updated;
        }

        public void setUpdated(Date updated) {
            this.updated = updated;
        }

        public String getRights() {
            return rights;
        }

        public void setRights(String rights) {
            this.rights = rights;
        }

        public Published getPublished() {
            return published;
        }

        public void setPublished(Published published) {
            this.published = published;
        }
    }

    public static class Published {
        @Attribute(name = "ext", required = false)
        private String ext;

        @Text
        private Date date;

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
