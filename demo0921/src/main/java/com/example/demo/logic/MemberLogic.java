package com.example.demo.logic;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;

@Service
public class MemberLogic {
	Logger logger = LoggerFactory.getLogger(MemberLogic.class);
	
	@Autowired(required=false)
	private MemberDao memberDao = null;

	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출성공");
		int result = 0;
		result = memberDao.memberinsert(pMap);
		return result;
	}
	
	
}
