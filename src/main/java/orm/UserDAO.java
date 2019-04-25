package orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import program.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends BaseDaoImpl<User, String> {

    public UserDAO(ConnectionSource connection) throws SQLException {
        super(connection, User.class);
    }

    public List<User> searchByColumnName(String tableColumn, String search){
        QueryBuilder<User, String> qb = this.queryBuilder();
        List<User> UserList = null;

        try {
            UserList = qb.where().eq(tableColumn, search).query();
        } catch (SQLException se){
            System.out.println("Cannot search in sales data.");
        }

        return UserList;
    }

    public void getSailorCharactor(String username) {
        // QueryBuilder<User, String> qb = this.queryBuilder();
    }

}
