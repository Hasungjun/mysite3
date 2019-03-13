package com.example.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.mysite.service.FileuploadService;
import com.example.mysite.service.SiteService;
import com.example.mysite.vo.SiteVo;
import com.example.security.Auth;
import com.example.security.Auth.Role;

@Auth(Role.ADMIN)
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SiteService siteService;
	
	@Autowired
	private FileuploadService fileuploadService;

	@Auth(Role.ADMIN)
	@RequestMapping({ "", "/main" })
	public String main(Model model) {
		SiteVo siteVo = siteService.main();
		model.addAttribute("siteVo", siteVo);
		return "admin/main";
	}

	@Auth(Role.ADMIN)
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}

	@RequestMapping("/main/update")
	public String mainUpdate(@ModelAttribute SiteVo siteVo, @RequestParam(value="upload-profile") MultipartFile multipartFile) {
		String profile = fileuploadService.restore(multipartFile);
		siteVo.setProfilee(profile);
		
		siteService.updateMain(siteVo);
		
		return "redirect:/admin/main";
	}

}
