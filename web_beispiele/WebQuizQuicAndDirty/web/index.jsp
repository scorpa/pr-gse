<%-- 
    Document   : index
    Created on : 09.05.2011, 12:33:06
    Author     : Rudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
            quiz.Quiz q = (quiz.Quiz) session.getAttribute("quiz");
            if (q == null)  // erster Aufruf
            {
                q = new quiz.Quiz();
                session.setAttribute("quiz", q);
                session.setAttribute("frage", q.next());
            } else
            {
                quiz.Frage f = (quiz.Frage) session.getAttribute("frage");
                int antwort = Integer.parseInt(request.getParameter("antwort"));
                if (antwort == f.getRichtig())
                {
                    session.setAttribute("frage", q.next());
                    pageContext.setAttribute("richtig", true);
                } else
                {
                    pageContext.setAttribute("richtig", false);
                }
            }

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
    </head>
    <body>
        <form action="index.jsp">
            <%
            quiz.Frage f = (quiz.Frage) session.getAttribute("frage");
            if (f != null)
            {
            %>
            <%=f.getText()%><br/>
            <input type="radio" name="antwort" value="0" checked="checked"/> <%=f.getAntwort(0)%> <br/>
            <input type="radio" name="antwort" value="1" /> <%=f.getAntwort(1)%> <br/>
            <input type="radio" name="antwort" value="2" /> <%=f.getAntwort(2)%> <br/>
            <input type="submit" value="WEITER"/>
            <%
                boolean richtig = (Boolean) pageContext.getAttribute("richtig");
                if (richtig)
                {
            %>
            <p>Richtig!!!</p>
            <%                    } else
                {
            %>
            <p>Leider falsch - probieren Sie noch einmal!</p>
            <%                }
            } else
            {
                session.removeAttribute("quiz");
                session.removeAttribute("frage");
            %>
            <h1> Auf Wiedersehen </h1>
            <%
            }
            %>

        </form>
    </body>
</html>
