package cn.zsza.jdbc;


import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 2015/5/22.
 */
public class TestJDBC {
    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    /**
     * 插入操作是在事务提交的时候，进行插库操作
     * @throws SQLException
     */
    @Test
    public void testInsert() throws SQLException {
        String sql = "INSERT INTO  tx_person (pname,age) VALUES (?,?)";

        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            st.setString(1, "小8");
            st.setInt(2,18);
            st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }
    @Test
    public void addBatch() throws SQLException {
        String sql = "INSERT INTO  tx_person2 (pname,age) VALUES (?,?)";
        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            for (int i = 1; i < 101; i++){
                st.setString(1, "a"+ i);
                st.setInt(2,(int)(Math.random()*50) + 50);
                st.addBatch();
                if(i % 10 == 0){
                    st.executeBatch();
                    conn.commit();
                    st.clearBatch();
                }
            }
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }
    /**
     * 查询操作，不等事务提交立即执行
     * @throws SQLException
     */
    @Test
    public void testSelectOneById() throws SQLException {
        String sql = "SELECT * FROM tx_person WHERE pid = ?";

        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            st.setInt(1,1);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                System.out.println("name=" +rs.getString(2));
            }

            ResultSet rs2 = st.executeQuery();
            if (rs2.next()){
                System.out.println("name=" +rs2.getString(2));
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }

    /**
     * 查询操作，不等事务提交立即执行
     * For Update：对当前事务添加共享锁
     * 其他事务可以查询、但不可以更新
     * @throws SQLException
     */
    @Test
    public void testSelectOneById2() throws SQLException {
        String sql = "SELECT * FROM tx_person WHERE pid = ? FOR UPDATE";

        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            st.setInt(1,1);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                System.out.println("name=" +rs.getString(2));
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }
    /**
     * 更新操作,也是在事务提交的时候进行的
     * MySQL对某条记录进行更新操作,当前事务正在更新，其他事务可以查询，但不可以更新
     * @throws SQLException
     */
    @Test
    public void updatetPerson() throws SQLException {
        String sql = "UPDATE tx_person SET pname = ? WHERE pid = ?";
        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement(sql);
            st.setString(1,"小111");
            st.setInt(2,1);
            st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }

    }
    /**
     * 查询行数
     * @throws SQLException
     */
    @Test
    public void count() throws SQLException {
        String sql = "select count(*) FROM tx_person";
        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement(sql);
            ResultSet res = st.executeQuery();
            if (res.next()){
                int count1 = res.getInt(1);
                System.out.println("count1:" + count1);
            }
            System.out.println("...........");
            ResultSet res2 = st.executeQuery();
            if (res2.next()){
                int count2 = res2.getInt(1);
                System.out.println("count2:" + count2);
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }
    }




}
