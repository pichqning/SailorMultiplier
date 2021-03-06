package orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import program.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAO extends BaseDaoImpl<User, String> {

    public UserDAO(ConnectionSource connection) throws SQLException {
        super(connection, User.class);
    }

    public List<User> getColumnListByKey(String tableColumn, String search){
        QueryBuilder<User, String> qb = this.queryBuilder();
        List<User> userList = null;

        try {
            userList = qb.where().eq(tableColumn, search).query();
        } catch (SQLException se){
            System.out.println("Cannot search in users table.");
        }

        return userList;
    }


    public List<User> getColumnList(String col) {
        QueryBuilder<User, String> qb = this.queryBuilder();
        List<User> userList = null;

        try {
            userList = qb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User getUserFromUsername(String search) {
        QueryBuilder<User, String> qb = this.queryBuilder();
        List<User> userList = null;
        User user = null;
        try {
            userList = qb.query();
            for(User u: userList) {
                if(u.getUsername().equals(search)) user = u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void createUser(String username, String sailor) {
        try {
            this.create(new User(username, sailor));
        } catch (SQLException e) {
            System.out.println("Cannot create user");
        }

    }

    public void deleteUser(String username) {
        try {
            this.delete(getUserFromUsername(username));
        } catch (SQLException e) {
            System.out.println("Cannot create user");
        }
    }

}
