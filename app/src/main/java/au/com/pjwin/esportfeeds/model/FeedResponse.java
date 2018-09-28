package au.com.pjwin.esportfeeds.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.Date;
import java.util.List;

@Root(name = "feed", strict = false)
public class FeedResponse {

    @Element(name = "id")
    private String id;

    @Element
    private Title title;

    @Element(name = "updated")
    private Date updated;

    @Element
    private Link link;

    @Element
    private Author author;

    @Element
    private Category category;

    @Element
    private Generator generator;

    @ElementList(inline = true, required = false)
    private List<Contributor> contributorList;

    @ElementList(inline = true)
    private List<FeedEntry> feedEntryList;

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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Contributor> getContributorList() {
        return contributorList;
    }

    public void setContributorList(List<Contributor> contributorList) {
        this.contributorList = contributorList;
    }

    public List<FeedEntry> getFeedEntryList() {
        return feedEntryList;
    }

    public void setFeedEntryList(List<FeedEntry> feedEntryList) {
        this.feedEntryList = feedEntryList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    @Root(name = "author", strict = false)
    public static class Author {

        @Element(name = "name")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Root(name = "generator", strict = false)
    public static class Generator {

        @Attribute(name = "uri")
        private String uri;

        @Attribute(name = "version")
        private String version;

        @Text
        private String text;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @Root(name = "contributor", strict = false)
    public static class Contributor {

        @Element(required = false)//todo temp fix, cannot parse
        private ContributorName contributorName;

        @Element(name = "uri")
        private String uri;

        public ContributorName getContributorName() {
            return contributorName;
        }

        public void setContributorName(ContributorName contributorName) {
            this.contributorName = contributorName;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }

    //todo nfi why this cannot be parsed, its not essential
    @Root(name = "name", strict = false)
    public static class ContributorName {

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
}

