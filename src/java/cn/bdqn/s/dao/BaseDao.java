package cn.bdqn.s.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by sunbin on 2017/6/16.
 */
public class BaseDao {



    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/malldb";
    public static final String username = "root";
    public static final String password = "root";

    public java.sql.Connection con;
    public java.sql.PreparedStatement ps;
    public ResultSet rs;

    static {
        try {

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public java.sql.Connection getConection() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(url, username, password);
        }
        System.out.println("con=" + con);
        return con;
    }

    public void closeResources() throws SQLException {
        rs.close();
        ps.close();
        con.close();
    }


    public int exeuteUpdate(String sql, Object... objs) throws SQLException {
        getConection();
        ps = con.prepareStatement(sql);

        for (int i = 0; i < objs.length; i++) {
            ps.setObject(i + 1, objs[i]);
        }
        int count = ps.executeUpdate();
        return count;
    }

    public ResultSet executeQuery(String sql, Object... objs)
            throws SQLException {
        getConection();
        ps = con.prepareStatement(sql);
        for (int i = 0; i < objs.length; i++) {
            ps.setObject(i + 1, objs[i]);
        }
        rs = ps.executeQuery();
        return rs;
    }

}
