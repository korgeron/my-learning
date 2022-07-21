<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kjorgeron0819
  Date: 7/19/22
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
</head>
<body>
<%@ include file="partials/profile-nav.jsp"%>

<container>
    <profilecontent style="max-height: 80vh">
        <profileimage style="margin-top: .5em">
            <img style="height: 80px; width: auto; border-radius: 100%; border: 1px inset darkslategrey;" src="/images/profile-img.webp" alt="profile image">
            <h6 style="font-size: 20px; display: flex; align-self: flex-end">${user}</h6>
        </profileimage>
        <content1 style="margin-left: 1em">

            <comment style="overflow-y: scroll; margin-top: 1em">
                <c:if test="${comments != null}">
                <c:forEach var="comment" items="${comments}">
                    <box style="display: flex;padding-left: .5em; margin: 0; border-bottom: 1px solid grey">
                        <img style="height: 30px; width: auto; border-radius: 5%; border: 1px inset darkslategrey; align-self: center" src="${comment.getUrl()}" alt="profile image">
                        <p style="padding-left: .5em; word-wrap: break-word">${comment.getComment()}</p>
                    </box>
                </c:forEach>
                </c:if>

            </comment>

            <commentbox style="margin-bottom: 1em">

                <form action="/profile" method="POST">
                    <formcontent>
                        <label for="comment">COMMENTS</label>
                        <textarea style="height: 90px" name="comment" id="comment" cols="30" rows="10"></textarea>
                    </formcontent>
                    <formbutton>
                        <button type="submit">Post</button>
                    </formbutton>
                </form>

            </commentbox>

        </content1>

        <content2>
            <h5 style="text-align: center">ABOUT ME</h5>
            <p style="padding: 1px">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem incidunt laboriosam laborum minima reiciendis repudiandae tempore veritatis.</p>
            <h5 style="text-align: center">ABOUT PRODUCTS</h5>
            <p style="padding: 1px">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
            <p style="padding: 1px">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>

        </content2>

    </profilecontent>

    <productcontent style="display: flex">
        <box style ="margin-top: 1em;margin-left: 1.5em;background: rgba(128,128,128,0.43);min-height: 83vh; max-height: 83vh; width: 90%; border-radius: 2%; border: 1px solid dimgrey; display: flex; overflow-y: scroll; flex-wrap: wrap">
            <card style="height: 200px; width: 130px; border: 1px solid grey; border-radius: 2%; margin: .5em; background: lightgrey">

            </card>
        </box>
    </productcontent>


</container>






</body>
</html>
