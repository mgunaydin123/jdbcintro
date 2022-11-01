import java.sql.*;
import java.util.ArrayList;

public class Main {

    //static String userName="root";
    //static String password="12345";
    //static String dbUrl="jdbc:mysql://localhost:3307/world";

     public static void main(String[] args) throws SQLException {
         Connection connection =null;
         DbHelper helper= new DbHelper();
         //Statement statement=null;
        PreparedStatement statement=null;
         ResultSet resultSet;
         try{
             connection=helper.getConnection();                             //connection=DriverManager.getConnection(dbUrl,userName,password);
             // System.out.println("Bağlantı oluştu");

             //statement =connection.createStatement();
             //resultSet=statement.executeQuery("select Code, Name , Continent, Region from country");
             //resultSet=statement.executeQuery("insert into city(Name,CountryCode,District,Population) values('Düzce', 'TUR','Düzce',50000)");


//             ArrayList<Country> countries = new ArrayList<Country>();
//             while (resultSet.next()){
//                 //System.out.println(resultSet.getString("Name"));
//                 countries.add(new Country(
//                         resultSet.getString("Code"),
//                         resultSet.getString("Name"),
//                         resultSet.getString("Continent"),
//                         resultSet.getString("Region")));
//             }
             //System.out.println(countries.size());
             String sql = "delete from city where id= ?";
             statement= connection.prepareStatement(sql);
             statement.setInt(1,4082);
             statement.executeUpdate();
             System.out.println("Kayıt silindi.");
         }catch (SQLException exception){
             helper.showErrorMessage(exception);
             System.out.println(exception.getMessage());
         }
         finally {
             statement.close();
             connection.close();
         }

    }
    public static void selectDemo() throws SQLException{
        Connection connection =null;
        DbHelper helper= new DbHelper();
        Statement statement=null;
        ResultSet resultSet;
        try{
            connection=helper.getConnection();                             //connection=DriverManager.getConnection(dbUrl,userName,password);
            // System.out.println("Bağlantı oluştu");

            statement =connection.createStatement();
            resultSet=statement.executeQuery("select Code, Name , Continent, Region from country");

            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()){
                //System.out.println(resultSet.getString("Name"));
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }
        finally {
            connection.close();
        }
    }
    public static void insertData() throws SQLException {
        Connection connection =null;
        DbHelper helper= new DbHelper();
        //Statement statement=null;
        PreparedStatement statement=null;
        ResultSet resultSet;
        try{
            connection=helper.getConnection();


            statement= connection.prepareStatement("insert into city(Name,CountryCode,District,Population) values('Düzce', 'TUR','Düzce',50000)");
            statement.executeUpdate();
            System.out.println("Kayıt eklendi.");
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }
        finally {
            statement.close();
            connection.close();
        }
    }
    public void updateData() throws SQLException{
        Connection connection =null;
        DbHelper helper= new DbHelper();
        //Statement statement=null;
        PreparedStatement statement=null;
        ResultSet resultSet;
        try{
            connection=helper.getConnection();
            String sql = "update city set population=100000, district='Turkey' where id= ?";
            statement= connection.prepareStatement(sql);
            statement.setInt(1,4082);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi.");
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }
        finally {
            statement.close();
            connection.close();
        }

    }

}
