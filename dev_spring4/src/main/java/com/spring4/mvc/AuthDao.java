package com.spring4.mvc;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.MemberVO;
// DAO뒤에서는 오라클서버와 연동하기
// myBatis 레이어대한 설정 필요함.
public class AuthDao {
	Logger logger = Logger.getLogger(AuthDao.class);
	// SqlSessionTemplate는 mybatis-spring.jar에서 제공하는 클래스로,
	// SqlSession의 역할임
	/*
	 * 
	 * <bean id="auth-dao" class="com.spring4.mvc.AuthDao">
	 * 	<property name="sqlSessionTemplate" ref="sqlSessionTemplate"/>
	 * </bean>
	 * 
	 */
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public MemberVO login() {
		logger.info("login 호출 성공");
		MemberVO memVO = null;
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("mem_id", "test");
		pMap.put("mem_pw", "123");
		memVO = sqlSessionTemplate.selectOne("login", pMap);
		
		if(memVO!=null ) {
			logger.info(memVO.getMem_name());
		}
		return memVO;
	}
}
