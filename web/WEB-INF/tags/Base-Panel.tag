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
        <!-- Stylesheet -->
        <link href="static/css/metro.min.css" rel="stylesheet">
        <link href="static/css/metro-schemes.min.css" rel="stylesheet">
        <link href="static/css/metro-icons.min.css" rel="stylesheet">
        <link href="static/css/metro-responsive.min.css" rel="stylesheet">
        <link href="static/css/metro-colors.min.css" rel="stylesheet">

        <!-- JS -->
        <script src="static/js/jquery-2.2.4.min.js"></script>
        <script src="static/js/metro.min.js"></script>
        
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
        <div class="app-bar fixed-top darcula" data-role="appbar">
            <a class="app-bar-element branding" href="cpanel"><span class="mif-user-md mif-2x" style="height: 36px; display: inline-block;"></span>&nbsp;</a>
            <span class="app-bar-divider"></span>
            <ul class="app-bar-menu">
                <li><a href="cpanel">Dashboard</a></li>
                <li>
                    <a href="" class="dropdown-toggle">Users</a>
                    <ul class="d-menu" data-role="dropdown">
                    <li><a href="">New user</a></li>
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
            </ul>
            <div class="app-bar-element place-right">
                <span class="dropdown-toggle"><span class="mif-cog" style="margin-right: 5px"></span> ${username}</span>
            <div class="app-bar-drop-container padding10 place-right no-margin-top block-shadow fg-white1" data-role="dropdown" data-no-close="true" style="width: 220px">
                <h2 class="text-light">Quick settings</h2>
                <ul class="unstyled-list fg-dark">
                    <li><a href="settings" class="fg-white1 fg-hover-yellow">Settings</a></li>
                    <li><a href="logout" class="fg-white2 fg-hover-yellow">Logout</a></li>
                </ul>
            </div>
            </div>
        </div> 
        
        <!-- Body -->
        <div class="page-content">
            <div class="flex-grid" style="height: 100%">
                <div class="row" style="height: 100%;">
                    <div class="cell size-p20" id="cell-sidebar">
                        <ul class="sidebar2 dark" style="height: 100%; background-color: #3c3f41; min-width: 100%">
                            <li class="active"><a href="#"><span class="mif-home icon"></span>Dashboard</a></li>
                            <li class="stick"><a href="lolol"><span class="mif-cog icon"></span>Layouts</a></li>
                            <li class="stick">
                                <a class="dropdown-toggle" href="#"><span class="mif-tree icon"></span>Sub menu</a>
                                <ul class="d-menu" data-role="dropdown">
                                    <li><a href=""><span class="mif-vpn-publ icon"></span> Subitem 1</a></li>
                                    <li><a href="">Subitem 2</a></li>
                                    <li><a href="">Subitem 3</a></li>
                                    <li><a href="">Subitem 4</a></li>
                                    <li class="disabled"><a href="">Subitem 5</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="cell auto-size" id="cell-content">
                        <div class="padding20">
                            <jsp:doBody/>  
                        </div>
                    </div>
                </div>               
            </div>
        </div>
    </body>
    <tags:flash-message/>
</html>