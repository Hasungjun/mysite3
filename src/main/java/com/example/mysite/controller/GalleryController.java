package com.example.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.mysite.service.FileuploadService;
import com.example.mysite.service.GalleryService;
import com.example.mysite.vo.GalleryVo;
import com.example.mysite.vo.SiteVo;
import com.example.security.Auth;
import com.example.security.Auth.Role;


@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping("")
	public String index(Model model) {
		List list = galleryService.getGalleryList();
		if(list == null)
			return "redirect:/gallery";
		
		model.addAttribute("list",list);
		
		return "gallery/index";
	}
	
	@Auth(Role.ADMIN)
	@RequestMapping("/upload")
	public String upload(@ModelAttribute GalleryVo galleryVo, @RequestParam(value="file") MultipartFile multipartFile) {
		String image_url = fileuploadService.restore(multipartFile);
		galleryVo.setImage_url(image_url);
		
		galleryService.write(galleryVo);

		return "redirect:/gallery";
	}
	
	@Auth(Role.ADMIN)
	@RequestMapping("/delete/{no}")
	public String delete( @PathVariable( "no" ) Long no){
		galleryService.delete(no);
		return "redirect:/gallery";
	}
}
