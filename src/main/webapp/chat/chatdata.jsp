<%@page import="gwon.web.chat.chatVo"%>
<%@page import="java.util.List"%>
<%@page import="gwon.web.chat.chatDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id=request.getParameter("id");
String content=request.getParameter("content");
int count=0;
chatDAO dao=chatDAO.getChatDAO();
dao.insert(id, content);
List<chatVo> list=dao.select();
%>
{
"chat":[
<%for(chatVo da:list){ 
System.out.println(da.getId());
%>
{
"id":"<%= da.getId()%>",
"content":"<%=da.getContent()%>"
}<%
if(list.size()-1>count) {
	count++;
%>
,
<%} %>	

<%} %>	
]
}