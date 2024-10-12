<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Category List</h1>
<br>
<a href="<c:url value='/admin/category/insert'/>">Add Category</a>
<br>
<table border="1px">
  <tr>
    <th>STT</th>
    <th>Images</th>
    <th>Category Name</th>
    <th>Staus</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${listcate}" var="cate" varStatus="STT" >
    <tr>
      <td>${STT.index+1}</td>

      <c:if test="${cate.images.substring(0,5)=='https'}">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
      </c:if>

      <c:if test="${cate.images.substring(0,5)!='https'}">
        <c:url value="/images?fname=${cate.images}" var="imgUrl" />
      </c:if>

      <td><img height="150" width="200" src="${imgUrl}" /></td>
      <td>${cate.categoryname}</td>
      <td>${cate.status}</td>
      <td><a href="<c:url value='/admin/category/edit?id=${cate.categoryid}'/>">Sửa</a>
        | <a href="<c:url value='/admin/category/delete?id=${cate.categoryid}'/>" >Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>

