<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-01-26
  Time: 오전 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex07</title>
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
<button onclick="ex07Fn()">ex07 함수 호출</button>
</body>
<script>
    const ex07Fn = () => {
        const val1 = "Hello SpringBoot!!";

        const params = {
            "param1": val1,
            "param2": "안녕"
        };

        $.ajax({
            // 요청방식: post
            // 요청주소: /ex07
            type: "post",
            url: "/ex07",
            // parameter 전달하기
            data: JSON.stringify(params),
            contentType: "application/json",
            // 요청이 성공했을 때 실행되는 부분
            success: function(res) {
                console.log("성공", res);
                console.log("param1", res.param1);
            },
            // 요청이 실패했을 때 실행되는 부분
            error: function() {
                console.log("실패");
            }
        })
    }

</script>
</html>