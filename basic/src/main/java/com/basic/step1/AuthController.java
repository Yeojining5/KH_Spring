package com.basic.step1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.vo.MemberVO;

public class AuthController {
	@Autowired
	private AuthLogic authLogic = null;
	//setter객체 주입법 코드이다.
	//인스턴스화 대신 이다. authLogic = new AuthLogic()
	//어라 코드가 더 긴데요? 이러면 뭐가 좋은거죠??? - ApplicationContext가 관리해줘요
	//ApplicationContext가 객체(AuthLogic)를 메모리에 올려줘요
	public void AuthLogic(AuthLogic authLogic) {
		this.authLogic = authLogic;
	}
	public String login(HttpServletRequest req, HttpServletResponse res) {
		//logger.info("dev_spring4 login 호출 성공");
		System.out.println("dev_spring4 login 호출 성공");
		String path = "redirect:index.jsp";
		MemberVO memVO = null;
		//아래 코드는 NullPointerException이 발생한다|안한다
		//15번 라인에 선언된 객체는 아래코드에서 사용된다.
		//그러니까 여기서 인스턴스화를 하면 게으른 인스턴스화 라고 함
		memVO = authLogic.login();
		HttpSession session = req.getSession();
		session.setAttribute("memVO", memVO);
		return path;
	}
}