<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./study_paramProcess.jsp" method="post">
		<div>
		<!-- readonly 읽기 전용 수정 불가 Parameter 전송 -->
		<!-- disabled 읽기 전용 수정 불가 Parameter 전송 불가 -->
			<input type="text" name="p1" value="p1 data" disabled>	
		</div>
			<input type="hidden" value="hidden data" name="p2">
		<div>
			남<input type="radio" value="m" name="p3">
			여<input type="radio" value="f" name="p3" checked>
		</div>
		
		<div>
			<select name="p4">
				<option value="KT">KT</option>
				<option value="LGT">LGT</option>
				<option value="SKT" selected>SKT</option>
			</select>
		</div>
		
		<div>
			야구<input type="checkbox" value="야구" name="p5">
			축구<input type="checkbox" value="축구" name="p5">
			농구<input type="checkbox" value="농구" name="p5">
			배구<input type="checkbox" value="배구" name="p5">
		</div>
		
		<button type="submit">SUBMIT</button>
		</form>
</body>
</html>