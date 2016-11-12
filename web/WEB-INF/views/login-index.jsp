
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel='shortcut icon' type='image/x-icon' href='../favicon.ico' />

    <title>WIS - Login</title>

    <link href="static/css/metro.min.css" rel="stylesheet">
    <link href="static/css/metro-icons.min.css" rel="stylesheet">
    <link href="static/css/metro-responsive.min.css" rel="stylesheet">

    <script src="static/js/jquery-2.2.4.min.js"></script>
    <script src="static/js/metro.min.js"></script>
 
    <style>
        .login-form {
            width: 25rem;
            height: 18.75rem;
            position: fixed;
            top: 50%;
            margin-top: -9.375rem;
            left: 50%;
            margin-left: -12.5rem;
            background-color: #ffffff;
            opacity: 0;
            -webkit-transform: scale(.8);
            transform: scale(.8);
        }
    </style>

    <script>
        $(function(){
            var form = $(".login-form");

            form.css({
                opacity: 1,
                "-webkit-transform": "scale(1)",
                "transform": "scale(1)",
                "-webkit-transition": ".5s",
                "transition": ".5s"
            });
        });
    </script>
</head>
<body class="bg-darkTeal">
    <div class="login-form padding20 block-shadow">
        <form action="validate" method="post">
            <h1 class="text-light">Login to WIS</h1>
            <hr class="thin"/>
            <br />
            <div class="input-control text full-size" data-role="input">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" required>
                <button class="button helper-button clear"><span class="mif-cross"></span></button>
            </div>
            <br />
            <br />
            <div class="input-control password full-size" data-role="input">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" required>
                <button class="button helper-button reveal"><span class="mif-looks"></span></button>
            </div>
            <br />
            <br />
            <div class="form-actions">
                <button type="submit" class="button primary">Login</button>
            </div>
        </form>
    </div>
</body>
</html>