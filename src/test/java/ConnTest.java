/**
 * Created by 53097 on 2018/7/25.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConnTest {

    @Autowired
    private DataSource ds;

    @Test
    public void getConn() throws Exception{
        Connection conn = ds.getConnection();
        String sql = "select * from user_inf";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("loginname"));
        }
    }

}