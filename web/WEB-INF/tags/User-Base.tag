<%@tag description="Base Panel" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="username" required="false"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <title>${title}</title>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS -->
        <link href="${pageContext.request.contextPath}/static/css/metro.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/metro-schemes.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/metro-icons.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/metro-responsive.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/metro-colors.min.css" rel="stylesheet">

        <!-- JS -->
        <script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/metro.min.js"></script>
        
        <style>
            html, body {
                height: 100%;
            }
            body {}
            .page-content {
                padding-top: 3.125rem;
                min-height: 100%;
                height: 100%;
            }
            @media screen and (max-width: 800px){
            #cell-sidebar {
                flex-basis: 20%;
            }
        }
        </style>
        
    </head>
    
    <body>
        <div class="app-bar fixed-top" data-role="appbar">
            <a class="app-bar-element branding" href="cpanel"><span class="mif-user-md mif-2x" style="height: 36px; display: inline-block;"></span>&nbsp;</a>
            <span class="app-bar-divider"></span>
            <ul class="app-bar-menu">
                <li><a href="manage">Home</a></li>
                <li><a href="help">Help</a></li>
            </ul>
            <div class="app-bar-element place-right">
                <span class="dropdown-toggle"><span class="mif-cog" style="margin-right: 5px"></span> Welcome, <b>${username}</b></span>
            <div class="app-bar-drop-container padding10 place-right no-margin-top block-shadow fg-white1" data-role="dropdown" data-no-close="true" style="width: 222px">
                <h2 class="text-light fg-dark">Quick Settings</h2>
                <ul class="unstyled-list fg-dark">
                    <li><a href="settings" class="fg-white1 fg-hover-yellow">Settings</a></li>
                    <li><a href="logout" class="fg-white2 fg-hover-yellow">Logout</a></li>
                </ul>
            </div>
            </div>
        </div> 
        
        <!-- Body -->
        <div class="page-content">
            <jsp:doBody/>
        </div>
    </body>
    <tags:flash-message/>
</html>