<%--设置字符编码集为utf-8--%>
<%@page pageEncoding="utf-8" isELIgnored="false" %>
<%--核心css--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"/>
<!--jqgrid的核心css-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jqgrid/css/ui.jqgrid.css"/>
<!--jqgrid的主题css-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jqgrid/css/css/cupertino/jquery-ui-1.8.16.custom.css"/>

<%--引入js--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.4.1.js"></script>
<%--bootStrap  js--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<!--jqgrid的核心js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/jqgrid/js/jquery.jqGrid.src.js"></script>
<!--jqgrid的国际化js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/jqgrid/js/i18n/grid.locale-cn.js"></script>
<%--设置网页内容为himl5形式、移动设备优先--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <%--移动设备优先--%>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <head>
        <script type="text/javascript">
            //页面加载之后执行
            $(function () {
                //查所有
                $("#pTable").jqGrid({
                    url:"${pageContext.request.contextPath}/mylog/queryAll",//向控制器发分页查所有
                    datatype:"json",//预期结果类型
                    autowidth:true, // 自适合宽度
                    colNames:["ID","管理员姓名","操作时间","操作类型","结果"],
                    colModel:[{name:"id"},{name:"adminname",editable:true},{name:"date",editable:true},{name:"thing",editable:true},
                        {name:"flag",editable:true}],
                    viewrecords:true,
                }).jqGrid("navGrid","#pager",{add:true,edit:true,del:true},{colseAfterAdd:true},{colseAfterEdit:true});//增删改查
            });//页面加载结束
        </script>
    </head>



<body>
<%--创建表格--%>
<table id="pTable"></table>
<div id="pager"></div>
</body>
