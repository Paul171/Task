<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h2>Hello World! <c:out value='${user}' /></h2>
<form:form action="addTask" method="post">

</form:form>
</body>
</html>
