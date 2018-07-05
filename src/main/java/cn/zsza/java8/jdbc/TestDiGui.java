package cn.zsza.java8.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangSong
 * @Date: 2018/6/14 11:00
 * @Company: NoNo
 */
public class TestDiGui {


    public static void main(String[] args) throws SQLException {
        getList(0);
    }

    public static List<Integer> getList(Integer parentId) throws SQLException {



        String sql = "SELECT id as sonId, parent_id " +
                "as parentId FROM class_f WHERE parent_id = ?";


        List<Integer> sonList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcTools.getConnection();
            conn.setAutoCommit(false);
            st  = conn.prepareStatement(sql);
            st.setInt(1,parentId);
            rs = st.executeQuery();
            while (rs.next()){
                sonList.add(rs.getInt(1));
            }
            if (sonList.size() > 0){

                sonList.stream().forEach(e -> {
                    try {
                        System.out.println("->" + e);
                        getList(e);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                });

            }else {
                System.out.println("-->" + parentId);
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JdbcTools.free(rs,st,conn);
        }


        List<Integer> list = new ArrayList<>();

        return list;
    }
}
