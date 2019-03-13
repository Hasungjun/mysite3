package com.example.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mysite.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> getList() {
		List<GalleryVo> list = sqlSession.selectList( "gallery.getList" );
		return list;
	}
	
	public void write(GalleryVo galleryVo) {
		sqlSession.insert("gallery.insert",galleryVo);
		
	}
	
	public void delete(Long no) {
		sqlSession.delete("gallery.delete",no);
	}

}
