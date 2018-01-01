package com.java.Dao;

import com.java.Bean.BidingDetailsBean;

public interface BidDao {

	public void addBid(BidingDetailsBean bidBean);
	public BidingDetailsBean getBidDetailsById(int bidId);
}
