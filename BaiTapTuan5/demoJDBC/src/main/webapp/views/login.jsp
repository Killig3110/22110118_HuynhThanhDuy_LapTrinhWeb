<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: killi
  Date: 9/12/2024
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<!-- Head BEGIN -->
<head>
    <meta charset="utf-8">
    <title>Login | Metronic Frontend</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta content="Metronic Shop UI description" name="description">
    <meta content="Metronic Shop UI keywords" name="keywords">
    <meta content="keenthemes" name="author">

    <meta property="og:site_name" content="-CUSTOMER VALUE-">
    <meta property="og:title" content="-CUSTOMER VALUE-">
    <meta property="og:description" content="-CUSTOMER VALUE-">
    <meta property="og:type" content="website">
    <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
    <meta property="og:url" content="-CUSTOMER VALUE-">

    <link rel="shortcut icon" href="favicon.ico">

    <!-- Fonts START -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="../../assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
    <link href="../../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="../../assets/global/css/components.css" rel="stylesheet">
    <link href="../../assets/frontend/layout/css/style.css" rel="stylesheet">
    <link href="../../assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
    <link href="../../assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
    <link href="../../assets/frontend/layout/css/custom.css" rel="stylesheet">
    <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li><a href="#">Pages</a></li>
            <li class="active">Login</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-3">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Login/Register</a></li>
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Restore Password</a></li>
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> My account</a></li>
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Address book</a></li>
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Wish list</a></li>
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Returns</a></li>
                    <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Newsletter</a></li>
                </ul>
            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-9">
                <h1>Login</h1>
                <div class="content-form-page">
                    <div class="row">
                        <div class="col-md-7 col-sm-7">
                            <form action="/login" method="post" class="form-horizontal form-without-legend" role="form">
                                <div class="form-group">
                                    <label for="uname" class="col-lg-4 control-label">User name <span class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" name="username" id="username">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="psw" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" name="password" id="password">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0">
                                        <a href="page-forgotton-password.html">Forget Password?</a>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                        <button type="submit" class="btn btn-primary">Login</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                                        <hr>
                                        <div class="login-socio">
                                            <p class="text-muted">or login using:</p>
                                            <ul class="social-icons">
                                                <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                                <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                                <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                                <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-4 col-sm-4 pull-right">
                            <div class="form-info">
                                <h2><em>Important</em> Information</h2>
                                <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                                <button type="button" class="btn btn-default">More details</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<!-- BEGIN PRE-FOOTER -->
<div class="pre-footer">
    <div class="container">
        <div class="row">
            <!-- BEGIN BOTTOM ABOUT BLOCK -->
            <div class="col-md-4 col-sm-6 pre-footer-col">
                <h2>About us</h2>
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam sit nonummy nibh euismod tincidunt ut laoreet dolore magna aliquarm erat sit volutpat.</p>

                <div class="photo-stream">
                    <h2>Photos Stream</h2>
                    <ul class="list-unstyled">
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/people/img5-small.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img1.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/people/img4-large.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img6.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img3.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/people/img2-large.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img2.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img5.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/people/img5-small.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img1.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/people/img4-large.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img6.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img3.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/people/img2-large.jpg"></a></li>
                        <li><a href="#"><img alt="" src="../../assets/frontend/pages/img/works/img2.jpg"></a></li>
                    </ul>
                </div>
            </div>
            <!-- END BOTTOM ABOUT BLOCK -->

            <!-- BEGIN BOTTOM CONTACTS -->
            <div class="col-md-4 col-sm-6 pre-footer-col">
                <h2>Our Contacts</h2>
                <address class="margin-bottom-40">
                    35, Lorem Lis Street, Park Ave<br>
                    California, US<br>
                    Phone: 300 323 3456<br>
                    Fax: 300 323 1456<br>
                    Email: <a href="mailto:info@metronic.com">info@metronic.com</a><br>
                    Skype: <a href="skype:metronic">metronic</a>
                </address>

                <div class="pre-footer-subscribe-box pre-footer-subscribe-box-vertical">
                    <h2>Newsletter</h2>
                    <p>Subscribe to our newsletter and stay up to date with the latest news and deals!</p>
                    <form action="#">
                        <div class="input-group">
                            <input type="text" placeholder="youremail@mail.com" class="form-control">
                            <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">Subscribe</button>
                  </span>
                        </div>
                    </form>
                </div>
            </div>
            <!-- END BOTTOM CONTACTS -->

            <!-- BEGIN TWITTER BLOCK -->
            <div class="col-md-4 col-sm-6 pre-footer-col">
                <h2 class="margin-bottom-0">Latest Tweets</h2>
                <a class="twitter-timeline" href="https://twitter.com/twitterapi" data-tweet-limit="2" data-theme="dark" data-link-color="#57C8EB" data-widget-id="455411516829736961" data-chrome="noheader nofooter noscrollbar noborders transparent">Loading tweets by @keenthemes...</a>
            </div>
            <!-- END TWITTER BLOCK -->
        </div>
    </div>
</div>
<!-- END PRE-FOOTER -->

<!-- BEGIN FOOTER -->
<div class="footer">
    <div class="container">
        <div class="row">
            <!-- BEGIN COPYRIGHT -->
            <div class="col-md-6 col-sm-6 padding-top-10">
                2014 © Metronic Shop UI. ALL Rights Reserved. <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
            </div>
            <!-- END COPYRIGHT -->
            <!-- BEGIN PAYMENTS -->
            <div class="col-md-6 col-sm-6">
                <ul class="social-footer list-unstyled list-inline pull-right">
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-skype"></i></a></li>
                    <li><a href="#"><i class="fa fa-github"></i></a></li>
                    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="#"><i class="fa fa-dropbox"></i></a></li>
                </ul>
            </div>
            <!-- END PAYMENTS -->
        </div>
    </div>
</div>
<!-- END FOOTER -->

<!-- Load javascripts at bottom, this will reduce page load time -->
<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<![endif]-->
<script src="../../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="../../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
<script src="../../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

<script src="../../assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        Layout.init();
        Layout.initUniform();
        Layout.initTwitter();
    });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>