<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/admin/category/add"/>" method="post" enctype="multipart/form-data">

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
  <input type="radio" id="ston" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}>
  <label for="ston">Online</label><br>
  <input type="radio" id="stoff" name="status" value="0" ${cate.status == 0 ? 'checked' : ''}>
  <label for="stoff">Offline</label><br>
  <input type="submit" value="Submit">
</form>
