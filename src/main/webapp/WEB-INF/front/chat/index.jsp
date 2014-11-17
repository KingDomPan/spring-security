<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>Chat</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
    <textarea rows="20" cols="60" id="info" readonly="readonly"></textarea>
    <hr />
        昵称：
    <input type="text" id="userName" />
    <br /> 
        消息：
    <textarea rows="5" cols="30" id="content"></textarea>
    <input type="button" value=" Send " onclick="send()"
        style="height: 85px; width: 85px;" />
</body>
<script type="text/javascript"
    src="${pageContext.request.contextPath }/dwr/engine.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath }/dwr/util.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath }/dwr/interface/MessageService.js"></script>
<script type="text/javascript">
    function send() {
        var time = new Date();
        var content = dwr.util.getValue("content");
        var name = dwr.util.getValue("userName");
        var info = encodeURI(encodeURI(name + " say:\n" + content));
        var msg = {
            "msg" : info,
            "time" : time
        };
        dwr.util.setValue("content", "");
        if (!!content) {
            MessageService.sendMessage(msg);
        } else {
            alert("发送的内容不能为空~");
        }
    }

    function showMessage(data) {
        var message = decodeURI(decodeURI(data.msg));
        var text = dwr.util.getValue("info");
        if (!!text) {
            dwr.util.setValue("info", text + "\n" + data.time + "  " + message);
        } else {
            dwr.util.setValue("info", data.time + "  " + message);
        }
    }
</script>
</html>