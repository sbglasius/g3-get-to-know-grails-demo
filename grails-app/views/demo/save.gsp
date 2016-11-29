<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
    <content tag="nav">
        <li><a href="#">My nav</a></li>
    </content>
    <g:hasErrors bean="${person}">
        <div class="alert alert-warning">
            <g:renderErrors bean="${person}"/>
        </div>
    </g:hasErrors>
    <p>Hello ${person.name} (${person.age})</p>
    <g:if test="${person.address}">
    <p>Address: ${person.address.street}, ${person.address.city}, ${person.address.zip}</p>
    </g:if>
</body>
</html>

