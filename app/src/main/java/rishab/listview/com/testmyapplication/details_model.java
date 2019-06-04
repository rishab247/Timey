package rishab.listview.com.testmyapplication;

public class details_model {

    private String title;
    private  String showTime;
    private int image;

    public details_model(String title, String showTime, int image) {
        this.title = title;
        this.showTime = showTime;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getImage() {
        return image;
    }
}
