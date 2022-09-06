package com.di;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
// 상속은 재사용성에 대한 모법답안이 아니다 - 결합도가 높으니까
// 그런데 스프링은 결합도 낮추어야 하는 입장에 있다
// 프레임워크가 가져야 하는 사상에 위배된다.
// 그러면 이러한 내부적 결합을 어떻게 해결해볼까? - 문제, 고민 제기 + xml은 어려워


public class Pride2 extends MultiActionController {
	Logger logger = Logger.getLogger(Pride2.class);
	String carColor = null;
	int speed = 0;
	int wheelNum = 0;
	
	public Pride2() {
		logger.info("디폴트 생성자 호출 성공");
	}
}
