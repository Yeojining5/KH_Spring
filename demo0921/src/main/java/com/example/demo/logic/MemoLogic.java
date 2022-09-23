package com.example.demo.logic;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;

@Service
public class MemoLogic {
	Logger logger = LoggerFactory.getLogger(MemoLogic.class);
	
	@Autowired(required=false)
	private MemberDao memoDao = null;

	public int memoInsert(Map<String, Object> pMap) {
		logger.info("");
		int result = 0;
		//result = memoDao.memoinsert(pMap);
		return 0;
	}
}
