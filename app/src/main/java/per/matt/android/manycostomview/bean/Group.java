package per.matt.android.manycostomview.bean;

import java.util.List;

public class Group {

    public Group(String title,List<User> users){
        this.title=title;
        this.users=users;
    }

    private String title;
    private List<User> users;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
