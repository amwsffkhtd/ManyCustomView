package per.matt.android.manycostomview.bean;

import java.util.List;

public class GroupSuspend {
    public static final int HEAD_TYPE=1;
    public static final int CONTENT_TYPE=2;

    public GroupSuspend(int type,String title,String headTitle){
        this.title=title;
        this.type=type;
        this.headTitle=headTitle;
    }

    private int type;
    private String title;
    private String headTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }
}
