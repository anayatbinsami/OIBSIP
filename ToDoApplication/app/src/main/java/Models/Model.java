package Models;

public class Model {

    public Model() {
    }
    int id;
    String title,discription;

    public Model(int id,String title, String discription) {
        this.id = id;
        this.title = title;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
