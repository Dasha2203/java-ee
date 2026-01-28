<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" integrity="sha384-tViUnnbYAV00FLIhhi3v/dWt3Jxw4gZQcNoSCxCIFNJVCx7/D55/wXsrNIRANwdD" crossorigin="anonymous">
</head>
<body class="min-vh-100 d-flex flex-column">
    <jsp:include page="../../components/header.jsp"/>

    <div class="container col-12 col-sm-10 col-md-8 col-xl-4 flex-grow-1 d-flex flex-column justify-content-center">
        <c:if test="${message != null}">
            <div class="alert alert-warning" role="alert">
                    ${message}
            </div>
        </c:if>


        <h2 class="h2">Login</h2>
        <form method="post" action="/login" class="w-100 d-flex flex-column gap-3">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input name="email" type="email" id="email" class="form-control" autocomplete="off">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input name="password" type="password" id="password" class="form-control" autocomplete="off">
            </div>
            <button type="submit" class="btn btn-primary w-100">Submit</button>
        </form>
        <a class="link-opacity-100-hover d-block w-100 text-center mt-2" href="/register">Registration</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>