package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.logic.MemoLogic;
import com.google.gson.Gson;

@Controller
@RequestMapping("/memo/*")
public class MemoController {
Logger logger = LoggerFactory.getLogger(MemoController.class);
	
	@Autowired(required=false)
	private MemoLogic memoLogic = null;
	
	
	@GetMapping("memoContent")
	public String memoContent(Model model, @RequestParam Map<String,Object> pMap) {
		Map<String,Object> rMap = null;
		rMap = memoLogic.memoContent(pMap);
		model.addAttribute("rMap", rMap);
		//@RestController, @ResponseBody
		return "forward:/memo/memoContent.jsp";
	}
	
	@GetMapping("memoInsert")
	public String memoInsert(@RequestParam Map<String,Object> pMap) {
		logger.info("memoInsert 호출성공 : "+pMap);
		int result = 0;
		result = memoLogic.memoInsert(pMap);
		return "redirect:/auth/index.jsp";
	}
	
	@GetMapping("sendMemoList")
	public String sendMemoList(Model model, @RequestParam Map<String,Object> pMap) {
		logger.info("sendMemoList 호출성공 : "+pMap);
		List<Map<String,Object>> sendMemoList = null;
		sendMemoList = memoLogic.sendMemoList(pMap);
		model.addAttribute("sendMemoList", sendMemoList);
		//@RestController, @ResponseBody
		return "forward:/memo/jsonSendMemoList.jsp";
	}
	@GetMapping("receiveMemoList")
	public String receiveMemoList(HttpSession session, Model model, @RequestParam Map<String,Object> pMap) {
		logger.info("receiveMemoList 호출성공 : "+pMap);
		List<Map<String,Object>> receiveMemoList = null;
		receiveMemoList = memoLogic.receiveMemoList(pMap, session);
		model.addAttribute("receiveMemoList", receiveMemoList);
		return "forward:/memo/jsonReceiveMemoList.jsp";
	}
}
