package rave.code.data.model.web.nse.page.links;

public class Link {

    public String uri;
    public String caption;
    public String cssStyle;

    public Link(){
        this.uri = "";
        this.caption = "";
        this.cssStyle = "";
    }

    public Link(String uri, String caption, String cssStyle){
        this.uri = uri;
        this.caption = caption;
        this.cssStyle = cssStyle;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }
}
