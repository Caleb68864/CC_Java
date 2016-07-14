package CC_Library;

/*
!!!!!H2 Database Connection is Untested   !!!!!
!!!!!Use CC_H2 if this class does not work!!!!!
*/


import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;


public class CC_Database {
    private Connection conn = null;
    private String strDBUrl = "";
    private String strDBConnection = "";
    private String strDBType = "";
    private String strDBUser = "";
    private String strDBPassword = "";

    public CC_Database(String dbType, String dbURL){
        strDBType = dbType;
        strDBUrl = dbURL.replace("\\","/");

        switch (strDBType) {
            case "sqlite":
                strDBConnection = "jdbc:sqlite:" + strDBUrl;
                break;
            case "mysql":
                strDBConnection = "jdbc:mysql://" + strDBUrl;
                break;
            case "h2_Embedded":
                strDBConnection = "jdbc:h2:" + strDBUrl;
                break;
            case "h2_InMemory":
                strDBConnection = "jdbc:h2:mem:" + strDBUrl;
                break;
            case "h2_Server":
                strDBConnection = "jdbc:h2:tcp://" + strDBUrl;
                break;
            case "MSAccess":
                strDBConnection = "jdbc:ucanaccess://" + strDBUrl;
                break;
            default:
                break;
        }
    }

    public void Connect() throws SQLException {
        try {
            if (!Objects.equals(strDBConnection, "")) {
                conn = DriverManager.getConnection(strDBConnection, strDBUser, strDBPassword);
                System.out.println("Connection to " + strDBUrl + " Successful.");
            }
        }catch(SQLException e1){
                e1.printStackTrace();
            }
    }

