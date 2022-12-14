<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 디클러레이션 - 클래스 선언, 메소드 선언
// text_jsp.java - 클래스이름 바뀐다.
// 프로젝트를 배포하는 서버마다 클래스이름의 명명규칙이 다르다?
// 우리가 인스턴스화 한다?? 난 코린인데!!
// 넌 인스턴스화 하지 말아라 = 메모리관리 책임은 스프링이 책임져줄게
// 자원관리를 프레임워크에게 맡긴다.
// 클래스이름은 누가 결정해야 할까? -> 업무구현할 개발자가 결정해야 함
// 제어역전(Ioc : Inversion of Controll) -> 경험이 많은 친구에게 맡기겠다
// 단독으로 인스턴스화가 불가능하다
		class Sonata {
	
		}
%>
<%
	Sonata myCar = new Sonata();
	out.print(myCar);
	// 웹서버(Web Application Server(동적페이지) <-> Web Server(정적페이지))
	// 유지! - scope(page|request|session|application)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- xml문법 : jsp-namespace
	프레임워크에 대한 환경설정은 xml로 처리한다(spring 2.5)
	myBatis와 Java의 연계
	myBatis와 Servlet의 연계 (연동)
	myBatis와 Spring의 연계 (연동)
	이종간에 연동(연계,결합,인터페이스)이 필요함
	인스턴스화 -> 객체주입! (클래스를 분할함 - 리액트가 이를 따름, 컴포넌트화)
	-> mybatis - 3.5.10.jar(클래스)
	xml끼리 (xml내부에서 클래스간의 객체 주입이 되어야 한다)
	
	useBean태그로 객체를 선언하는 것은 재사용이 어렵다.
	:test$Sonata.class 
	앞에 jsp의 이름에 대한 클래스 이름이 서버제품마다 다르다(명명규칙이 달라서)
	
	Spring 창시자
	클래스명은 개발자가 결정하는데 사용은 여러 개발자가 공유해야 함
	동시접속자도 많고 불특정 다수가 시도때도 없이 사용함
	자원관리를 시스템에서 맡아주는게 효과적이지 않나?
	그래서 제어역전을 가져왔다 -> Spring-core.jar
	-> ApplicationContext, BeanFactory 이 두 친구가 Bean을 관리한다
	대신, 클래스에 대한 등록은 개발자인 너가 해라 - 너는 업무 담당자이다.
	
	BeanFactory
		객체를 관리하는 고급설정 기법 제공
		org.springframework.beans 내에 속함
		모든 Bean을 늦게 로딩(Lazy loading)함
	
	ApplicationContext
		BeanFactory의 모든 기능을 제공함
		Spring의 AOP기능 제공
		메시지 지원 핸들링, 이벤트 위임
		org.springframework.context에 속함
		Context를 시작시킬 때 모든 SingleTon Bean을 미리 로딩함으로써
		그 Bean이 필요할 때 즉시 사용될 수 있도록 보장해줌
		애플리케이션 동작시 Bean이 생성되기를 기다릴 필요가 없게 됨
	
	 -->
	<jsp:useBean id="himCar" scope="request" class="com.di.Sonata"/>
</body>
</html>