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
	private String checkedOutBy;
	
	/**
	 * check in time for item
	 */
	private String checkInTime;
	/**
	 * check out time for item
	 */
	private String checkOutTime;
	
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
	public ItemForCheckout(int itemID, String itemName, String checkedOutBy) {
		this.setItemID(itemID);
		this.setItemName(itemName);
		this.setCheckedOutBy(checkedOutBy);
	}
	public ItemForCheckout(int itemID, String itemName, String checkedOutBy, String checkOutTime){
		this.setItemID(itemID);
		this.setItemName(itemName);
		this.setCheckedOutBy(checkedOutBy);
		this.setCheckOutTime(checkOutTime);
	}
	public ItemForCheckout(int itemID, String itemName, String checkedOutBy, String checkOutTime, String checkInTime){
		this.setItemID(itemID);
		this.setItemName(itemName);
		this.setCheckedOutBy(checkedOutBy);
		this.setCheckOutTime(checkOutTime);
		this.setCheckInTime(checkInTime);
	}
	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the checkedOutBy
	 */
	public String getCheckedOutBy() {
		return checkedOutBy;
	}
	/**
	 * @param checkedOutBy the checkedOutBy to set
	 */
	public void setCheckedOutBy(String checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}
	/**
	 * @return the checkInTime
	 */
	public String getCheckInTime() {
		return checkInTime;
	}
	/**
	 * @param checkInTime the checkInTime to set
	 */
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	/**
	 * @return the checkOutTime
	 */
	public String getCheckOutTime() {
		return checkOutTime;
	}
	/**
	 * @param checkOutTime the checkOutTime to set
	 */
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
}
