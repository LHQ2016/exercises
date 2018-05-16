package mysql;

import java.sql.*;

public class MysqlDemo {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=true";

    //数据库用户名和密码
    static final String USER = "root";
    static final String PASS = ".Lhq137511";


    public static void main(String[] args) {

        Connection conn = null;
        Statement state = null;

        try {
            //加载类驱动
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            state = conn.createStatement();

            String sql = "SELECT * FROM websites";

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                System.out.print("ID:" + id);
                System.out.print(",\t\t站点名称：" + name);
                System.out.print(",\t\t站点URL：" + url);
                System.out.println();
            }

            if (rs != null) rs.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (state != null) state.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("GoodBye!");
    }
}
