package jade;

import clover.org.apache.commons.lang.ArrayUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Browser
{   
   public Browser(){
    }
    public String getForbiddenUrls (String[] forbiddenWords) 
    {
        
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    String allForbiddentUrls = "";

    if(ArrayUtils.isEmpty(forbiddenWords)){
        return "";
    }
    
    String yourChromePath = "C:/Users/Win/AppData/Local/Google/Chrome/User Data/Default/History";

    String query = generateSqlQuery(forbiddenWords);
    
    try 
        {
        Class.forName ("org.sqlite.JDBC");
        connection = DriverManager
            .getConnection ("jdbc:sqlite:"+yourChromePath);
        statement = connection.createStatement ();
        resultSet = statement
            .executeQuery (query);
        
        
        while (resultSet.next()) {
            String row = resultSet.getString("url");
            allForbiddentUrls += row+"; ";
            
        }
        
        } 

    catch (Exception e) 
        {
            System.out.println ("Chrome is turned on, we cant get history from it.");
            e.printStackTrace ();
        } 

    finally 
        {
        try 
            {
            resultSet.close ();
            statement.close ();
            connection.close ();
            } 

        catch (Exception e) 
            {
            System.out.println ("Database wasn't open, so it can't be closed.");
            e.printStackTrace ();
            }
        finally{
            return allForbiddentUrls;
        }

        }
    }
    public String generateSqlQuery(String[] wordsToCheck){
        //Create SQL Query with multiple LIKE 
        String baseQuery = 
                "SELECT url,  datetime((last_visit_time/1000000)-11644473600, 'unixepoch', 'localtime') "
                + "AS time FROM urls "
                + "WHERE cast(time as Date) = cast(date('now') as Date) AND (";

        for (int i = 0; i < wordsToCheck.length; i++) {
                 baseQuery+="url LIKE '%"+wordsToCheck[i]+"%' OR ";
            }
        baseQuery= baseQuery.substring(0, baseQuery.length()-3);;
        baseQuery+=")";
        return baseQuery;
    }
}