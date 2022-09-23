package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.logic.CommonLogic;
import com.google.gson.Gson;

@Controller
// @RequestMapping 은 사용 안했음. 계속 주소가 바뀔 수 있기 때문에...(?)
public class CommonController {
	Logger logger = LogManager.getLogger(CommonController.class);
	
	@Autowired(required=true)
	private CommonLogic commonLogic = null;
	
	@GetMapping("/zipcode/zipcodeList")
	public String zipcodeList(@RequestParam String dong, Model model) {
		logger.info("zipcodeList호출 성공 : input ==> "+dong );
		List<Map<String,Object>> zipList = null;
		zipList = commonLogic.zipcodeList(dong);
		model.addAttribute("zipList", zipList);

		return "forward:/auth/zipcodeList.jsp";
	}
	
	@ResponseBody
	@GetMapping("/zipcode/jsonZipcodeList")
	public String jsonZipcodeList(@RequestParam String dong) {
		logger.info("zipcodeList호출 성공 : input ==> "+dong );
		List<Map<String,Object>> zipList = null;
		zipList = commonLogic.zipcodeList(dong);
		Gson g = new Gson();
		String imsi = g.toJson(zipList);
		
		return imsi;
	}
	
}
