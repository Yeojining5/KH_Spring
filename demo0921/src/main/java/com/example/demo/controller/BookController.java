package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.logic.BookLogic;

@Controller
@RequestMapping("/book/*")
public class BookController {
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookLogic bookLogic = null;
	
	//@PostMapping("bookList") 
	//Post는 단위테스트가 불가하여 GET방식으로
	@GetMapping("bookList")
	public String bookList(Model model, @RequestParam Map<String,Object> pMap) {
		List<Map<String,Object>> bookList = null;
		bookList = bookLogic.bookList(pMap);
		model.addAttribute("bookList", bookList);
		
		return "forward:searchResult.jsp";
	}
}
