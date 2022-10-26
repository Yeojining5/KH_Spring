package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.logic.BoardLogic;
import com.google.gson.Gson;
import com.util.HashMapBinder;


@RestController
@RequestMapping("/board/*")
public class RestBoardController {
	Logger logger = LogManager.getLogger(RestBoardController.class);
	   
	   @Autowired
	   private BoardLogic boardLogic = null;
	   
	   @GetMapping(value="jsonBoardList", produces="application/json;charset=UTF-8")
	   public String jsonBoardList(@RequestParam Map<String, Object> pMap) {
	      logger.info("jsonBoardList 호출 성공 ==>"+pMap);
	      List<Map<String, Object>> boardList = null;
	      boardList = boardLogic.boardList(pMap);
	      Gson g = new Gson();
	      String imsi = g.toJson(boardList);
	      return imsi;
	   }
	   
	   @PostMapping("rboardInsert")
	   public String boardInsert(MultipartHttpServletRequest mpRequest, @RequestParam(value="bs_file", required=false) MultipartFile bs_file) {
		int result = 0;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(mpRequest);
		hmb.mbind(pMap);
		logger.info("rboardInsert 호출 성공 ==> "+pMap);
		if(!bs_file.isEmpty()) {//
			String filename = bs_file.getOriginalFilename();
			logger.info("한글 처리 테스트 : "+filename);
			String savePath = "C:\\workspace_spring\\demo0921\\src\\main\\webapp\\pds";
			//파일에 대한 풀 네임 담기
			String fullPath = savePath+"\\"+filename;			
			try {
				//File객체는 파일명을 객체화 해줌
				File file = new File(fullPath);
				//board_sub_t에 파일크기를 담기 위해 계삭
				byte[] bytes = bs_file.getBytes();
				BufferedOutputStream bos =
						new BufferedOutputStream(
								new FileOutputStream(file));
				//실제로 파일 내용이 채워짐
				bos.write(bytes);
				bos.close();
				long size = file.length();
				double d_size = Math.floor(size/1024.0);//kb
				logger.info("size:"+d_size);
				pMap.put("bs_file", filename);
				pMap.put("bs_size", d_size);
				logger.info("파일 정보 : "+pMap.get("bs_file")+", "+pMap.get("bs_size"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		result = boardLogic.boardInsert(pMap);
		return String.valueOf(result);
		//return "redirect:http://localhost:3000/board";
	}	

}
