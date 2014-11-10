<!--匿名用户也可以访问登录页-->
<intercept-url pattern="/login.jsp" access="IS_AUTHENTICATED_ANONYMOUSLY" />

<!--Spring 异常信息-->
${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}

<!--项目根路径-->
${pageContext.request.contextPath}

<!--username的值-->
${sessionScope['SPRING_SECURITY_LAST_USERNAME']}

<!--refresh.jsp 刷新数据库中的用户,角色,权限信息-->
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.FactoryBean"%>
<%@page import="org.springframework.security.web.access.intercept.FilterSecurityInterceptor"%>
<%@page import="org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource"%>
<%
    ApplicationContext ctx =  WebApplicationContextUtils.getWebApplicationContext(application);
    FactoryBean factoryBean = (FactoryBean) ctx.getBean("filterInvocationSecurityMetadataSource");
    FilterInvocationSecurityMetadataSource fids = (FilterInvocationSecurityMetadataSource) factoryBean.getObject();
    FilterSecurityInterceptor filter = (FilterSecurityInterceptor) ctx.getBean("filterSecurityInterceptor");
    filter.setSecurityMetadataSource(fids);
%>
<jsp:forward page="/"/>

<!--Salt加密-->
<password-encoder hash="md5">
    <salt-source user-property="username"/>
</password-encoder>

<!--取得当前的用户信息 Spring Tags-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="name"/>

<!--程序中取得当前用户对象-->
UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
    .getAuthentication()
    .getPrincipal();

<!--取得当前用户的所有权限-->
Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();

<!--403页面访问拒绝信息 ExceptionTranslationFilter.accessDeniedHandler实现-->
${requestScope['SPRING_SECURITY_403_EXCEPTION'].message}


<!--动态资源管理和自定义登录结合-->
数据库中登录页面的权限设置为:IS_AUTHENTICATED_ANONYMOUSLY
INSERT INTO RESC VALUES(1,'','URL','/login.jsp*',1,'');
INSERT INTO ROLE VALUES(3,'IS_AUTHENTICATED_ANONYMOUSLY','anonymous');
INSERT INTO RESC_ROLE VALUES(1,3);

<!--只要用户登录之后就可以访问资源, 而不需要具体的权限信息-->
<intercept-url pattern="/**" access="IS_AUTHENTICATED_FULLY" />

<!--auto-config=true过滤器链详解-->
HttpSessionContextIntegrationFilter:
    1.1 判断用户的session中是否已经存在一个SecurityContext, 存在就放到SecurityContextHolder中
LogoutFilter
    2.1 处理注销请求,默认为/j_spring_security_logout,销毁session,清空SecurityContextHolder
AuthenticationProcessingFilter
    3.1 处理form登录的过滤器,默认路径是/j_spring_security_check
DefaultLoginPageGeneratingFilter
    4.1 用来生成一个默认的登录页面,默认的访问地址为/spring_security_login
BasicProcessingFilter
    5.1 用于进行basic验证
SecurityContextHolderAwareRequestFilter
    6.1 用来包装客户的请求.目的是在原始请求的基础上,为后续程序提供一些额外的数据
RememberMeProcessingFilter
    7.1 实现RememberMe功能,当用户cookie中存在rememberMe的标记,
        此过滤器会根据标记自动实现用户登陆,并创建SecurityContext,授予对应的权限
AnonymousProcessingFilter
    8.1 保证操作统一性,当用户没有登陆时,默认为用户分配匿名用户的权限
ExceptionTranslationFilter
    9.1 处理FilterSecurityInterceptor抛出的异常,然后将请求重定向到对应页面,或返回对应的响应错误代码
SessionFixationProtectionFilter
    10.1 防御会话伪造攻击
FilterSecurityInterceptor
    11.1 用户的权限控制都包含在这个过滤器
        (1)如果用户尚未登录,则抛出AuthenticationCredentialsNotFoundException
        (2)如果用户已登录，但是没有访问当前资源的权限，则抛出AccessDeniedException
        (3)如果用户已登录，也具有访问当前资源的权限，则放行

<!--标签库-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

//获取当前用户名
<sec:authentication property="name"/>

//获得当前用户所有的权限, 把权限列表放到authorities
<sec:authentication property="authorities" var="authorities" scope="page"/>
<c:forEach items="${authorities}" var="authority">
    ${authority.authority}
</c:forEach>

//authorize用来判断当前用户的权限，然后根据指定的条件判断是否显示内部的内容

//所有权限都需要
<sec:authorize ifAllGranted="ROLE_ADMIN,ROLE_USER">
  admin and user
</sec:authorize>

//只要有一个验证通过即可
<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
  admin or user
</sec:authorize>

//当前没有, 则通过
<sec:authorize ifNotGranted="ROLE_ADMIN">
  not admin
</sec:authorize>

//acl/accesscontrollist 用于判断当前用户是否拥有指定的acl权限
<sec:accesscontrollist domainObject="${item}" hasPermission="8,16">
    <a href="message.do?action=remove&id=${item.id}">Remove</a>
</sec:accesscontrollist>

//为不同用户显示各自的登陆成功页面
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize ifAllGranted="ROLE_ADMIN">
  <%response.sendRedirect("admin.jsp");%>
</sec:authorize>
<sec:authorize ifNotGranted="ROLE_ADMIN">
  <%response.sendRedirect("user.jsp");%>
</sec:authorize>