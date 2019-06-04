package rishab.listview.com.testmyapplication;

public class Music {
    private String name;
    private int song;
    private int no;

    public Music(String name,int no,  int song) {
        this.name = name;
        this.song = song;
        this.no = no;
    }

    public int getno() {
        return no;
    }

    public void setno(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
