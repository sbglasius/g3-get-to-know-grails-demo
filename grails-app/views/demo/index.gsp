<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<g:hasErrors bean="${person}">
    <div class="alert alert-warning">
        <g:renderErrors bean="${person}"/>
    </div>
</g:hasErrors>


<g:form action="save">
    <fieldset>
    <div class="form-group">
        <label for="name">Name:</label><input class="form-control" type="text" name="name" id="name" value="${person.name}"/>
    </div>
    <div class="form-group">
        <label for="age">Age:</label><input class="form-control" type="number" name="age" id="age" value="${person.age}"/>
    </div>
    <div class="form-group">
        <label for="address.street">Street:</label><input class="form-control" type="text" name="address.street" id="address.street" value="${person.address?.street}"/>
    </div>
    <div class="form-group">
        <label for="address.zip">Zip:</label><input class="form-control" type="text" name="address.zip" id="address.zip" value="${person.address?.zip}"/>
    </div>
    <div class="form-group">
        <label for="address.city">City:</label><input class="form-control" type="text" name="address.city" id="address.city" value="${person.address?.city}"/>
    </div>
    </fieldset>
    <fieldset>
    <g:submitButton name="submit" value="Submit"/>
    </fieldset>
</g:form>

</body>
</html>