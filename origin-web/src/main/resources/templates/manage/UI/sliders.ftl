<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | UI Sliders</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <#include "${request.contextPath}/manage/common/css.ftl"/>
    <!-- bootstrap slider -->
    <link rel="stylesheet" href="/manage/css/slider.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <#include "${request.contextPath}/manage/common/head.ftl"/>
    </header>

    <aside class="main-sidebar">
        <#include "${request.contextPath}/manage/common/menu.ftl"/>
    </aside>


    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                Sliders
                <small>range sliders</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">UI</a></li>
                <li class="active">Sliders</li>
            </ol>
        </section>


        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Bootstrap Slider</h3>
                        </div>

                        <div class="box-body">
                            <div class="row margin">
                                <div class="col-sm-6">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="horizontal"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="red">

                                    <p>data-slider-id="red"</p>
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="horizontal"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="blue">

                                    <p>data-slider-id="blue"</p>
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="horizontal"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="green">

                                    <p>data-slider-id="green"</p>
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="horizontal"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="yellow">

                                    <p>data-slider-id="yellow"</p>
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="horizontal"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="aqua">

                                    <p>data-slider-id="aqua"</p>
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="horizontal"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="purple">

                                    <p style="margin-top: 10px">data-slider-id="purple"</p>
                                </div>
                                <div class="col-sm-6 text-center">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="vertical"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="red">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="vertical"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="blue">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="vertical"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="green">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="vertical"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="yellow">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="vertical"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="aqua">
                                    <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                           data-slider-max="200"
                                           data-slider-step="5" data-slider-value="[-100,100]"
                                           data-slider-orientation="vertical"
                                           data-slider-selection="before" data-slider-tooltip="show"
                                           data-slider-id="purple">
                                </div>
                            </div>
                        </div>

                    </div>

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
<!-- Bootstrap slider -->
<script src="/manage/js/bootstrap-slider.js"></script>
<script>
    $(function () {
        /* BOOTSTRAP SLIDER */
        $('.slider').slider()
    })
</script>
</body>
</html>
