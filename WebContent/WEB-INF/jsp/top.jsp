<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="cc.shinbi.shindan.model.Shindan" %>
<%@ page import="cc.shinbi.shindan.model.Question" %>
<%@ page import="cc.shinbi.shindan.model.Item" %>

<%
	String message = (String)request.getAttribute("message");
	Shindan shindan = (Shindan)request.getAttribute("shindan");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>むかしばなし診断</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	</head>
	<body>
		<h1>むかしばなし診断</h1>
		<p>むかしばなし診断へようこそ。あなたにぴったりの、むかしばなしを診断します。</p>
<%
	if(message != null) {
%>
		<div id="error"><%= message %></div>
<%
	}
%>
		<form method="post" action="${pageContext.request.contextPath}/result">
			<h3>あなたのお名前は?</h3>
			<input type="text" name="name">
<%
	for(Question question : shindan.getQuestions()) {
%>
			<h3><%= question.getQuestion() %></h3>
			<div>
<%
		String option = "checked";
		for(Item item : question.getItems()) {

%>
			<div>
				<input type="radio"
					   name="<%= question.getKey() %>"
					   value="<%= item.getId() %>"
					   <%= option %>
				>
				<%= item.getText() %>
			</div>
<%
			option = "";
		}
%>
			</div>
<%
	}
%>
			<div id="buttons">
				<input type="submit" value="診断する">
			</div>
		</form>
	</body>
</html>
