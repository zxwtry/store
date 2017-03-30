<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC I18N</title>
</head>
<body>
	Language:
	<a href="?lang=en_US">English</a>-<a href="?lang=zh_CN">Chinese</a>
	<h2>
		<spring:message code="welcome"/>
	</h2>
	Locale: ${pageContext.response.locale}
</html>