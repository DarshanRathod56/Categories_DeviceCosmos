package devicecosmos.com.categoreis;

public class BlogDownload {
    private String Title,Date,Link,Details,ImageURL,Youtube,Time;

    public BlogDownload() {
    }

    public BlogDownload(String title, String date, String link, String details, String imageURL, String youtube, String time) {
        Title = title;
        Date = date;
        Link = link;
        Details = details;
        ImageURL = imageURL;
        Youtube = youtube;
        Time =  time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }



    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getYoutube() {
        return Youtube;
    }

    public void setYoutube(String youtube) {
        Youtube = youtube;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
