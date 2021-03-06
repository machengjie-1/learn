package com.machengjie.clonenote.controller;


import com.machengjie.clonenote.entity.User;
import com.machengjie.clonenote.service.PasswordException;
import com.machengjie.clonenote.service.PasswordFormatException;
import com.machengjie.clonenote.service.UserNameException;
import com.machengjie.clonenote.service.UserNameFormatException;
import com.machengjie.clonenote.service.UserNotFoundException;
import com.machengjie.clonenote.service.UserService;
import com.machengjie.clonenote.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 马成杰
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult login(String name, String password, HttpSession session){
		User user = userService.login(name,password);
		session.setAttribute("user",user);
		return new JsonResult(user);
	}

	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult regist(String name, String nick, String password, String confirm){
		User user = userService.regist(name, nick,password,confirm);
		return new JsonResult(user);
	}

	@RequestMapping("/heartbeat.do")
	@ResponseBody
	public JsonResult heart(){
		Object ok = "OK";
		return new JsonResult(ok);
	}


	@ExceptionHandler(UserNameFormatException.class)
	@ResponseBody
	public JsonResult handleUserNameFormat(UserNameFormatException e){
		e.printStackTrace();
		return new JsonResult(2,e);
	}
	@ExceptionHandler(PasswordFormatException.class)
	@ResponseBody
	public JsonResult handlePasswordFormat(PasswordFormatException e){
		e.printStackTrace();
		return new JsonResult(3,e);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public JsonResult handleUserNotFound(UserNotFoundException e){
		e.printStackTrace();
		return new JsonResult(4,e);
	}

	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult handlePassword(PasswordException e){
		e.printStackTrace();
		return new JsonResult(5,e);
	}

	@ExceptionHandler(UserNameException.class)
	@ResponseBody
	public JsonResult handleUserName(UserNameException e){
		e.printStackTrace();
		return new JsonResult(6,e);
	}


}
