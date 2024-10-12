<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/admin/video/update"/>" method="post" enctype="multipart/form-data">

    <input type="text" id="videoid" name="videoid" hidden="hidden"
           value="${video.videoid}">
    <label for="videotitle">Video Title</label><br>
    <input type="text" id="videotitle" name="videotitle" value="${video.title}"><br>
    <label for="description">Description</label><br>
    <input type="text" id="description" name="description" value="${video.description}"><br>
    <label for="poster">Poster:</label><br>
    <input type="file" id="poster" name="poster" onchange="chooseFile(this)">
    <br/>
    <c:if test="${video.poster.substring(0,5)=='https'}">
        <c:url value="${video.poster}" var="imgUrl"></c:url>
    </c:if>

    <c:if test="${video.poster.substring(0,5)!='https'}">
        <c:url value="/images?fname=${video.poster}" var="imgUrl"/>
    </c:if>

    <td><img id="posters" height="150" width="200" src="${imgUrl}"/></td>
    <br/>
    <label for="videourl">Video:</label><br>
    <input type="file" id="videourl" name="videourl" onchange="chooseFile(this)">
    <br/>

    <c:if test="${video.videourl.substring(0,5)=='https'}">
        <c:url value="${video.videourl}" var="videoUrl"></c:url>
    </c:if>
    <c:if test="${video.videourl.substring(0,5)!='https'}">
        <c:url value="/videos?fname=${video.videourl}" var="videoUrl" />
    </c:if>

    <label for="views">Views:</label><br>
    <input type="text" id="views" name="views" value="${video.views}"><br>
    <label for="category">Category:</label><br>
    <select id="category" name="category" varStatus="STT">
        <c:forEach items="${listcategory}" var="cate" varStatus="STT">
            <option value="${cate.categoryid}"
                    <c:if test="${cate.categoryid == video.category.categoryid}">
                        selected="selected"
                    </c:if>
            >
                    ${cate.categoryname}
            </option>
        </c:forEach>
    </select>>
    <br>
    <input type="submit" value="Submit">
</form>
