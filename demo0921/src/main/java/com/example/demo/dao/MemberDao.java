package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.logic.MemoLogic;
import com.example.demo.vo.MemberVO;

@Service
public class MemberDao {
	Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSessionTemplate = null;

	public int memberinsert(Map<String, Object> pMap) {
		logger.info("memberinsert 호출성공 ==> "+ pMap);//101
		int result = 0;
		try {
			sqlSessionTemplate.selectOne("proc_memberinsert", pMap);
			if(pMap.get("result")!=null) {
				result = Integer.parseInt(pMap.get("result").toString());				
			}
			// insert here
			logger.info("result : "+result);
		} catch (DataAccessException e) {
			logger.info("Exception : "+e.toString());
		} 
		return result;
	}

	public MemberVO login(Map<String, Object> pMap) {
		logger.info("login 호출성공");
		MemberVO mVO = null;
		mVO = sqlSessionTemplate.selectOne("login", pMap);
		
		return mVO;
	}

	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList 호출성공");
		List<Map<String, Object>> memberList = null;
		memberList = sqlSessionTemplate.selectList("memberList", pMap);
		return memberList;
	}

	
}
