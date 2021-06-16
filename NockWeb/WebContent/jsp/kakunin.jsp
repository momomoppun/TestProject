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
	<%if(request.getParameter("submit").equals("登録")){ %>
		商品登録
		<h3>以下の商品を登録します。宜しいですか？</h3>
	<%} %>
	<%if(request.getParameter("submit").equals("変更")){ %>
		商品変更
		<h3>以下の商品を変更します。宜しいですか？</h3>
	<%} %>
	<%if(request.getParameter("submit").equals("削除")){ %>
		商品削除
		<h3>以下の商品を削除します。宜しいですか？</h3>
	<%} %>
	
	<table align="center">
		<tr>
			<td>ID:</td>	<td><%=request.getParameter("id") %></td>
		</tr>
		<tr>
			<td>商品名:</td><td><%=request.getParameter("name")%></td>
		</tr>
		<tr>
			<td>価格:</td>	<td><%=request.getParameter("price") %></td><td>円</td>
		</tr>
	</table>
	<div style="display:inline-flex">
	
		<%if(request.getParameter("submit").equals("登録")){ %>
			<form>
				<input type="hidden" name="mode" value="1">
				<input type="hidden" name="id" value=<%=request.getParameter("id")%>>
				<input type="hidden" name="name" value=<%=request.getParameter("name")%>>
				<input type="hidden" name="price" value=<%=request.getParameter("price")%>>
				<input type="submit" name="submit" value="登録" formmethod="POST" formaction="/NockWeb/ShohinServlet">
			</form>
		<%} %>
		<%if(request.getParameter("submit").equals("変更")){ %>
			<form>
				<input type="hidden" name="id" value=<%=request.getParameter("id")%>>
				<input type="hidden" name="name" value=<%=request.getParameter("name")%>>
				<input type="hidden" name="price" value=<%=request.getParameter("price")%>>
				<input type="hidden" name="mode" value="2">
				<input type="submit" name="submit" value="変更" formmethod="POST" formaction="/NockWeb/ShohinServlet">
			</form>
		<%} %>
		<%if(request.getParameter("submit").equals("削除")){ %>
			<form>
				<input type="hidden" name="mode" value=3>
				<input type="hidden" name="id" value=<%=request.getParameter("id")%>>
				<input type="hidden" name="name" value=<%=request.getParameter("name")%>>
				<input type="hidden" name="price" value=<%=request.getParameter("price")%>>
				<input type="submit" name="submit" value="削除" formmethod="POST" formaction="/NockWeb/ShohinServlet">
			</form>
		<%} %>
		
		<button type="button" onclick="history.back()">戻る</button>
	</div>
</center>
</body>
</html>