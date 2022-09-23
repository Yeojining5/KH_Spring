<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<%@ include file="../common/easyui_common.jsp" %>
</head>
<body>
	<div>
		<label for="dong">동이름 입력</label>
		<input id="dong" name="dong" class="easyui-textbox" style="width:300px"/>
		<a href="javascript:zipcodeSearch()" class="easyui-linkbutton">
			검색
		</a>
		<div id="d_zipcode"></div> <!-- 여기에 동이름 검색결과 출력 -->
	</div>

</body>
</html>