<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ</title>
	
</head>
<body>
<center>
	<% request.setCharacterEncoding("utf-8");%>
	
		<%if(request.getParameter("submit").equals("register")||request.getParameter("submit").equals("登録")|| request.getParameter("message") != null){ %>
			<h2 align="center">商品登録</h2>
			以下の商品を登録します。
			
			<form method="POST">
			<table>
				<tr>
					<td>ID:</td><td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>商品名:</td><td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>価格:</td><td><input type="text" name="price"></td><td>円</td>
				</tr>
			</table><br>
			<%System.out.println("check= "+ request.getParameter("check")); %>
			<%if(request.getParameter("check")!= null){ %>
				<font color="red">登録が完了しました</font>
			<% }%>
			<%if(request.getParameter("message") != null)
				{%>
				<font color="red"><%=request.getParameter("message") %></font>
			<% }%>
			<%if(request.getParameter("message2") != null)
				{%>
				<font color="red"><%=request.getParameter("message2") %></font>
			<% }%>
			<input type="hidden" name="mode" value="1">
			<input type="submit" name="submit" value="登録" formaction="/NockWeb/ControlServlet">
			
			</form>
			<button type="button" onclick="history.back()">戻る</button>
		<% }%>
		
		<%if(request.getParameter("submit").equals("変更")) { %>
			<h2 align="center">商品変更</h2>
			以下の商品を変更します。
			
			<form method="POST">
				<table>
					<tr>
						<td>ID:</td><td><%=request.getParameter("id") %></td>
					</tr>
					<tr>
						<td>商品名:</td><td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>価格:</td><td><input type="text" name="price"></td><td>円</td>
					</tr>
				</table><br>
				
				<%if(request.getAttribute("message") != null){%>
					<font color="red"><%=request.getAttribute("message") %></font><br>
				<% }%>
				<input type="hidden" name="id" value=<%=request.getParameter("id") %>>
				<input type="hidden" name="mode" value="2">
				<input type="submit" name="submit" value="変更" formaction="/NockWeb/ControlServlet">
			
			</form>
			<button type="button" onclick="history.back()">戻る</button>
		
		<% }%>
	
</center>
</body>
</html>