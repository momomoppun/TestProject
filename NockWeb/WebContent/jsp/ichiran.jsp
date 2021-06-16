<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="bean.ShohinBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getAttribute("no").equals(1)){ %>
		<p align="center">
		<h1 align="center">商品一覧</h1>
		<table border="1" align="center">
			<tr>
				<th>ID</th><th>商品名</th><th>価格</th>
			</tr>
			<tr>
				<td>00001</td><td>りんご</td><td>100円</td>
			</tr>
			<tr>
				<td>00002</td><td>オレンジ</td><td>50円</td>
			</tr>
			<tr>
				<td>00003</td><td>メロン</td><td>1200円</td>
			</tr>
		</table>
		<button type="button" onclick="history.back()">戻る</button>
		</p>
	<% } %>
	
	<%if(request.getAttribute("no").equals(2)){ %>
		<h1 align="center">商品一覧</h1>
		<center>
		<form>
			<table border="1" align="center">
				<tr>
					<th></th><th>ID</th><th>商品名</th><th>価格</th>
				</tr>
				<tr>
					<td><input type="radio" name="radio" value="apple"></td><td>00001</td><td>りんご</td><td>100円</td>
				</tr>
				<tr>
					<td><input type="radio" name="radio" value="orange"></td><td>00002</td><td>オレンジ</td><td>50円</td>
				</tr>
				<tr>
					<td><input type="radio" name="radio" value="melon"></td><td>00003</td><td>メロン</td><td>1200円</td>
				</tr>
			</table>
			<div style="display:inline-flex">
				<input type="submit" name="submit" value="変更" formmethod="POST" formaction="mod.jsp">
			
				<input type="submit" name="submit" value="削除" formmethod="POST" formaction="kakunin.jsp">
			
				<button type="button" onclick="history.back()">戻る</button>
			</div>
		</form>
		</center>
	<% } %>
	<%if(request.getAttribute("no").equals(3)){ %>
		<h1 align="center">商品一覧</h1>
		<center>
		<form>
			<table border="1">
				<tr>
					<th>ID</th><th>商品名</th><th>価格</th>
				</tr>
				<%ArrayList<ShohinBean> list = (ArrayList<ShohinBean>)request.getAttribute("list"); %>
				<%for(int i = 0; i<list.size();i++){ %>
					<tr>
						<td><%=list.get(i).getId()%></td>
						<td><%=list.get(i).getName() %></td>
						<td><%=list.get(i).getPrice() %></td>
					</tr>
				<%} %>
			
			</table>
			<div style="display:inline-flex">
				<input type="submit" name="submit" value="変更" formmethod="POST" formaction="mod.jsp">
			
				<input type="submit" name="submit" value="削除" formmethod="POST" formaction="kakunin.jsp">
			
				<button type="button" onclick="history.back()">戻る</button>
			</div>
		</form>
		</center>
	<%} %>
	<%if(request.getAttribute("no").equals(4)){ %>
		<h1 align="center">商品一覧</h1>
		<center>
		<form>
			<table border="1" align="center">
				<tr>
					<th></th><th>ID</th><th>商品名</th><th>価格</th>
				</tr>
				<%ArrayList<ShohinBean> list = (ArrayList<ShohinBean>)request.getAttribute("list"); %>
				<%for(int i = 0; i<list.size();i++){ %>
					<tr>
						<td><input type="radio" name="radio" value=<%=list.get(i).getId()%>></td>
						<td><%=list.get(i).getId()%></td>
						<td><%=list.get(i).getName() %></td>
						<td><%=list.get(i).getPrice() %></td>
					</tr>
				<%} %>
			</table>
			<%if(request.getAttribute("message")!=null){ %>
				<font color="red"><%=request.getAttribute("message") %></font><br>
			<%} %>
			<div style="display:inline-flex">
				<input type="submit" name="submit" value="変更" formmethod="POST" formaction="/NockWeb/DUControlServlet">
			
				<input type="submit" name="submit" value="削除" formmethod="POST" formaction="/NockWeb/DUControlServlet">
			
				<button type="button" onclick="history.back()">戻る</button>
			</div>
			</p>
		</form>
		</center>
	<%} %>
</body>
</html>