<%@tag description="Base Panel" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <title>${title}</title>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Stylesheet -->
        <link href="static/css/metro.min.css" rel="stylesheet">
        <link href="static/css/metro-schemes.min.css" rel="stylesheet">
        <link href="static/css/metro-icons.min.css" rel="stylesheet">
        <link href="static/css/metro-responsive.min.css" rel="stylesheet">
        <link href="static/css/metro-colors.min.css" rel="stylesheet">

        <!-- JS -->
        <script src="static/js/jquery-2.2.4.min.js"></script>
        <script src="static/js/metro.min.js"></script>
    </head>
    
    <body style="margin-top: 50px">
        <div class="app-bar fixed-top darcula" data-role="appbar">
            <a class="app-bar-element branding" href="cpanel"><span class="mif-user-md mif-2x" style="height: 36px; display: inline-block;"></span>&nbsp;</a>
            <span class="app-bar-divider"></span>
            <ul class="app-bar-menu">
                <li><a href="cpanel">Dashboard</a></li>
                <li>
                    <a href="" class="dropdown-toggle">Project</a>
                    <ul class="d-menu" data-role="dropdown">
                    <li><a href="">New project</a></li>
                    <li class="divider"></li>
                    <li>
                        <a href="" class="dropdown-toggle">Reopen</a>
                        <ul class="d-menu" data-role="dropdown">
                            <li><a href="">Project 1</a></li>
                            <li><a href="">Project 2</a></li>
                            <li><a href="">Project 3</a></li>
                            <li class="divider"></li>
                            <li><a href="">Clear list</a></li>
                        </ul>
                    </li>
                </ul>
                </li>
        </div> 
        
        <!-- Body -->
        <div class="page-content">
            <div class="flex-grid ribbed-cobalt" style="height: 100%">
                <jsp:doBody/>                
            </div>
        </div>
    </body>
    <tags:flash-message/>
</html>