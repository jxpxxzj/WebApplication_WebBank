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
                <div id="title" align="center"><h1>行内单笔转账</h1></div>
                <div align="center">
                    <form action="/user/doTransfer" method="post">
                        <TABLE class="divTab" width="500">
                            <TR>
                                <TD colspan="2" align="center" style="font-size:25px;">
                                    行内单笔转账清单
                                </TD>
                            </TR>
                            <c:if test="${requestScope.get('fail')}">
                                <TR>
                                    <TD colspan="2" align="center" style="font-size:15px;color:red;">
                                        接收账号不正确！存款金额不足！
                                    </TD>
                                </TR>
                            </c:if>

                            <TR>
                                <TD align="right" width="35%">接收账号：</TD>
                                <TD align="left" width="65%"><INPUT TYPE="text" NAME="accountId" value=""></TD>
                            </TR>
                            <TR>
                                <TD align="right" width="35%">转账金额：</TD>
                                <TD align="left" width="65%"><INPUT TYPE="text" NAME="money" value=""></TD>
                            </TR>
                            <TR>
                                <TD colspan="2" align="center" style="font-size:30px;">
                                    <INPUT TYPE="submit" value="进行转账">
                                    <INPUT TYPE="reset" value="取消操作">
                                </TD>
                            </TR>
                        </TABLE>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