    public ResultSet query(String strSQL) throws SQLException {
        try {
            // Create a result set containing all data from my_table
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(strSQL);
            // Fetch each row from the result set
            // db.Connect();
            // ResultSet rs = db.query("SELECT * FROM TEST");
            // while (rs.next()) {
            // // Get the data from the row using the column index
            // String s = rs.getString(1);
            // // Get the data from the row using the column name
            // s = rs.getString("col_string");
            // }
            // db.Disconnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean executeQuery(String strSQL) throws SQLException {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(strSQL);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public ResultSet selectAll(String strTable) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select * from " + strTable + ";";
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(strSQL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ResultSet selectAll(String strTable, String strField, String strTest) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select * from " + strTable;
            if(!strTest.equals("")){
                strSQL += " where " + strField + " " + strTest;
            }
            strSQL += ";";
            //System.out.println(strSQL);
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(strSQL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Integer countRows(String strTable, String strField) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select COUNT(" + strField + ") as Count from " + strTable + ";";
            //System.out.println(strSQL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strSQL);
            Integer intRows = 0;
            while (rs.next()) {
                intRows = rs.getInt("Count");
            }
            return intRows;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Integer getMax(String strTable, String strField) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select MAX(" + strField + ") as MAX from " + strTable + ";";
            //System.out.println(strSQL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strSQL);
            Integer intRows = 0;
            while (rs.next()) {
                intRows = rs.getInt("MAX");
            }
            return intRows;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Integer getMin(String strTable, String strField) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select MIN(" + strField + ") as MIN from " + strTable + ";";
            //System.out.println(strSQL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strSQL);
            Integer intRows = 0;
            while (rs.next()) {
                intRows = rs.getInt("MIN");
            }
            return intRows;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ResultSet selectField(String strTable, String strField) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select " + strField + " from " + strTable + ";";
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(strSQL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ResultSet selectField(String strTable, String strField, String strTestField, String strTest) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select " + strField + " from " + strTable;
            if(!strTestField.equals("")){
                strSQL += " where " + strTestField + " " + strTest;
            }
            strSQL += ";";
            //System.out.println(strSQL);
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(strSQL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Integer selectIntField(String strTable, String strField, String strTestField, String strTest) throws SQLException {
        try {
            // Create a result set containing all data from strTable
            String strSQL = "Select " + strField + " AS Field from " + strTable;
            if(!strTestField.equals("")){
                strSQL += " where " + strTestField + " " + strTest;
            }
            strSQL += ";";
            //System.out.println(strSQL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strSQL);
            Integer intRows = 0;
            while (rs.next()) {
                intRows = rs.getInt("Field");
            }
            return intRows;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean update(String strTable, String strField, String strValue, String strTestField, String strTest) throws SQLException {
        try {
            if(strTable != "" && strField != "" && strTestField != "") {
                // Create a result set containing all data from strTable
                String strSQL = "UPDATE " + strTable + " Set " + strField + "='" + strValue + "' WHERE " + strTestField + strTest + "; ";
                System.out.println(strSQL);
                executeQuery(strSQL);
                System.out.println("Updated `" + strField + "` to `" + strValue + "` Where `"  + strTestField + "` " + strTest);
                return true;
            }else{
                System.out.println("Failed to Update " + strField + " to "  + strValue + " Where " + strTest);
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(String strTable, String strTestField, String strTest) throws SQLException {
        try {
            if(strTable != "" && strTestField != "") {
                // Create a result set containing all data from strTable
                String strSQL = "DELETE FROM " + strTable + " WHERE " + strTestField + " " + strTest + "; ";
                executeQuery(strSQL);
                System.out.println("Deleted from " + strTable + " Where "  + strTestField + " " + strTest);
                return true;
            }else{
                System.out.println("Failed to Delete from " + strTable + " Where "  + strTestField + " " + strTest);
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean insert(String strTable, ArrayList<String> alFields, ArrayList<String> alValues) throws SQLException {
        try {
            if(alFields.size() == alValues.size()){
                // Create a result set containing all data from strTable
                String strSQL;
                strSQL = "INSERT INTO " + strTable + " (";
                for(String field : alFields){
                    if(alFields.indexOf(field) != alFields.size() - 1) {
                        strSQL += "`" + field + "`,";
                    }else{
                        strSQL += "`" + field + "`";
                    }
                }
                strSQL += ")";
                strSQL += " VALUES (";
                for(String value : alValues){
                    if(alValues.indexOf(value) != alValues.size() - 1) {
                        strSQL += "'" + value + "',";
                    }else{
                        strSQL += "'" + value + "'";
                    }

                }
                strSQL += ");";
                executeQuery(strSQL);
                System.out.println(strSQL);
                //System.out.println("Inserted ");
                //alValues.forEach(System.out::println);
                //System.out.println("Into " + strTable);
                //alFields.forEach(System.out::println);
                return true;
            }else{
                System.out.println("Field list and Value List Not Same Size");
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void Disconnect() throws SQLException {
        try
        {
            if(conn != null){
                conn.close();
            System.out.println("Connection to " + strDBUrl + " closed.");
            }
        }
        catch(SQLException e)
        {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    public static String SQLite(){ return "sqlite"; }

    public static String MySQL(){ return "mysql"; }

    public static String H2_Embedded(){
        return "h2_Embedded";
    }

    public static String H2_InMemory(){
        return "h2_InMemory";
    }

    public static String H2_Server(){
        return "h2_Server";
    }

    public static String MSAccess(){
        return "MSAccess";
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getStrDBUrl() {
        return strDBUrl;
    }

    public void setStrDBUrl(String strDBUrl) {
        this.strDBUrl = strDBUrl;
    }

    public String getStrDBConnection() {
        return strDBConnection;
    }

    public void setStrDBConnection(String strDBConnection) {
        this.strDBConnection = strDBConnection;
    }

    public String getStrDBType() {
        return strDBType;
    }

    public void setStrDBType(String strDBType) {
        this.strDBType = strDBType;
    }

    public String getStrDBUser() {
        return strDBUser;
    }

    public void setStrDBUser(String strDBUser) {
        this.strDBUser = strDBUser;
    }

    public String getStrDBPassword() {
        return strDBPassword;
    }

    public void setStrDBPassword(String strDBPassword) {
        this.strDBPassword = strDBPassword;
    }
}
