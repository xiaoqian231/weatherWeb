import java.util.ArrayList;

public class User {
    public int a;
    private String name;
    private int ID;
    private String password;
    ArrayList<String> topic = new ArrayList<>();
    public UserDAO userDAO = new UserDAO();
public  void addNewTopic(String a){

   topic.add(a);
}
    public User() {
    }

    public User(String name, int ID, String password) {
        this.name = name;
        this.ID = ID;
        this.password = password;

        userDAO.adduser(name,password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", password='" + password + '\'' +
                ", arrayList=" + topic +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }
}
