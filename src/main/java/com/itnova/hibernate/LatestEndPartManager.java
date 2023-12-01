package com.itnova.hibernate;

public interface LatestEndPartManager {
	public Integer getSize();
	public void findAllEndPart();
	public void emptyTable();
	public Integer insertBulk(String inDate);
}
