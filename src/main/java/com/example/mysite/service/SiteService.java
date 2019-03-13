package com.example.mysite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysite.repository.SiteDao;
import com.example.mysite.vo.SiteVo;

@Service
public class SiteService {
	
	@Autowired
	private SiteDao siteDao ;
	
	public boolean updateMain(SiteVo siteVo) {
		
		return siteDao.update(siteVo) == 1;
	}
	
	public SiteVo main() {
		return siteDao.getmain();
	}
	
	

}
