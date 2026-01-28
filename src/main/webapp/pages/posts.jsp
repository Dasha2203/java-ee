<%--
  Created by IntelliJ IDEA.
  User: korbut.darya
  Date: 28.01.26
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Posts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" integrity="sha384-tViUnnbYAV00FLIhhi3v/dWt3Jxw4gZQcNoSCxCIFNJVCx7/D55/wXsrNIRANwdD" crossorigin="anonymous">
</head>
<body>
  <jsp:include page="../components/header.jsp"/>
  <jsp:include page="../components/create_post_modal.jsp"/>

  <div class="pt-4 container">
    <div class="d-flex w-100 justify-content-between">
      <h1 class="h2">Posts</h1>

      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Create post
      </button>
    </div>

    <c:if test="${posts == null}">
      <span>No data</span>
    </c:if>


    <c:if test="${posts != null}">
      <div class="w-100 col-6 mx-auto mt-4">
        <c:forEach items="${posts}" var="post">
          <div class="card mx-auto">
            <img src="${post.img}" class="card-img-top" alt=${post.title}>
            <div class="card-body">
              <h5 class="card-title">${post.title}</h5>
              <p class="card-text">${post.title}</p>
            </div>
          </div>
        </c:forEach>
      </div>
    </c:if>

    <div>

    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
