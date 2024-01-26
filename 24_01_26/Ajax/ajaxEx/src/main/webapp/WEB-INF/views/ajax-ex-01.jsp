<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex01</title>
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
<button onclick="ex01Fn()">ex01 함수 호출</button>
</body>
<script>
    const ex01Fn = () => {
        $.ajax({
            // 요청방식: get
            // 요청주소: /ex01
            type: "get",
            url: "/ex01",
            // 요청이 성공했을 때 실행되는 부분
            success: function(res) {
                console.log("성공", res);
            },
            // 요청이 실패했을 때 실행되는 부분
            error: function() {
                console.log("실패");
            }
        })
    }

</script>
</html>