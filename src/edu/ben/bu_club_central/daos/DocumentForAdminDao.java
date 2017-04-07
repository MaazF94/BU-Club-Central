package edu.ben.bu_club_central.daos;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Document;
import edu.ben.bu_club_central.models.DocumentForAdmin;

public class DocumentForAdminDao {
	
	/**
	 * Establishes the name of the table being used
	 */
	private String tableName = "bu_club_central.document_for_admin";

	/**
	 * intialized clubMembership object
	 */
	private DocumentForAdmin documentForAdminObject;

	/**
	 * intializes connection to database
	 */
	private DatabaseConnection dbc = new DatabaseConnection();
	/**
	 * connects to the database
	 */
	private Connection conn = dbc.getConn();
	
	public LinkedList<DocumentForAdmin> displayDocumentForAdminInfo() throws IOException {
		String sql = "";
		LinkedList<DocumentForAdmin> DocumentForAdminList = new LinkedList<DocumentForAdmin>();
		
		sql = "SELECT * from " + tableName;
		
		PreparedStatement ps;
		ResultSet rs = null;;
		DocumentForAdmin newDocumentForAdmin;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				newDocumentForAdmin = new DocumentForAdmin(rs.getString("name"), rs.getInt("from_id_num"), (char) rs.getBlob("file").getBinaryStream().read(), rs.getBoolean("accept_deny"), rs.getBoolean("active"));
				DocumentForAdminList.add(newDocumentForAdmin);
			}
			
//			InputStream input = ((Part) rs.getBlob("file")).getInputStream();
//			ByteArrayOutputStream output = new ByteArrayOutputStream();
//			byte[] buffer = new byte[10240];
//			for (int length = 0; (length = input.read(buffer)) > 0;)
//				output.write(buffer, 0, length);
//			rs.setBlob(output.toByteArray());		
			} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		return DocumentForAdminList;
	}
	
	public boolean addDocument(String name, int user_id_num, InputStream inputStream, boolean active) throws IOException {
		String sql = "";
		
		sql = "INSERT INTO document_for_admin (name, from_id_num, file, active) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, user_id_num);
			ps.setBinaryStream(3, inputStream, inputStream.available());
			ps.setBoolean(4, active);
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		
		return false;
	}

}
