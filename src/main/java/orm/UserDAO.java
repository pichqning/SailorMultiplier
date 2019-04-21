package orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import program.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO extends BaseDaoImpl<User, String> {

    public UserDAO(ConnectionSource connection) throws SQLException {
        super(connection, User.class);
    }


}
