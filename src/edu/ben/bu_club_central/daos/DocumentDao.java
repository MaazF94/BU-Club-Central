package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.ClubMembership;
import edu.ben.bu_club_central.models.Document;

public class DocumentDao {

	/**
	 * Establishes the name of the table being used
	 */
	private String tableName = "bu_club_central.document";

	/**
	 * intialized clubMembership object
	 */
	private Document documentObject;

	/**
	 * intializes connection to database
	 */
	private DatabaseConnection dbc;
	/**
	 * connects to the database
	 */
	private Connection conn;

	public LinkedList<Document> displayDocumentInfo() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "";
		LinkedList<Document> DocumentList = new LinkedList<Document>();

		sql = "SELECT * from " + tableName;

		PreparedStatement ps;
		ResultSet rs = null;
		;
		Document newDocument;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				newDocument = new Document(rs.getString("name"), rs.getString("description"),
						rs.getString("file_path"));
				DocumentList.add(newDocument);

			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return DocumentList;
	}

}
