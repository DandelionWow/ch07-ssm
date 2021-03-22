<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>" />
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //在当前页面dom对象加载后，执行loadStudentData()
            loadStudentData();
            //单击按钮执行loadStudentData()
            $("#selectBtn").click(function () {
                loadStudentData();
            })
        })

        function loadStudentData() {
            $.ajax({
                url:"student/queryStudents.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    //清除旧的数据
                    $("#info").html("");
                    //增加新的数据
                    $.each(data,function (i,n) {
                        $("#info").append("<tr>")
                        $("#info").append("<td>" + n.id + "</td>")
                        $("#info").append("<td>" + n.name + "</td>")
                        $("#info").append("<td>" + n.age + "</td>")
                        $("#info").append("</tr>")
                    })
                }
            })
        }

    </script>
</head>
<body>

    <div align="center">
        <button type="button" id="selectBtn">查询所有学生</button>
        <table>
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
    </div>

</body>
</html>
