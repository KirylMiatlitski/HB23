package by.epam.course.basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.interfaces.UserDAO;

public class SQLUserDAO implements UserDAO {

	@Override
	public User signin(UserAuth user) throws DAOException {
		
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "SELECT [FirstName],[LastName],[Address] FROM [Web].[dbo].[Users] x where x.User_ID=(SELECT  [User_ID] FROM [Web].[dbo].[UsersAuth] t  where t.Login = ? and t.Password = ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			User resultUser = null;
			int count = 0;
			while (rs.next()) {
				if (resultUser == null){
					resultUser = new User();
				}
				resultUser.setFirstName(rs.getString("FirstName"));
				resultUser.setLastName(rs.getString("LastName"));
				resultUser.setAddress(rs.getString("Address"));
				count++;
				if (count > 1) {
					throw new DAOException();
				}
			}
			return resultUser;

		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
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
	public boolean registration(UserAuth user, User userData) throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int countRows = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			// switch off autocommit
			con.setAutoCommit(false);
			st = con.createStatement();
			String sql = "SELECT count([Login]) as 'CountRows' FROM [Web].[dbo].[UsersAuth] where Login = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getInt("CountRows") > 0) {
					// Error message
					con.rollback();
					return false;
				}
			}
			sql = "INSERT INTO [dbo].[UsersAuth] ([Login],[Password]) VALUES ( ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			countRows = ps.executeUpdate();
			if (countRows != 1) {
				// Error message
				con.rollback();
				return false;
			}
			
			sql = "INSERT INTO [dbo].[Users] ([User_ID],[FirstName],[LastName],[Address]) VALUES ((Select User_ID from [dbo].[UsersAuth] where Login = ?),?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, userData.getFirstName());
			ps.setString(3, userData.getLastName());
			ps.setString(4, userData.getAddress());
			countRows = ps.executeUpdate();
			if (countRows != 1) {
				// Error message
				con.rollback();
				return false;
			}

			sql = "INSERT INTO [dbo].[Accounts] ([User_ID]) VALUES ((Select User_ID from [dbo].[UsersAuth] where Login = ?))";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			countRows = ps.executeUpdate();
			if (countRows != 1) {
				// Error message
				con.rollback();
				return false;
			}
			
			sql = "INSERT INTO [Web].[dbo].[WaterInfo] ([Account_ID],[Balance_Cold_Water],[Balance_Hot_Water]) VALUES ((SELECT [Account_ID]  FROM [Web].[dbo].[Accounts] where User_ID = (Select User_ID from [Web].[dbo].[UsersAuth] where Login = ?)),?,?)";
			ps = con.prepareStatement(sql);
			Random rand = new Random();
			ps.setString(1, user.getLogin());
			ps.setString(2, ((Integer)rand.nextInt(10)).toString());
			ps.setString(3, ((Integer)rand.nextInt(10)).toString());
			countRows = ps.executeUpdate();
			if (countRows != 1) {
				// Error message
				con.rollback();
				return false;
			}
			
			
			sql = "INSERT INTO [Web].[dbo].[ElectricityInfo] ([Account_ID],[balance]) VALUES((SELECT [Account_ID]  FROM [Web].[dbo].[Accounts] where User_ID = (Select User_ID from [Web].[dbo].[UsersAuth] where Login = ?)),?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, ((Integer)rand.nextInt(10)).toString());
			countRows = ps.executeUpdate();
			if (countRows != 1) {
				// Error message
				con.rollback();
				return false;
			}
			con.commit();
			return true;
		} catch (ClassNotFoundException e) {

			throw new DAOException();
		} catch (SQLException e) {
			//System.out.println(e);
			throw new DAOException(e);
		} finally {
			try {

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
	public ArrayList<User> getAllUsers() throws DAOException {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectMSSQLServer.connectionString);
			st = con.createStatement();
			String sql = "SELECT [FirstName],[LastName],[Address] FROM [Web].[dbo].[Users]";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				User newUser = new User();
				newUser.setAddress(rs.getString("Address"));
				newUser.setFirstName(rs.getString("FirstName"));
				newUser.setLastName(rs.getString("LastName"));
				list.add(newUser);
			}
			return list;

		} catch (ClassNotFoundException e) {
			throw new DAOException();
		} catch (SQLException e) {
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

	

}
