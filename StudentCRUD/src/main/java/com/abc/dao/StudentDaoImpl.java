package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.dto.Student;
import com.abc.factory.ConnectionFactory;


public  class StudentDaoImpl implements StudentDao {
	String status="";
	@Override
	public String save(Student student) {
    try {
	Connection connection = ConnectionFactory.getConnectionToDB();
	String sqlSelectQuery="select * from `student` where `sid`=?";
	PreparedStatement prepareStatement=null;
	prepareStatement = connection.prepareStatement(sqlSelectQuery);
	prepareStatement.setString(1,student.getSid());  
	ResultSet resultSet = prepareStatement.executeQuery();
		    
	 if(resultSet.next()==true) {
	 status="already Existed";
	 }else {
	 String sqlInsertQuery="insert into `student`(`sid`,`sname`,`sage`,`saddress`)values(?,?,?,?) ";	
	 prepareStatement= connection.prepareStatement(sqlInsertQuery) ;  
	 prepareStatement.setString(1,student.getSid());
	 prepareStatement.setString(2, student.getSname());
	 prepareStatement.setString(3, student.getSage());
	 prepareStatement.setString(4, student.getSaddress());
	 int rowCount = prepareStatement.executeUpdate();
	 if(rowCount==1) {
		 status="success";
	 }else {
		 status="failure";
	 }
	 
        }
		    } catch (SQLException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}
	

	@Override
	public Student findById(String sid) {
		Student student=null;
		try {
			Connection connection = ConnectionFactory.getConnectionToDB();
			String sqlSelectQuery="select * from `student` where `sid`=?";
			PreparedStatement prepareStatement=null;
			prepareStatement = connection.prepareStatement(sqlSelectQuery);
			prepareStatement.setString(1,sid);
			ResultSet resultSet = prepareStatement.executeQuery();
				    
			 if(resultSet.next()==true) {
			  student = new Student();
			  student.setSid(resultSet.getString("sid"));
			  student.setSname(resultSet.getString("sname"));
			  student.setSage(resultSet.getString("sage"));
			  student.setSaddress(resultSet.getString("saddress"));
			 }else {
				 student=null;
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return student;
	}


	@Override
	public String deleteById(String sid) {
		String status="";
		PreparedStatement prepareStatement=null;
		try {
			Connection connection = ConnectionFactory.getConnectionToDB();
			String sqlSelectQuery="select * from `student` where `sid`=?";
			prepareStatement = connection.prepareStatement(sqlSelectQuery);
			prepareStatement.setString(1,sid);  
			ResultSet resultSet = prepareStatement.executeQuery();
				    
		 if(resultSet.next()==true) {
			String sqlDeleteQuery="delete from `student` where `sid`=?";
			 prepareStatement= connection.prepareStatement(sqlDeleteQuery);
			 prepareStatement.setString(1, sid);
			 int rowCount = prepareStatement.executeUpdate();
			 if(rowCount==1) {
				 status="success";
			 }else {
				 status="failure";
			 }
			 
			  }else {
				 status="notexisted";
			     }
				    } catch (SQLException e) {
					e.printStackTrace();
					status="failure";
				}
		return status;
	}


	@Override
	public String update(Student student) {
		String status="";
		try {
			Connection connection = ConnectionFactory.getConnectionToDB();
			String sqlUpdateQuery = "update `student` set `sname`=?,`sage`=?,`saddress`=? where `sid`=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sqlUpdateQuery);
			prepareStatement.setString(1, student.getSname());
			prepareStatement.setString(2, student.getSage());
			prepareStatement.setString(3, student.getSaddress());
			prepareStatement.setString(4, student.getSid());

			int rowCount = prepareStatement.executeUpdate();
			if (rowCount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
         	} catch (Exception e) {
			e.printStackTrace();
         		status = "failure";
         				}
		
	         return status;
	}
}
