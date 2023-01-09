package com.ali.repository.entity;

import static com.ali.utility.Utility.*;

public class BaseEntity {
	Long id;
	Long createDate;
	Long updateDate;
	boolean isactive;
	
	
	public BaseEntity(String className) {
		this.id = idOlustur(className);
		createDate = System.currentTimeMillis();
		updateDate = System.currentTimeMillis();
		this.isactive = true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	public Long getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Long updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
}