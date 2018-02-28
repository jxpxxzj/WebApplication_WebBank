<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jxpxx
  Date: 2018/1/6
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
    <head>
        <title>行内单笔转账</title>
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
                <div id="title" align="center"><h1>行内单笔转账成功</h1></div>
                <div align="center">
                    <table class="divTab" width="80%">
                        <tr>
                            <td colspan="2">
                                <br/>
                                <br/>
                                <span class="remaining">
                                你已成功将￥[<c:out value="${requestScope.get('money')}"/> ]转入到[<c:out
                                        value="${requestScope.get('account')}"/>]账号！
                                </span>
                                <br/>
                                <br/>
                                <br/>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
