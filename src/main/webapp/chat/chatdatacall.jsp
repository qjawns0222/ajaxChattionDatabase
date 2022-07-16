<%@page import="gwon.web.chat.chatVo"%>
<%@page import="java.util.List"%>
<%@page import="gwon.web.chat.chatDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

int count=0;
chatDAO dao=chatDAO.getChatDAO();

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