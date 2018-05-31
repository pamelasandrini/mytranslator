<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My translator index</title>
</head>
<body>

Please enter your text to translate to Portuguese:

<f:form action="translate" method="get" commandName="text">
	<f:textarea rows="10" cols="60" path="originalText" id="originalText"/>
	
	<br>
	
	Translation:
	<f:input type="text" path="translatedText" id="translatedText" />
	
	<br>
	<f:button type="submit">Translate</f:button>
</f:form>

</body>
</html>