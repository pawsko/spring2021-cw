package pl.javastart.shortener.link;

import javax.persistence.*;

@Entity
class Link {
    @Id
    private String id;
    private String targetUrl;
    private int visits;

    public Link() { }

    public Link(String id, String targetUrl) {
        this.id = id;
        this.targetUrl = targetUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
