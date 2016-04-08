package baiiu.greendao.gen;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SAVED_DAILY_DETAIL".
 */
public class SavedDailyDetail {

    private Long id;
    private String body;
    private String image_source;
    private String image;
    private String title;
    private String share_url;
    private String js;
    private String css;

    public SavedDailyDetail() {
    }

    public SavedDailyDetail(Long id) {
        this.id = id;
    }

    public SavedDailyDetail(Long id, String body, String image_source, String image, String title, String share_url, String js, String css) {
        this.id = id;
        this.body = body;
        this.image_source = image_source;
        this.image = image;
        this.title = title;
        this.share_url = share_url;
        this.js = js;
        this.css = css;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

}
