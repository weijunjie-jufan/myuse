<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片信息</title>
</head>
<body>
    <div>
        <h3>${excle.name}</h3>
        <h3>${excle.applyNumber}</h3>
        <h3>${excle.orderNumber}</h3>
        <a href="/findOne?id=${excle.id+1}">下一个</a>
        <div>
            <img alt="图片为空" src="${excle.cardUrl}" width="400px" height="250px;"/>
            <img alt="图片为空" src="${excle.backUrl}" width="400px" height="250px;"/>
            <img alt="图片为空" src="${excle.faceUrl}" width="400px" height="250px;"/>
        </div>
        <div>
            <object data="${excle.totalUrl}" type="application/pdf" width="600" height="400">
            </object>
            <object data="${excle.hetongUrl}" type="application/pdf" width="600" height="400">
            </object>
        </div>
    </div>
</body>
</html>
