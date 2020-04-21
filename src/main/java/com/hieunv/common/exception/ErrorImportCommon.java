package com.hieunv.common.exception;

import java.io.Serializable;

/**
 * @author SyNT
 * @CreatedDate Dec 14, 2017 11:57:03 AM
 */
public class ErrorImportCommon implements Serializable {

	private static final long serialVersionUID = 1L;

	private int row;
	private int cell;
	private String valueInvalid;
	private String field;

	public ErrorImportCommon(int row, int cell, String valueInvalid, String field) {
		super();
		this.row = row;
		this.cell = cell;
		this.valueInvalid = valueInvalid;
		this.field = field;
	}

	public ErrorImportCommon() {
		super();
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the cell
	 */
	public int getCell() {
		return cell;
	}

	/**
	 * @param cell
	 *            the cell to set
	 */
	public void setCell(int cell) {
		this.cell = cell;
	}

	/**
	 * @return the valueInvalid
	 */
	public String getValueInvalid() {
		return valueInvalid;
	}

	/**
	 * @param valueInvalid
	 *            the valueInvalid to set
	 */
	public void setValueInvalid(String valueInvalid) {
		this.valueInvalid = valueInvalid;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

}
