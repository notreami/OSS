<%--
  Created by IntelliJ IDEA.
  User: notreami
  Date: 15/12/24
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@page autoFlush="true" buffer="16kb" contentType="text/html;charset=UTF-8" deferredSyntaxAllowedAsLiteral="true"
        errorPage="assist/error.jsp" import="java.util.*" info="Some Message" isELIgnored="true" isErrorPage="true"
        isThreadSafe="true" language="java" pageEncoding="UTF-8" session="true" trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>JSP学习和记录</title>
</head>
<body>
<ol type="A">
    <li>JSP基本语法</li>
    <p>JSP基本语法主要由脚本元素,指令元素,动作元素以及注释构成</p>
    <ol type="1">

        <li>脚本元素< % 代码片段 % ></li>
        <ol type="circle">
            <li>
                < %!声明(declaration)% >
            </li>
            <%!
                //JSP声明片段: 注意，不建议在JSP页面上定义变量或方法,只是不建议定义.
                int i = 10;
                String str = "JSP声明片段: 注意，不建议在JSP页面上定义变量或方法,只是不建议定义.";

                public String printMethod() {
                    System.out.println(str);
                    return str;
                }
            %>
            <p>
                <%out.print(printMethod());%>
            </p>

            <li>
                < %=表达式(express)% >
            </li>
            <p>
                JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
            </p>
            <p>
                Current time: <%= new java.util.Date()%>
            </p>

            <li>
                <%="< % 脚本(Scriplets),程序代码，一行或多行 % >" %>
            </li>
            <p>
                <%out.print(i);%>
            </p>

            <li>
                < %-- 注释 --% >
            </li>
            <p>HTML/XML注释:<!--comment [< % = expression % >] --></p>
            <p>JSP语法：<%-- comment --%>< %-- comment --% ></p>
        </ol>

        <li>
            指令元素 < %@ directive attribute="value" % >
        </li>
        <p>page,include,taglib</p>
        <%--<%@page--%>
        <%--autoFlush="true" 控制out对象自动刷新缓存区--%>
        <%--buffer="16kb" 指定out对象使用缓冲区的大小--%>
        <%--contentType="text/html;charset=UTF-8" 指定当前JSP页面的MIME类型和字符编码--%>
        <%--deferredSyntaxAllowedAsLiteral="true"  该属性指示在JSP页面的模板文本中是否允许出现字符序列#{--%>
        <%--errorPage="assist/error.jsp" 指定当JSP页面发生异常时需要转向的错误处理页面--%>
        <%--extends="javax.servlet.http.HttpServlet" 指定servlet从哪一个类继承 由服务器提供商专为这种目的提供的类 --%>
        <%--import="java.util.*" 导入要使用的Java类--%>
        <%--info="Some Message" 定义JSP页面的描述信息--%>
        <%--isELIgnored="true" 指定是否执行EL表达式--%>
        <%--isErrorPage="true" 指定当前页面是否可以作为另一个JSP页面的错误处理页面--%>
        <%--isThreadSafe="true" 指定对JSP页面的访问是否为线程安全--%>
        <%--language="java" 定义JSP页面所用的脚本语言，默认是Java--%>
        <%--pageEncoding="UTF-8" 页面编码--%>
        <%--session="true" 指定JSP页面是否使用session--%>
        <%--trimDirectiveWhitespaces="true" 使jsp输出的html时去除多余的空行（jsp上使用EL和tag会产生大量的空格和空行）--%>
        <%--%>--%>
        <%--<%=show()%>--%>
        <%@include file="assist/include.jsp" %>
        <%@include file="assist/date.jsp" %>
        <%@taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <li>
            行为(动作)元素< jsp:action_name attribute="value" />
        </li>
        <ol type="1">
            <li>
                < jsp:include page="relative URL" flush="true" / >在页面被请求的时候引入一个文件。
            </li>
            <p>
                <%--前面已经介绍过include指令，它是在JSP文件被转换成Servlet的时候引入文件，而这里的jsp:include动作不同，插入文件的时间是在页面被请求的时候。--%>
                <jsp:include page="assist/include.jsp" flush="true"/>
                <jsp:include page="assist/date.jsp" flush="true"/>
            </p>

            <li>
                < jsp:useBean/ >,< jsp:setProperty/ >,< jsp:getProperty/>
                寻找或者实例化一个JavaBean。设置JavaBean的属性。输出某个JavaBean的属性。
            </li>
            <jsp:useBean id="test" class="com.notreami.student2.assist.TestBean" scope="page">
                <jsp:setProperty name="test" property="message" value="Hello JSP..."/>
                <input type="hidden" name="TheAge">
                <jsp:setProperty name="test" property="message" param="TheAge"/>
                <p> value用来指定Bean属性的值。。</p>
                <p>param指定用哪个请求参数作为Bean属性的值。。</p>
                <p>用了param 就不能用value属性了</p>
            </jsp:useBean>
            <p>
                <jsp:getProperty name="test" property="message"/>
            <p>

            <li>
                < jsp:forward page="Relative URL" / >把请求转到一个新的页面。
            </li>
            <p>
                <%--<jsp:forward page="assist/date.jsp"/>--%>
                <%--response.sendRedirect()--%>
            </p>

            <li>
                < jsp:plugin >根据浏览器类型为Java插件生成OBJECT或EMBED标记。
            </li>

            <jsp:plugin type="applet" codebase="dirname" code="com.notreami.student2.assist.FirstApplet" width="60"
                        height="80" name="插件">
                <jsp:params>
                    <jsp:param name="fontcolor" value="red"/>
                    <jsp:param name="background" value="black"/>
                </jsp:params>
            </jsp:plugin>

            <li>
                < jsp:element>,< jsp:attribute>,< jsp:body>定义动态XML元素,设置动态定义的XML元素属性。设置动态定义的XML元素内容。
            </li>
            <p>
                <jsp:element name="a">
                <jsp:attribute name="href" trim="true">
                    assist/include.jsp
                </jsp:attribute>
                    <jsp:body>
                        超链接
                    </jsp:body>
                </jsp:element>
            </p>

            <li>
                < jsp:text >Template data< /jsp:text >在JSP页面和文档中使用写入文本的模板
            </li>
            <p>
                <jsp:text>文本和EL表达式</jsp:text>
            </p>
        </ol>
    </ol>
    <li>JSP内置对象</li>
    <li>JavaBean</li>
    <li>Servlet</li>
    <li>JSP实用组件</li>
    <li>JSP数据库</li>
    <li>Ajax,EL,JSTL</li>
    <li>综合开发实例</li>
    <ul type="disc">
        <li><a href="">个人博客</a></li>
        <li><a href="">在线投票系统</a></li>
        <li><a href="">无刷新的聊天室</a></li>
    </ul>
</ol>
</body>
</html>
