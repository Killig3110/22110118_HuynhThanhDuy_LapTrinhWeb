<%--
  Created by IntelliJ IDEA.
  User: killi
  Date: 9/26/2024
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/admin/category/update"/>" method="post" enctype="multipart/form-data">

    <input type="text" id="categoryid" name="categoryid" hidden="hidden"
           value="${cate.categoryid}">

    <label for="fname">Category name:</label><br>
    <input type="text" id="fname" name="categoryname" value="${cate.categoryname}"><br>
    <label for="images">Images:</label><br>
    <input type="file" id="images" name="images" onchange="chooseFile(this)">
    <br/>
    <c:if test="${cate.images.substring(0,5)=='https'}">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <c:if test="${cate.images.substring(0,5)!='https'}">
        <c:url value="/images?fname=${cate.images}" var="imgUrl" />
    </c:if>

    <td><img id="imagess" height="150" width="200" src="${imgUrl}" /></td>
    <br/>
    <input type="radio" id="ston" name="status" value="${cate.status}" ${cate.status == 1?'checked':'' } >
    <label for="ston">Online</label><br>
    <input type="radio" id="stoff" name="status" value="${cate.status}" ${cate.status == 1?'checked':'' }>
    <label for="stoff">Offline</label><br>
    <input type="submit" value="Submit">
</form>
