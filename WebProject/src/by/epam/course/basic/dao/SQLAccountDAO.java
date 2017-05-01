package by.epam.course.basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.epam.course.basic.beans.accounts.Account;
import by.epam.course.basic.beans.accounts.Electricity;
import by.epam.course.basic.beans.accounts.Water;
import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.interfaces.AccountDAO;

public class SQLAccountDAO implements AccountDAO{

	@Override
	public Account getAccountByUser(User user) throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		Electricity electricity= null;
		Water water= null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "SELECT [balance],[Account_ID] FROM [Web].[dbo].[ElectricityInfo] where Account_ID = ( SELECT [Account_ID] FROM [Web].[dbo].[Accounts] where User_ID = (SELECT TOP 1000 [User_ID] FROM [Web].[dbo].[Users] where FirstName = ? and LastName=? and Address=?))";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAddress());
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				if (account == null){
					account = new Account();
					electricity = new Electricity();
					water = new Water();
				}
				account.setAccount_ID(Integer.parseInt(rs.getString("Account_ID")));
				account.setUser(user);
				electricity.setAccount_ID(Integer.parseInt(rs.getString("Account_ID")));
				electricity.setBalanceWatt(Float.parseFloat(rs.getString("balance")));
				account.setElectricity(electricity);
				count++;
				if (count > 1) {
					throw new DAOException();
				}
			}
			
			count=0;
			sql = "SELECT [Balance_Cold_Water],[Balance_Hot_Water]  FROM [Web].[dbo].[WaterInfo] where Account_ID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, account.getAccount_ID());
	
			rs = ps.executeQuery();
			while (rs.next()) {
				if (account == null){
					throw new DAOException();
				}
				water.setAccount_ID(account.getAccount_ID());
				water.setBalanceColdWater(Float.parseFloat(rs.getString("Balance_Cold_Water")));
				water.setBalanceHotWater(Float.parseFloat(rs.getString("Balance_Hot_Water")));
				account.setWater(water);
				count++;
				if (count > 1) {
					throw new DAOException();
				}
			}
			return account;

		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException();
			}
		}
	}

	@Override
	public ArrayList<Account> getAllAccounts() throws DAOException {
		return null;
	}

}
