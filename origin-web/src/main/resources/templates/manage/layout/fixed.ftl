<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Fixed Layout</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <#include "${request.contextPath}/manage/common/css.ftl"/>
</head>
<!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
<!-- the fixed layout is not compatible with sidebar-mini -->
<body class="hold-transition skin-blue fixed sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <header class="main-header">
        <#include "${request.contextPath}/manage/common/head.ftl"/>
    </header>

    <!-- =============================================== -->

    <!-- Left side column. contains the sidebar -->
    <aside class="main-sidebar">
        <#include "${request.contextPath}/manage/common/menu.ftl"/>
    </aside>

    <!-- =============================================== -->


    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                Fixed Layout
                <small>Blank example to the fixed layout</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Layout</a></li>
                <li class="active">Fixed</li>
            </ol>
        </section>


        <section class="content">
            <div class="callout callout-info">
                <h4>Tip!</h4>

                <p>Add the fixed class to the body tag to get this layout. The fixed layout is your best option if your
                    sidebar
                    is bigger than your content because it prevents extra unwanted scrolling.</p>
            </div>
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">Title</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                                title="Collapse">
                            <i class="fa fa-minus"></i></button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip"
                                title="Remove">
                            <i class="fa fa-times"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    Start creating your amazing application!
                </div>

                <div class="box-footer">
                    Footer
                </div>

            </div>


        </section>

    </div>


    <footer class="main-footer">
        <#include "${request.contextPath}/manage/common/foot.ftl"/>
    </footer>


    <aside class="control-sidebar control-sidebar-dark">
        <#include "${request.contextPath}/manage/common/setting.ftl"/>
    </aside>


    <div class="control-sidebar-bg"></div>
</div>


<#include "${request.contextPath}/manage/common/script.ftl"/>
<script src="${request.contextPath}/manage/js/jquery.slimscroll.min.js"></script>
</body>
</html>
