

<!-- 検索キーワードに該当するものを表示 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%@page import="bean.Book, java.util.List" %>

<% List<Book> list=(List<Book>)request.getAttribute("list"); %>

<%for (Book b : list) { %>
  タイトル：<%=b.getTitle()%>　　著者：<%=b.getAuthor() %>
<% } %>

<%@include file="../footer.html" %>
