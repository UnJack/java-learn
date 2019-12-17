package mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * User: jianjie
 * Date: 16-6-12 下午3:53
 */
public class test_JDBC {
    public static final String url = "jdbc:mysql://127.0.0.1/test";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public test_JDBC(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
//            ResultSet rs=pst.executeQuery();
//            while(rs.next()){
//                String s=rs.getString("name");
//                System.out.println();
//            }
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        while (true)
//        System.out.println("insert into student values(null,'" + UUID.randomUUID() + "'," + new Random().nextInt(40) + "," + new Random().nextInt(40) + ",'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString() + "')");
        new test_JDBC("insert into student values(null,'" + UUID.randomUUID() + "'," + new Random().nextInt(40) + "," + new Random().nextInt(40) + ",'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString() + "')");
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
