package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private String driver;
    private String dbURL;
    private String user;
    private String password;

    public DataSource() throws IOException {
        Properties props = new Properties();
        //apro il file properties creato per una gestione
        //più efficiente e aggiornabile del driver/url/username/password
        FileInputStream in = new FileInputStream("/Users/mauroficorella/Documents/University/Progetti universitari/Progetto FERSA ISPW 2018-2019/Progetto/ProgettoISPW2018/src/utilities/logging.properties");
        props.load(in);
        in.close();
        driver = props.getProperty("driver");
        dbURL = props.getProperty("url");
        user = props.getProperty("username");
        password = props.getProperty("password");
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(dbURL,user, password);
        return connection;
    }

}

