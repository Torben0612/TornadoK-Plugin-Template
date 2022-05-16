package com.torben.template.commands;

import com.torben.template.utils.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLCommands {

    private Database database;

    public void sqlinsertcmd() throws SQLException {
        PreparedStatement ps = database.getConnection().prepareStatement("INSERRT INTO test_1 (C1,C2,C3) VALUE (?,?,?);");
        ps.setInt(1, 523);
        ps.setString(2, "meh");
        ps.setBoolean(4, true);
        ps.executeUpdate();
    }

    public void sqlupdatecmd() throws SQLException {
        PreparedStatement ps2 = database.getConnection().prepareStatement("UPDATE table SET column = ? WHERE column2 = ?;");
        ps2.setInt(1, 523);
        ps2.setString(2, "meh");
        ps2.executeUpdate();
    }

    public void sqlremovecmd() throws SQLException {
        PreparedStatement ps3 = database.getConnection().prepareStatement("DELETE FROM WHERE table WHERE column = ?;");
        ps3.setInt(1, 523);
        ps3.executeUpdate();
    }

    public void sqlselallcmd() throws SQLException {
        PreparedStatement ps4 = database.getConnection().prepareStatement("SELECT * FROM table WHERE column = ?;");
        ResultSet rs = ps4.executeQuery();
    }

    public void sqlselectcmd() throws SQLException {
        PreparedStatement ps5 = database.getConnection().prepareStatement("SELECT UUID FROM table WHERE column = ?;");
        ResultSet rs2 = ps5.executeQuery();
        while (rs2.next()) {

            System.out.println(rs2.getString("UUID"));
        }
    }
}
