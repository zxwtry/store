package edu.zxw.grid.web.form;

import java.io.Serializable;

/*
 * 	VO值对象，对应页面表单的属性值
 * 	为什么要分PO和VO?
 * 	1,	相同点：都是JavaBean
 * 	2,	不同点：	PO对象中的属性关联数据库字段，一般不能直接修改
 * 				VO对象中的属性可以随意增加PO对象中的属性、修改、删除，对应页面表单属性
 * 				(不要把持久层对象放到页面上)
 */

@SuppressWarnings("serial")
public class GridTextForm implements Serializable{
	private String textID;
	private String textName;
	private String textDate;
	private String textRemark;
	public String getTextID() {
		return textID;
	}
	public void setTextID(String textID) {
		this.textID = textID;
	}
	public String getTextName() {
		return textName;
	}
	public void setTextName(String textName) {
		this.textName = textName;
	}
	public String getTextDate() {
		return textDate;
	}
	public void setTextDate(String textDate) {
		this.textDate = textDate;
	}
	public String getTextRemark() {
		return textRemark;
	}
	public void setTextRemark(String textRemark) {
		this.textRemark = textRemark;
	}
}
