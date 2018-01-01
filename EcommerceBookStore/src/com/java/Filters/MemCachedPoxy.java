package com.java.Filters;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import org.apache.log4j.Logger;

public class MemCachedPoxy {
	private Logger s_Logger = Logger.getLogger(MemCachedPoxy.class);
	private MemcachedClient m_Client;
	
	public void start( String[] ips ) throws IOException{
		StringBuffer buffer = new StringBuffer();
		for( String ip : ips){
			buffer.append(ip).append(" ");
		}
		m_Client = new MemcachedClient(AddrUtil.getAddresses(buffer.toString()));
	}
	
	public void stop(){
		this.m_Client.shutdown();
	}
	
	public void syncSetAndGet( String k, Object v, int ttl) throws Exception{
		m_Client.set(k, 3600, v);
		Object myObject= m_Client.get(k);
		s_Logger.info(myObject);
	}
	
	public void AsyncSetAndGet( String k, Object v, int ttl) throws InterruptedException, ExecutionException{
		m_Client.set(k, ttl, v);
		Object myObj=null;
		Future<Object> f = m_Client.asyncGet(k);
		try {
		    myObj=f.get(5, TimeUnit.SECONDS);
		    s_Logger.info(myObj);
		} 
		catch(TimeoutException e) {
		    f.cancel(false);
		}		
	}
}
