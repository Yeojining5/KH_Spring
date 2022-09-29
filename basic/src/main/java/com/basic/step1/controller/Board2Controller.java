package com.basic.step1.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.basic.step1.logic.BoardLogic;
import com.google.gson.Gson;
import com.util.HangulConversion;
import com.util.HashMapBinder;

@Controller
@RequestMapping("/board2/*")
public class Board2Controller {
	private Logger logger = LoggerFactory.getLogger(BoardController.class)
			
	@Autowired
	private Board2Dao board2DAo = null;
	
	@GetMapping("selectBoard.sp4")
	public String selectBoard(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("selectBoard 호출 성공");
		Board board = null;
		board = board2Dao.boardDetail(pMap);
		model.addAttribute("board", board);
		String path = "";
		if(1==1) {
			path = "forward:boardDetail.jsp";
		} else {
			path = "redirect:error.do";
		}
		return "forward:boardDetail.jsp";
	}
	
	@GetMapping("error.sp4")
	public String error() {
		return "redirect:errorPage.jsp";
	}
}
