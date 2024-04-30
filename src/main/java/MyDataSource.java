import com.mysql.cj.jdbc.MysqlDataSource;
import oracle.jdbc.datasource.impl.OracleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyDataSource {

    public static DataSource getMySQLDataSource() {
        Properties properties=new Properties();
        MysqlDataSource ds = null;

        try(FileInputStream fis=new FileInputStream("db.properties")){
            properties.load(fis);

            ds = new MysqlDataSource();
            ds.setURL(properties.getProperty("MYSQL_DB_URL"));
            ds.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            ds.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));

        } catch (Exception e){
            e.printStackTrace();
        }
        return ds;
    }

    public static Connection conectarMySQL(){
        Connection con = null;
        try{
            DataSource ds = getMySQLDataSource();
            con = ds.getConnection();
            if(con != null)
                System.out.println("Conexión establecida.");
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static Connection conectarOracle(){
        Connection con = null;
        try{
            DataSource ds = getOracleDataSource();
            con = ds.getConnection();
            if(con != null)
                System.out.println("Conexión establecida.");
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static DataSource getOracleDataSource() {
        // Propiedades donde tenemos los datos de acceso a la BD
        Properties props = new Properties();
        // Objeto DataSource que devolveremos
        OracleDataSource oracleDS = null;
        try (FileInputStream fis = new FileInputStream("db.properties");) {
            // Cargamos las propiedades
            props.load(fis);
            // Generamos el DataSource con los datos URL, user y passwd necesarios
            oracleDS = new OracleDataSource();
            oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
            oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
            oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oracleDS;
    }

}
