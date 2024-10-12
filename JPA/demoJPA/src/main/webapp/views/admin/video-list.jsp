<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Video List</h1>
<br/>
<form action="<c:url value='/admin/video/listvideo'/>" method="get">
    <input type="text" name="search" placeholder="Search video">
    <input type="submit" value="Search">
<br/>
<a href="<c:url value='/admin/video/insert'/>">Add Video</a>
<br/>
<table border="1px">
    <tr>
        <th>STT</th>
        <th>Poster</th>
        <th>Description</th>
        <th>Video Title</th>
        <th>Views</th>
        <th>Category Name</th>
        <th>Actions</th>
        <th>Play Videos</th>
    </tr>
    <c:forEach items="${listvideo}" var="video" varStatus="STT" >
        <tr>
            <td>${STT.index+1}</td>

            <c:if test="${video.poster.substring(0,5)=='https'}">
                <c:url value="${video.poster}" var="imgUrl"></c:url>
            </c:if>

            <c:if test="${video.poster.substring(0,5)!='https'}">
                <c:url value="/images?fname=${video.poster}" var="imgUrl" />
            </c:if>

            <c:if test="${video.videourl.substring(0,5)=='https'}">
                <c:url value="${video.videourl}" var="videoUrl"></c:url>
            </c:if>
            <c:if test="${video.videourl.substring(0,5)!='https'}">
                <c:url value="/videos?fname=${video.videourl}" var="videoUrl" />
            </c:if>

            <td><img height="150" width="200" src="${imgUrl}" /></td>
            <td>${video.description}</td>
            <td>${video.title}</td>
            <td>${video.views}</td>

            <c:if test="${not empty video.category}">
                <td>${video.category.categoryname}</td>
            </c:if>
            <c:if test="${empty video.category}">
                <td>Không có danh mục</td>
            </c:if>

            <td><a href="<c:url value='/admin/video/edit?id=${video.videoid}'/>">Sửa</a>
                | <a href="<c:url value='/admin/video/delete?id=${video.videoid}'/>" >Xóa</a>
            </td>
            <td>
                <button onclick="playVideo('${videoUrl}')">Play</button>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- Thêm khung phát video -->
<div id="videoPlayerContainer" style="display:none;">
    <h3>Now Playing:</h3>
    <video id="videoPlayer" width="600" controls>
        <source id="videoSource" src="" type="video/mp4">
        Your browser does not support the video tag.
    </video>
</div>

<script>
    // Hàm để phát video khi người dùng nhấn nút "Play"
    function playVideo(videoURL) {
        // Xây dựng đường dẫn đầy đủ nếu videoURL chỉ là tên file
        var fullVideoURL = videoURL;

        // Hiển thị và phát video
        document.getElementById('videoPlayerContainer').style.display = 'block';
        var videoPlayer = document.getElementById('videoPlayer');
        var videoSource = document.getElementById('videoSource');
        videoSource.src = fullVideoURL;
        videoPlayer.load();
        videoPlayer.play();
    }
</script>

