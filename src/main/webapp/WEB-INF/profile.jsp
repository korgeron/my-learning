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
  <link rel="stylesheet" href="/css/profile.css">
</head>
<body>
<%@ include file="partials/profile-nav.jsp"%>

<container>
    <profilecontent>
        <profileimage>
            <img style="height: 80px; width: auto; border-radius: 100%; border: 1px inset darkslategrey;" src="/images/profile-img.webp" alt="profile image">
            <h6 style="font-size: 20px; display: flex; align-self: flex-end">${user}</h6>
        </profileimage>
        <content1>

            <comment>
                <p>${comment}</p>
            </comment>

            <commentbox>

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

    <productcontent>

    </productcontent>
</container>






</body>
</html>
