package courseworkjava;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BookManageDashTest {
    @Test
    void insert_Test() {
        ConnectionC db = new ConnectionC();
        String query = "insert into signup values('"+"a"+"','"+"a"+"','"+"a"+"','"+"a"+"')";
        int result= 0;
        try {
            result = db.connection().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(1, result);
    }
    @Test
    void insert_Test2() {
        ConnectionC db = new ConnectionC();
        String query = "insert into signup values('"+"a"+"','"+"a"+"','"+"a"+"','"+"a"+"')";
        int result= 0;
        try {
            result = db.connection().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(1, result);
    }
    @Test
    void select_Test3() {
        ConnectionC db = new ConnectionC();
        String query = "select * from signup where user='"+"a"+"' ";
        int result= 1;
        try {
            ResultSet result1=  db.connection().executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(1, result);
    }
    @Test
    void select_Test4() {
        ConnectionC db = new ConnectionC();
        String query = "select * from signup where user='"+"c"+"' ";
        int result= 1;
        try {
            ResultSet result1=  db.connection().executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(1, result);
    }
    @Test
    void select_Test5() {
        ConnectionC db = new ConnectionC();
        String query = "select * from signup where user='"+"g"+"' ";
        int result= 1;
        try {
            ResultSet result1=  db.connection().executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(1, result);
    }




}