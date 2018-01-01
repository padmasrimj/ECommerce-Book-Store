package com.java.Service;

import com.java.Bean.BidingDetailsBean;

public interface BidService {
	public void createAndStoreBids(BidingDetailsBean bidBean);
	public BidingDetailsBean getBidDetailsById(int bidId);
		
}
