package in.co.stitchup.sf19;

public class Texts {

    private String head,url;

    public Texts() {
    }

    public Texts(String head,String url) {

        this.head = head;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }
}
