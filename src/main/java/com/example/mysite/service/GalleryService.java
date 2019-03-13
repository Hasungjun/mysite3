package com.example.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysite.repository.GalleryDao;
import com.example.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	public List<GalleryVo> getGalleryList(){
		
		return galleryDao.getList();
	}
	
	public void write(GalleryVo galleryVo) {
		galleryDao.write(galleryVo);
	}
	
	public void delete(Long no) {
		galleryDao.delete(no);
	}

}
