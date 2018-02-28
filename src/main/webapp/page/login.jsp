<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jxpxx
  Date: 2018/1/6
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
    <head>
        <link href="<c:url value="/css/default.css" />" rel="stylesheet" type="text/css"/>
        <title style="font-size:12px">XX银行个人网上银行系统</title>
        <style type="text/css">
            body {
                font-family: Tahoma, Verdana;
                font-size: 12px
            }
        </style>
    </head>
    <body>
        <div id="title" align="center"><h1>XXX银行个人网上银行系统</h1></div>
        <div id="operation">
            <div id="link_student" align="center">
                <form:form action="/login" method="post" modelAttribute="account">
                    <TABLE class="divTab" width="500">
                        <TR>
                            <TD colspan="2" align="center" style="font-size:25px;">个人客户登录</TD>
                        </TR>
                        <c:if test="${requestScope.get('result') == null}">
                            <TR>
                                <TD colspan="2" align="center" style="font-size:15px;color:red;">
                                    账号或密码不对！
                                </TD>
                            </TR>
                        </c:if>

                        <TR>
                            <TD align="right" width="35%">账号：</TD>
                            <TD align="left" width="65%"><form:input type="text" path="AccountID"/></TD>
                        </TR>
                        <TR>
                            <TD align="right" width="35%">密码：</TD>
                            <TD align="left" width="65%"><form:input type="password" path="Password"/></TD>
                        </TR>
                        <TR>
                            <TD colspan="2" align="center" style="font-size:30px;">
                                <INPUT TYPE="submit" value="提交">
                                <INPUT TYPE="reset" value="重置">
                            </TD>
                        </TR>
                    </TABLE>
                </form:form>
            </div>
        </div>
    </body>
</html>

