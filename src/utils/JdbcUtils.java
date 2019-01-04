package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

    //获得c3p0连接池对象
    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return ds;
    }

    //获得数据库连接对象
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}