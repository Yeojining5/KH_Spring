package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.logic.DeptLogic;
import com.example.demo.vo.DeptVO;
import com.google.gson.Gson;

// react와 연동하는 Controller는 @RestController 어노테이션을 사용한다.
@RestController

@RequestMapping("/dept/*")
public class RestDeptController {
   Logger logger = LogManager.getLogger(RestDeptController.class);
   
   @Autowired
   private DeptLogic deptLogic = null;
   
   @GetMapping("jsonDeptList")
   public String DeptList(Model model, @RequestParam Map<String, Object> pMap) {
      logger.info("deptList 호출 성공");
      List<Map<String, Object>> deptList = null;
      deptList = deptLogic.deptList(pMap);
      logger.info(deptList);
      String temp = null;
      Gson g = new Gson();
      temp = g.toJson(deptList);
      return temp;
   }
}