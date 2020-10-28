import java.sql.*;

public class DatabaseConnection {

    static final String url = "jdbc:mysql://localhost:3306/pregschool";
    static final String username = "root";
    static final String password = "";
    //static final String DEFAULT_QUERY = "SELECT * FROM Authors";
    static String[] resultValue = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static ResultSet res = null;

    static boolean connectedToDatabase = false;

    public DatabaseConnection() throws  Exception{

        //try {
        //connect to database
        connection = DriverManager.getConnection(url, username, password);

        //create statement to query database
        //statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement = connection.createStatement();

        //resultSet = statement.executeQuery("");

        //update database connection status
        connectedToDatabase = true;
            /*}
            catch(Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, exception.getMessage(), "222Couldn't Connect to Database", JOptionPane.ERROR_MESSAGE);
            }*/
    }



    public void addUser(int pk, String fn, String sn, String pn, String un, String pw, String cpw, String slt) throws SQLException{

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database!");
        }
        else {
            try {
                //connection.createStatement().execute("INSERT INTO users VALUES('"+pk+"','"+fn+"','"+sn+"', '"+pn+"', '"+un+"', '"+pw+"', '"+cpw+"')");
                statement.execute("INSERT INTO users VALUES('"+pk+"','"+fn+"','"+sn+"', '"+pn+"', '"+un+"', '"+pw+"', '"+cpw+"', '"+slt+"')");
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

    }



    public static String[] userLogin(String usernm, String passwd) throws Exception{

        if (!connectedToDatabase) {
            throw new IllegalStateException("111Not Connected to Database!");
        }
        else {
            try {
                //ResultSet res = statement.executeQuery("SELECT * FROM users WHERE username='"+usernm+"'");
                res = statement.executeQuery("SELECT firstname, username, password, saltvalue FROM users WHERE username='"+usernm+"'");
                //ResultSet res = statement.executeQuery("SELECT username, password FROM users WHERE username='"+usernm+"' AND password='"+passwd+"'");

                while (res.next()) {

                    //System.out.print(res);

                    resultValue = new String[] {res.getString("firstname"), res.getString("username"), res.getString("password"), res.getString("saltvalue")};
                    //System.out.println(res.getString("username")+" "+res.getString("password")+" "+res.getString("firstname"));
                    //System.out.println("Username: " + resultValue[0] + "Pssword: " + resultValue[1]);
                }
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
        }
        return resultValue;
    }



    public boolean verifyUsername(String usernm) throws SQLException{
        Boolean result;
        String resultSetValue = null;

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database!");
        }
        else {
            try {
                resultSet = statement.executeQuery("SELECT * FROM users WHERE username='"+usernm+"'");

                while(resultSet.next()) {
                    resultSetValue = resultSet.getString("username");
                }
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return result = usernm.equalsIgnoreCase(resultSetValue);
    }



    public String verify(String usernm) throws SQLException{
        //Boolean result;
        String resultSetValue = null;

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database!");
        }
        else {
            try {
                resultSet = statement.executeQuery("SELECT * FROM users WHERE username='"+usernm+"'");

                while(resultSet.next()) {
                    resultSetValue = resultSet.getString("username");
                }
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return resultSetValue;
    }



}
