/**
 * 
 */
package edu.ben.bu_club_central.models;

/**
 * @author razak
 *
 */
public class ItemForCheckout {
	private int itemID;
	private String itemName;
	private Student checkedoutBy;
	
	public ItemForCheckout(int itemID, String itemName, Student checkedoutBy){
		this.itemID = itemID;
		this.itemName = itemName;
		this.checkedoutBy = checkedoutBy;
	}
}
