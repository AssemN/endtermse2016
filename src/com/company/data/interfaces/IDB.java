package com.company.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
