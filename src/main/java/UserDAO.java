import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private Connection connection=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
  /**
   * creat table in SQL
  * */
    private void createTableUser ()throws SQLException{
        String SQLCreate="CREATE TABLE IF NOT EXISIS USER"
                +"(user_id    int(11)     NOT NULL AUTO_INCREMENT,"
                +"name text NOT NULL,"
                +"password text NOT NULL,"
                +"city text NOT NULL,"
                +"   PRIMARY KEY (`user_id`))";

        Statement stmt = connection.createStatement();
        stmt.execute(SQLCreate);

    }

    public UserDAO() {
        try {
            connection = getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createTableTopic ()throws SQLException{
        String SQLCreate="CREATE TABLE IF NOT EXISIS TOPIC"
                +"(topic_id    int(11)     NOT NULL AUTO_INCREMENT,"
                +"user_id int(11) NOT NULL,"
                +"topic text NOT NULL,"
                +"   PRIMARY KEY (`topic_id`))";

        Statement stmt = connection.createStatement();
        stmt.execute(SQLCreate);

    }
    /**
     * method for login
     * @param name
     * @param password
     * @return user
    * */
    public User login(String name,String password){
        User user = new User();
        try{
            String query = "SELECT * FROM user where login = ? AND password = ?";
            connection=getConnection();
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setID(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                if(connection!=null){connection.close();}
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return  user;
    }

    /**
     * add user to database
     * @param name
     * @param password
     * */
    public boolean adduser (String name, String password){
boolean result=false ;
try{
    String query ="SELECT login FROM user where login =?";
    connection=getConnection();
    preparedStatement= connection.prepareStatement(query);
    preparedStatement.setString(1,name);
    resultSet=preparedStatement.executeQuery();
    if(!resultSet.next()){
        String query2 = "INSERT INTO user(id, name, password) VALUES (NULL, ?, ?)";
        preparedStatement = connection.prepareStatement(query2);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);

        preparedStatement.executeUpdate();
        result = true;
        System.out.println("User has been registered");
    } else {
        System.out.println("User already exists");
    }
}catch (SQLException throwables) {
    throwables.printStackTrace();
} finally {
    try {
        if (connection != null) {
            connection.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
        return result;
    }
/**
 * method add topic
 * */
public void addtopics(int topic_id, int user_id,  String topics) throws Exception {
    String sqlQuerry = "INSERT INTO topics (user_id, topics) VALUES (NULL, ?,?)";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection myConn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/topic", "root", "");
    ;
    PreparedStatement myStmt = null;

    myStmt = myConn.prepareStatement(sqlQuerry);

    myStmt.setInt(1,user_id);
    myStmt.setString(2,topics);


}


    private Connection getConnection()throws SQLException{
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/weatherweb", "root", "");
        return conn;
    }
}
