package edu.ben.bu_club_central.daos;

import java.io.File;
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
	
	public LinkedList<DocumentForAdmin> displayDocumentForAdminInfo() {
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
				newDocumentForAdmin = new DocumentForAdmin(rs.getString("name"), rs.getInt("from_id_num"), (File) rs.getBlob("file"), rs.getBoolean("accept_deny"), rs.getBoolean("active"));
				DocumentForAdminList.add(newDocumentForAdmin);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return DocumentForAdminList;
	}

}
