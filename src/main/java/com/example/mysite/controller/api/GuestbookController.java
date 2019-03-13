package com.example.mysite.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.JSONResult;
import com.example.mysite.service.GuestbookService;
import com.example.mysite.vo.GuestbookVo;

@Controller("guestbookApiController")
@RequestMapping("/guestbook/api")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping("/list")
	public JSONResult index(@RequestParam( value="sno", required=true, defaultValue="0") Long page) {
		List<GuestbookVo> list = guestbookService.getMessageList(page);
		System.out.println(list);
		
		if(list == null) {
		return JSONResult.fail("fail");
		}
		else {
			return JSONResult.success(list);
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public JSONResult delete(@RequestParam( value="no", required=true) Long no , @RequestParam( value="password", required=true, defaultValue="0") String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		boolean result = guestbookService.deleteMessage(vo);
		
		if(result == false) {
		return JSONResult.fail("fail");
		}
		else {
			return JSONResult.success(no);
		}
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public JSONResult add(@RequestParam( value="name", required=true) String name,@RequestParam( value="password", required=true) String password, @RequestParam( value="message", required=true) String message ){
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		boolean result = guestbookService.writeMessage(vo);
		
		if(result == false) {
		return JSONResult.fail("fail");
		}
		else {
			return JSONResult.success(vo);
		}
	}
	

}
