<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Advanced form elements</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <#include "${request.contextPath}/manage/common/css.ftl"/>
    <!-- daterange picker -->
    <link rel="stylesheet" href="${request.contextPath}/manage/css/daterangepicker.css"/>
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="${request.contextPath}/manage/css/bootstrap-datepicker.min.css"/>
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="${request.contextPath}/manage/iCheck/all.css"/>
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet" href="${request.contextPath}/manage/css/bootstrap-colorpicker.min.css"/>
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet" href="${request.contextPath}/manage/css/bootstrap-timepicker.min.css"/>
    <!-- Select2 -->
    <link rel="stylesheet" href="${request.contextPath}/manage/css/select2.min.css"/>
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
                Advanced Form Elements
                <small>Preview</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Forms</a></li>
                <li class="active">Advanced Elements</li>
            </ol>
        </section>


        <section class="content">

            <!-- SELECT2 EXAMPLE -->
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">Select2</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i></button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i>
                        </button>
                    </div>
                </div>

                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Minimal</label>
                                <select class="form-control select2" style="width: 100%;">
                                    <option selected="selected">Alabama</option>
                                    <option>Alaska</option>
                                    <option>California</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Disabled</label>
                                <select class="form-control select2" disabled="disabled" style="width: 100%;">
                                    <option selected="selected">Alabama</option>
                                    <option>Alaska</option>
                                    <option>California</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div>
                            <!-- /.form-group -->
                        </div>

                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Multiple</label>
                                <select class="form-control select2" multiple="multiple"
                                        data-placeholder="Select a State"
                                        style="width: 100%;">
                                    <option>Alabama</option>
                                    <option>Alaska</option>
                                    <option>California</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Disabled Result</label>
                                <select class="form-control select2" style="width: 100%;">
                                    <option selected="selected">Alabama</option>
                                    <option>Alaska</option>
                                    <option disabled="disabled">California (disabled)</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div>
                            <!-- /.form-group -->
                        </div>

                    </div>

                </div>

                <div class="box-footer">
                    Visit <a href="https://select2.github.io/">Select2 documentation</a> for more examples and
                    information about
                    the plugin.
                </div>
            </div>


            <div class="row">
                <div class="col-md-6">

                    <div class="box box-danger">
                        <div class="box-header">
                            <h3 class="box-title">Input masks</h3>
                        </div>
                        <div class="box-body">
                            <!-- Date dd/mm/yyyy -->
                            <div class="form-group">
                                <label>Date masks:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'"
                                           data-mask>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- Date mm/dd/yyyy -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask="'alias': 'mm/dd/yyyy'"
                                           data-mask>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- phone mask -->
                            <div class="form-group">
                                <label>US phone mask:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask='"mask": "(999) 999-9999"'
                                           data-mask>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- phone mask -->
                            <div class="form-group">
                                <label>Intl US phone mask:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <input type="text" class="form-control"
                                           data-inputmask="'mask': ['999-999-9999 [x99999]', '+099 99 99 9999[9]-9999']"
                                           data-mask>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- IP mask -->
                            <div class="form-group">
                                <label>IP mask:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-laptop"></i>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask="'alias': 'ip'" data-mask>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                        </div>

                    </div>


                    <div class="box box-info">
                        <div class="box-header">
                            <h3 class="box-title">Color & Time Picker</h3>
                        </div>
                        <div class="box-body">
                            <!-- Color Picker -->
                            <div class="form-group">
                                <label>Color picker:</label>
                                <input type="text" class="form-control my-colorpicker1">
                            </div>
                            <!-- /.form group -->

                            <!-- Color Picker -->
                            <div class="form-group">
                                <label>Color picker with addon:</label>

                                <div class="input-group my-colorpicker2">
                                    <input type="text" class="form-control">

                                    <div class="input-group-addon">
                                        <i></i>
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- time Picker -->
                            <div class="bootstrap-timepicker">
                                <div class="form-group">
                                    <label>Time picker:</label>

                                    <div class="input-group">
                                        <input type="text" class="form-control timepicker">

                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                                <!-- /.form group -->
                            </div>
                        </div>

                    </div>


                </div>

                <div class="col-md-6">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Date picker</h3>
                        </div>
                        <div class="box-body">
                            <!-- Date -->
                            <div class="form-group">
                                <label>Date:</label>

                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right" id="datepicker">
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- Date range -->
                            <div class="form-group">
                                <label>Date range:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right" id="reservation">
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- Date and time range -->
                            <div class="form-group">
                                <label>Date and time range:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-clock-o"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right" id="reservationtime">
                                </div>
                                <!-- /.input group -->
                            </div>
                            <!-- /.form group -->

                            <!-- Date and time range -->
                            <div class="form-group">
                                <label>Date range button:</label>

                                <div class="input-group">
                                    <button type="button" class="btn btn-default pull-right" id="daterange-btn">
                    <span>
                      <i class="fa fa-calendar"></i> Date range picker
                    </span>
                                        <i class="fa fa-caret-down"></i>
                                    </button>
                                </div>
                            </div>
                            <!-- /.form group -->

                        </div>

                    </div>


                    <!-- iCheck -->
                    <div class="box box-success">
                        <div class="box-header">
                            <h3 class="box-title">iCheck - Checkbox &amp; Radio Inputs</h3>
                        </div>
                        <div class="box-body">
                            <!-- Minimal style -->

                            <!-- checkbox -->
                            <div class="form-group">
                                <label>
                                    <input type="checkbox" class="minimal" checked>
                                </label>
                                <label>
                                    <input type="checkbox" class="minimal">
                                </label>
                                <label>
                                    <input type="checkbox" class="minimal" disabled>
                                    Minimal skin checkbox
                                </label>
                            </div>

                            <!-- radio -->
                            <div class="form-group">
                                <label>
                                    <input type="radio" name="r1" class="minimal" checked>
                                </label>
                                <label>
                                    <input type="radio" name="r1" class="minimal">
                                </label>
                                <label>
                                    <input type="radio" name="r1" class="minimal" disabled>
                                    Minimal skin radio
                                </label>
                            </div>

                            <!-- Minimal red style -->

                            <!-- checkbox -->
                            <div class="form-group">
                                <label>
                                    <input type="checkbox" class="minimal-red" checked>
                                </label>
                                <label>
                                    <input type="checkbox" class="minimal-red">
                                </label>
                                <label>
                                    <input type="checkbox" class="minimal-red" disabled>
                                    Minimal red skin checkbox
                                </label>
                            </div>

                            <!-- radio -->
                            <div class="form-group">
                                <label>
                                    <input type="radio" name="r2" class="minimal-red" checked>
                                </label>
                                <label>
                                    <input type="radio" name="r2" class="minimal-red">
                                </label>
                                <label>
                                    <input type="radio" name="r2" class="minimal-red" disabled>
                                    Minimal red skin radio
                                </label>
                            </div>

                            <!-- Minimal red style -->

                            <!-- checkbox -->
                            <div class="form-group">
                                <label>
                                    <input type="checkbox" class="flat-red" checked>
                                </label>
                                <label>
                                    <input type="checkbox" class="flat-red">
                                </label>
                                <label>
                                    <input type="checkbox" class="flat-red" disabled>
                                    Flat green skin checkbox
                                </label>
                            </div>

                            <!-- radio -->
                            <div class="form-group">
                                <label>
                                    <input type="radio" name="r3" class="flat-red" checked>
                                </label>
                                <label>
                                    <input type="radio" name="r3" class="flat-red">
                                </label>
                                <label>
                                    <input type="radio" name="r3" class="flat-red" disabled>
                                    Flat green skin radio
                                </label>
                            </div>
                        </div>

                        <div class="box-footer">
                            Many more skins available. <a href="http://fronteed.com/iCheck/">Documentation</a>
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
<!-- Select2 -->
<script src="${request.contextPath}/manage/js/select2.full.min.js"></script>
<!-- InputMask -->
<script src="${request.contextPath}/manage/js/jquery.inputmask.js"></script>
<script src="${request.contextPath}/manage/js/jquery.inputmask.date.extensions.js"></script>
<script src="${request.contextPath}/manage/js/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="${request.contextPath}/manage/js/momentad.js"></script>
<script src="${request.contextPath}/manage/js/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="${request.contextPath}/manage/js/bootstrap-datepicker.min.js"></script>
<!-- bootstrap color picker -->
<script src="${request.contextPath}/manage/js/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="${request.contextPath}/manage/js/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll -->
<script src="${request.contextPath}/manage/js/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="${request.contextPath}/manage/iCheck/icheck.min.js"></script>
<!-- Page script -->
<script>
    $(function () {
        //Initialize Select2 Elements
        $('.select2').select2()

        //Datemask dd/mm/yyyy
        $('#datemask').inputmask('dd/mm/yyyy', {'placeholder': 'dd/mm/yyyy'})
        //Datemask2 mm/dd/yyyy
        $('#datemask2').inputmask('mm/dd/yyyy', {'placeholder': 'mm/dd/yyyy'})
        //Money Euro
        $('[data-mask]').inputmask()

        //Date range picker
        $('#reservation').daterangepicker()
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'})
        //Date range as a button
        $('#daterange-btn').daterangepicker(
                {
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment()
                },
                function (start, end) {
                    $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
                }
        )

        //Date picker
        $('#datepicker').datepicker({
            autoclose: true
        })

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        })
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
            checkboxClass: 'icheckbox_minimal-red',
            radioClass: 'iradio_minimal-red'
        })
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        })

        //Colorpicker
        $('.my-colorpicker1').colorpicker()
        //color picker with addon
        $('.my-colorpicker2').colorpicker()

        //Timepicker
        $('.timepicker').timepicker({
            showInputs: false
        })
    })
</script>
</body>
</html>
