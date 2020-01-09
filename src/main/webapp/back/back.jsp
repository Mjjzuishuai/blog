<%--设置字符编码集为utf-8--%>
<%@page pageEncoding="utf-8" isELIgnored="false" %>
<%--核心css--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>
<%--引入js--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<%--设置网页内容为himl5形式、移动设备优先--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <%--移动设备优先--%>
    <meta name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-2">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                               aria-expanded="true" aria-controls="collapseOne">
                                管理员操作
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                         aria-labelledby="headingOne">
                        <div class="panel-body">
                            <a href="javascript:$('#right').load('${pageContext.request.contextPath}/jsp/main.jsp')">所有微博</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                管理员
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">
                            <a href="javascript:$('#right').load('${pageContext.request.contextPath}/back/adminLog.jsp')">日志</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-10" id="right">
            <div class="page-header">
                <h1>欢迎进入博客系统
                    <small>请各位管理员谨慎操作</small>
                </h1>
            </div>
        </div>
    </div>

</div>

</body>

</html>