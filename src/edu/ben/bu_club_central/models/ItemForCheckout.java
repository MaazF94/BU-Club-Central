/**
 * 
 */
package edu.ben.bu_club_central.models;

public class ItemForCheckout {
	/**
	 * private Integer class variable
	 */
	private int itemID;

	/**
	 * private String class variable
	 */
	private String itemName;

	/**
	 * private Student object class variable
	 */
	private Student checkedoutBy;

	/**
	 * Constructor
	 * 
	 * @param itemID
	 *            Integer
	 * @param itemName
	 *            String
	 * @param checkedoutBy
	 *            Student object
	 */
	public ItemForCheckout(int itemID, String itemName, Student checkedoutBy) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.checkedoutBy = checkedoutBy;
	}
}
