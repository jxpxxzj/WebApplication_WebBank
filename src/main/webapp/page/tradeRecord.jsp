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
                    <form action="/user/doTradeRecord" method="post">
                        <TABLE class="divTab" width="500">
                            <TR>
                                <TD colspan="2" align="center" style="font-size:25px;">
                                    请选择查询交易时段
                                </TD>
                            </TR>

                            <c:if test="${requestScope.get('fail')}">
                                <TR>
                                    <TD colspan="2" align="center" style="font-size:15px;color:red;">
                                        请输入正确的查询时段！
                                    </TD>
                                </TR>
                            </c:if>

                            <TR>
                                <TD align="right" width="35%">开始时间：</TD>
                                <TD align="left" width="65%"><INPUT TYPE="text" NAME="begin" value="2008-11-08"></TD>
                            </TR>
                            <TR>
                                <TD align="right" width="35%">结束时间：</TD>
                                <TD align="left" width="65%"><INPUT TYPE="text" NAME="end" value="2008-11-25"></TD>
                            </TR>
                            <TR>
                                <TD colspan="2">*本查询仅能查询自当前时间起一个月内的业务</TD>
                            </TR>
                            <TR>
                                <TD colspan="2" align="center" style="font-size:30px;">
                                    <INPUT TYPE="submit" value="查看交易明细">
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

