package com.eci.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eci.tka.entity.Candidate;



public class Dao {
	
	 List<Candidate>allcandidate=null;
	     String url="jdbc:mysql://localhost:3306/advjava193";
	     String uname="root";
	     String pwd="root";
	     Connection con=null;
	     Statement st=null;
	     ResultSet rs=null;
	     String sql="select * from advjava193.candidate";
	
	     public void candidateData() {
	   
	     }
         public List<Candidate>getAllCandidate(){
        	
        	 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				Connection con=DriverManager.getConnection(url, uname, pwd);
				
				  st = con.createStatement();
				
				  rs = st.executeQuery(sql);
				 
				  allcandidate=new ArrayList<Candidate>();
				 
				  while(rs.next()) {
					  int c_id = rs.getInt("c_id");
					  String cname = rs.getString("name");
					  String pname = rs.getString("partyname");
					  String stname = rs.getString("state");
					  String aname = rs.getString("assembly");
					  String gender = rs.getString("gender");
					  int age = rs.getInt("age");
					  
					  Candidate obj = new Candidate(c_id,cname,pname,stname,aname,gender,age);
					  allcandidate.add(obj);
				  }
        	 } catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
        	
			return allcandidate;
        	 
         }

         public boolean insertCandidate(int c_id, String cname, String pname, String stname, String aname, String gender, int age) {
            
             String sql = "INSERT INTO candidate (c_id, name, partyname, state, assembly, gender, age) VALUES (?, ?, ?, ?, ?, ?, ?)";
             
             
             try (Connection conn = DriverManager.getConnection(url,uname,pwd);   
                  PreparedStatement stmt = conn.prepareStatement(sql)) {

                 stmt.setInt(1, c_id);
                 stmt.setString(2, cname);
                 stmt.setString(3, pname);
                 stmt.setString(4, stname);
                 stmt.setString(5, aname);
                 stmt.setString(6, gender);
                 stmt.setInt(7, age);

                
                 int rows = stmt.executeUpdate();

                 return rows > 0; 
             } catch (Exception e) {
                
                 e.printStackTrace();
                 return false;
             }
         }
        	 
         
         public void updateCanName(int eid, String upname) {
        	 
         String sql="UPDATE candidate SET Name="+upname+"'where c_id="+upname;
           try {
			DriverManager.getConnection(sql, upname, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
         public String updateCandidateData(int prevcid, int newcid, String name, String party,String assembly,String state,String gender, int age) {

     		String result = null;

     		String sqlupdate = "UPDATE advjava193.candidate SET c_id = ?,name=?, partyname = ?, assembly=?,state=?,gender=?,age=? WHERE c_id=?; ";

     		try {
     			Connection conn = DriverManager.getConnection(url,uname,pwd);
     			PreparedStatement st = conn.prepareStatement(sqlupdate);
     			st.setInt(1, newcid);
     			st.setString(2, name);
     			st.setString(3, party);
     			st.setString(4, assembly);
     			st.setString(5, state);
     			st.setString(6, gender);
     			st.setInt(7, age);
     			st.setInt(8, prevcid);

     			int ex = st.executeUpdate();

     			if (ex > 0) {
     				result = "Candidate updated successfully";

     			}

     		} catch (SQLException e) {
     			e.printStackTrace();
     		}

     		return result;
     	}

     	
     	public String deleteCandata(int c_id) {
     		String result = null;
     		String sql = "DELETE FROM advjava193.candidate WHERE c_id=?";

     		try {
     			Connection conn = DriverManager.getConnection(url,uname,pwd);
     			PreparedStatement statement = conn.prepareStatement(sql);
     			statement.setInt(1, c_id);
     			int ex = statement.executeUpdate();

     			if (ex > 0) {
     				result = "Candidate deleted successfully";

     			} else {
     				result = "Candidate id not found";

     			}

     		} catch (Exception e) {
     			e.printStackTrace();
     		}
     		return result;

     	}

     }    


