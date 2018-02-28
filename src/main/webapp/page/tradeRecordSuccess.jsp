<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jxpxx
  Date: 2018/1/6
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
    <head>
        <title>交易记录查询</title>
        <link href="<c:url value="/css/default.css" />" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            【<c:out value="${sessionScope.get('account')}"/> 用户】，欢迎你登录XX银行个人网上银行系统！
        </div>
        <div id="menu" align="center">
            <div class="operateTitle">
                操作菜单
                <div>
                    <span class="menu"><a href="index">个人首页</a></span>
                    <span class="menu"><a href="remaining">账号余额查询</a></span>
                    <span class="menu"><a href="tradeRecord">交易记录查询</a></span>
                    <span class="menu"><a href="transfer">行内单笔转账</a></span>
                </div>
                <div id="title" align="center"><h1>交易记录查询</h1></div>
                <div align="center">
                    <table class="divTab" width="100%">
                        <tr>
                            <td><b>流水号</b></td>
                            <td><b>交易类型</b></td>
                            <td><b>交易金额</b></td>
                            <td><b>交易时间</b></td>
                            <td><b>交易摘要</b></td>
                        </tr>
                        <c:forEach var="item" items="${requestScope.get('data')}">
                            <tr>
                                <td><b><c:out value="${item.getID()}"/> </b></td>
                                <td><b><c:out value="${item.getTradeType()}"/> </b></td>
                                <td><b>￥<c:out value="${item.getTradeMoney()}"/> </b></td>
                                <td><b><c:out value="${item.getTradeTime()}"/></b></td>
                                <td><b><c:out value="${item.getTradeDigest()}"/></b></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
