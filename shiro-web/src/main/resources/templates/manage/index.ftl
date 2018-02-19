<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | 商业仪表盘</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <#include "${request.contextPath}/manage/common/css.ftl"/>
    <!-- jvectormap -->
    <link rel="stylesheet" href="/manage/css/jquery-jvectormap.css"/>
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
                BI 仪表盘
                <small>Version 2.0</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">仪表盘</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box">
                        <span class="info-box-icon bg-aqua"><i class="ion ion-ios-gear-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">CPU 占用率</span>
                            <span class="info-box-number">90<small>%</small></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box">
                        <span class="info-box-icon bg-red"><i class="fa fa-google-plus"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">喜欢</span>
                            <span class="info-box-number">41,410</span>
                        </div>
                    </div>
                </div>
                <div class="clearfix visible-sm-block"></div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box">
                        <span class="info-box-icon bg-green"><i class="ion ion-ios-cart-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">销售</span>
                            <span class="info-box-number">760</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box">
                        <span class="info-box-icon bg-yellow"><i class="ion ion-ios-people-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">新成员</span>
                            <span class="info-box-number">2,000</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">月度统计报告</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-box-tool dropdown-toggle"
                                            data-toggle="dropdown">
                                        <i class="fa fa-wrench"></i></button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">操作</a></li>
                                        <li><a href="#">其他操作</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">分离链接</a></li>
                                    </ul>
                                </div>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                        class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-8">
                                    <p class="text-center">
                                        <strong>销售数据: 2017.1.1 - 2017.7.30</strong>
                                    </p>
                                    <div class="chart">
                                        <canvas id="salesChart" style="height: 180px;"></canvas>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <p class="text-center">
                                        <strong>目标完成</strong>
                                    </p>
                                    <div class="progress-group">
                                        <span class="progress-text">加入购物车</span>
                                        <span class="progress-number"><b>160</b>/200</span>
                                        <div class="progress sm">
                                            <div class="progress-bar progress-bar-aqua" style="width: 80%"></div>
                                        </div>
                                    </div>
                                    <div class="progress-group">
                                        <span class="progress-text">完成购买</span>
                                        <span class="progress-number"><b>310</b>/400</span>
                                        <div class="progress sm">
                                            <div class="progress-bar progress-bar-red" style="width: 80%"></div>
                                        </div>
                                    </div>
                                    <div class="progress-group">
                                        <span class="progress-text">访问详细页面</span>
                                        <span class="progress-number"><b>480</b>/800</span>
                                        <div class="progress sm">
                                            <div class="progress-bar progress-bar-green" style="width: 80%"></div>
                                        </div>
                                    </div>
                                    <div class="progress-group">
                                        <span class="progress-text">查询产品</span>
                                        <span class="progress-number"><b>250</b>/500</span>
                                        <div class="progress sm">
                                            <div class="progress-bar progress-bar-yellow" style="width: 80%"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <div class="row">
                                <div class="col-sm-3 col-xs-6">
                                    <div class="description-block border-right">
                                        <span class="description-percentage text-green"><i class="fa fa-caret-up"></i> 17%</span>
                                        <h5 class="description-header">$35,210.43</h5>
                                        <span class="description-text">总收入</span>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="description-block border-right">
                                        <span class="description-percentage text-yellow"><i
                                                class="fa fa-caret-left"></i> 0%</span>
                                        <h5 class="description-header">$10,390.90</h5>
                                        <span class="description-text">总成本</span>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="description-block border-right">
                                        <span class="description-percentage text-green"><i class="fa fa-caret-up"></i> 20%</span>
                                        <h5 class="description-header">$24,813.53</h5>
                                        <span class="description-text">总利润</span>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="description-block">
                                        <span class="description-percentage text-red"><i class="fa fa-caret-down"></i> 18%</span>
                                        <h5 class="description-header">1200</h5>
                                        <span class="description-text">目标完成</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">访客报告</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                        class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-9 col-sm-8">
                                    <div class="pad">
                                        <div id="world-map-markers" style="height: 325px;"></div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-4">
                                    <div class="pad box-pane-right bg-green" style="min-height: 280px">
                                        <div class="description-block margin-bottom">
                                            <div class="sparkbar pad" data-color="#fff">90,70,90,70,75,80,70</div>
                                            <h5 class="description-header">8390</h5>
                                            <span class="description-text">访客</span>
                                        </div>
                                        <div class="description-block margin-bottom">
                                            <div class="sparkbar pad" data-color="#fff">90,50,90,70,61,83,63</div>
                                            <h5 class="description-header">30%</h5>
                                            <span class="description-text">介绍人</span>
                                        </div>
                                        <div class="description-block">
                                            <div class="sparkbar pad" data-color="#fff">90,50,90,70,61,83,63</div>
                                            <h5 class="description-header">70%</h5>
                                            <span class="description-text">有机</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="box box-warning direct-chat direct-chat-warning">
                                <div class="box-header with-border">
                                    <h3 class="box-title">聊天界面</h3>
                                    <div class="box-tools pull-right">
                                        <span data-toggle="tooltip" title="3 New Messages"
                                              class="badge bg-yellow">3</span>
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-toggle="tooltip"
                                                title="Contacts"
                                                data-widget="chat-pane-toggle">
                                            <i class="fa fa-comments"></i></button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                                class="fa fa-times"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="direct-chat-messages">
                                        <div class="direct-chat-msg">
                                            <div class="direct-chat-info clearfix">
                                                <span class="direct-chat-name pull-left">Alexander Pierce</span>
                                                <span class="direct-chat-timestamp pull-right">23 Jan 2:00 pm</span>
                                            </div>
                                            <img class="direct-chat-img" src="manage/images/user1-128x128.jpg"
                                                 alt="message user image">
                                            <div class="direct-chat-text">
                                                Is this template really for free? That's unbelievable!
                                            </div>
                                        </div>
                                        <div class="direct-chat-msg right">
                                            <div class="direct-chat-info clearfix">
                                                <span class="direct-chat-name pull-right">Sarah Bullock</span>
                                                <span class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span>
                                            </div>
                                            <img class="direct-chat-img" src="manage/images/user3-128x128.jpg"
                                                 alt="message user image">
                                            <div class="direct-chat-text">
                                                You better believe it!
                                            </div>
                                        </div>
                                        <div class="direct-chat-msg">
                                            <div class="direct-chat-info clearfix">
                                                <span class="direct-chat-name pull-left">Alexander Pierce</span>
                                                <span class="direct-chat-timestamp pull-right">23 Jan 5:37 pm</span>
                                            </div>
                                            <img class="direct-chat-img" src="manage/images/user1-128x128.jpg"
                                                 alt="message user image">
                                            <div class="direct-chat-text">
                                                Working with AdminLTE on a great new app! Wanna join?
                                            </div>
                                        </div>
                                        <div class="direct-chat-msg right">
                                            <div class="direct-chat-info clearfix">
                                                <span class="direct-chat-name pull-right">Sarah Bullock</span>
                                                <span class="direct-chat-timestamp pull-left">23 Jan 6:10 pm</span>
                                            </div>
                                            <img class="direct-chat-img" src="manage/images/user3-128x128.jpg"
                                                 alt="message user image">
                                            <div class="direct-chat-text">
                                                I would love to.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="direct-chat-contacts">
                                        <ul class="contacts-list">
                                            <li>
                                                <a href="#">
                                                    <img class="contacts-list-img" src="manage/images/user1-128x128.jpg"
                                                         alt="User Image">
                                                    <div class="contacts-list-info">
                                <span class="contacts-list-name">
                                  Count Dracula
                                  <small class="contacts-list-date pull-right">2/28/2015</small>
                                </span>
                                                        <span class="contacts-list-msg">How have you been? I was...</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img class="contacts-list-img" src="manage/images/user7-128x128.jpg"
                                                         alt="User Image">
                                                    <div class="contacts-list-info">
                                <span class="contacts-list-name">
                                  Sarah Doe
                                  <small class="contacts-list-date pull-right">2/23/2015</small>
                                </span>
                                                        <span class="contacts-list-msg">I will be waiting for...</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img class="contacts-list-img" src="manage/images/user3-128x128.jpg"
                                                         alt="User Image">
                                                    <div class="contacts-list-info">
                                <span class="contacts-list-name">
                                  Nadia Jolie
                                  <small class="contacts-list-date pull-right">2/20/2015</small>
                                </span>
                                                        <span class="contacts-list-msg">I'll call you back at...</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img class="contacts-list-img" src="manage/images/user5-128x128.jpg"
                                                         alt="User Image">
                                                    <div class="contacts-list-info">
                                <span class="contacts-list-name">
                                  Nora S. Vans
                                  <small class="contacts-list-date pull-right">2/10/2015</small>
                                </span>
                                                        <span class="contacts-list-msg">Where is your new...</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img class="contacts-list-img" src="manage/images/user6-128x128.jpg"
                                                         alt="User Image">
                                                    <div class="contacts-list-info">
                                <span class="contacts-list-name">
                                  John K.
                                  <small class="contacts-list-date pull-right">1/27/2015</small>
                                </span>
                                                        <span class="contacts-list-msg">Can I take a look at...</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <img class="contacts-list-img" src="manage/images/user8-128x128.jpg"
                                                         alt="User Image">
                                                    <div class="contacts-list-info">
                                <span class="contacts-list-name">
                                  Kenneth M.
                                  <small class="contacts-list-date pull-right">1/4/2015</small>
                                </span>
                                                        <span class="contacts-list-msg">Never mind I found...</span>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="box-footer">
                                    <form action="#" method="post">
                                        <div class="input-group">
                                            <input type="text" name="message" placeholder="输入信息..."
                                                   class="form-control">
                                            <span class="input-group-btn">
                            <button type="button" class="btn btn-warning btn-flat">发送</button>
                          </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="box box-danger">
                                <div class="box-header with-border">
                                    <h3 class="box-title">最近登录的用户</h3>
                                    <div class="box-tools pull-right">
                                        <span class="label label-danger">8 个新用户</span>
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                                class="fa fa-times"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <ul class="users-list clearfix">
                                        <li>
                                            <img src="manage/images/user1-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Alexander Pierce</a>
                                            <span class="users-list-date">今天</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user8-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Norman</a>
                                            <span class="users-list-date">昨天</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user7-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Jane</a>
                                            <span class="users-list-date">12 Jan</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user6-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">John</a>
                                            <span class="users-list-date">6月12日</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user2-160x160.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Alexander</a>
                                            <span class="users-list-date">6月13日</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user5-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Sarah</a>
                                            <span class="users-list-date">14 Jan</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user4-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Nora</a>
                                            <span class="users-list-date">6月15日</span>
                                        </li>
                                        <li>
                                            <img src="manage/images/user3-128x128.jpg" alt="User Image">
                                            <a class="users-list-name" href="#">Nadia</a>
                                            <span class="users-list-date">6月15日</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="box-footer text-center">
                                    <a href="javascript:void(0)" class="uppercase">查看所有用户</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">最新订单</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                        class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="table-responsive">
                                <table class="table no-margin">
                                    <thead>
                                    <tr>
                                        <th>订单 ID</th>
                                        <th>细节</th>
                                        <th>状态</th>
                                        <th>测评</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR9842</a></td>
                                        <td>Call of Duty IV</td>
                                        <td><span class="label label-success">Shipped</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#00a65a" data-height="20">
                                                90,80,90,-70,61,-83,63
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR1848</a></td>
                                        <td>Samsung Smart TV</td>
                                        <td><span class="label label-warning">Pending</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#f39c12" data-height="20">
                                                90,80,-90,70,61,-83,68
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR7429</a></td>
                                        <td>iPhone 6 Plus</td>
                                        <td><span class="label label-danger">Delivered</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#f56954" data-height="20">
                                                90,-80,90,70,-61,83,63
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR7429</a></td>
                                        <td>Samsung Smart TV</td>
                                        <td><span class="label label-info">Processing</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#00c0ef" data-height="20">
                                                90,80,-90,70,-61,83,63
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR1848</a></td>
                                        <td>Samsung Smart TV</td>
                                        <td><span class="label label-warning">Pending</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#f39c12" data-height="20">
                                                90,80,-90,70,61,-83,68
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR7429</a></td>
                                        <td>iPhone 6 Plus</td>
                                        <td><span class="label label-danger">Delivered</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#f56954" data-height="20">
                                                90,-80,90,70,-61,83,63
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="pages/examples/invoice.html">OR9842</a></td>
                                        <td>Call of Duty IV</td>
                                        <td><span class="label label-success">Shipped</span></td>
                                        <td>
                                            <div class="sparkbar" data-color="#00a65a" data-height="20">
                                                90,80,90,-70,61,-83,63
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="box-footer clearfix">
                            <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">下订单</a>
                            <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">查看所有订单</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="ion ion-ios-pricetag-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">库存</span>
                            <span class="info-box-number">5,200</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 50%"></div>
                            </div>
                            <span class="progress-description">
                    50% Increase in 30 Days
                  </span>
                        </div>
                    </div>
                    <div class="info-box bg-green">
                        <span class="info-box-icon"><i class="ion ion-ios-heart-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">涉及</span>
                            <span class="info-box-number">92,050</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 20%"></div>
                            </div>
                            <span class="progress-description">
                    20% Increase in 30 Days
                  </span>
                        </div>
                    </div>
                    <div class="info-box bg-red">
                        <span class="info-box-icon"><i class="ion ion-ios-cloud-download-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">下载</span>
                            <span class="info-box-number">114,381</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 70%"></div>
                            </div>
                            <span class="progress-description">
                    70% Increase in 30 Days
                  </span>
                        </div>
                    </div>
                    <div class="info-box bg-aqua">
                        <span class="info-box-icon"><i class="ion-ios-chatbubble-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">消息</span>
                            <span class="info-box-number">163,921</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: 40%"></div>
                            </div>
                            <span class="progress-description">
                    40% Increase in 30 Days
                  </span>
                        </div>
                    </div>
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">浏览器占比</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                        class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="chart-responsive">
                                        <canvas id="pieChart" height="150"></canvas>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <ul class="chart-legend clearfix">
                                        <li><i class="fa fa-circle-o text-red"></i> Chrome</li>
                                        <li><i class="fa fa-circle-o text-green"></i> IE</li>
                                        <li><i class="fa fa-circle-o text-yellow"></i> FireFox</li>
                                        <li><i class="fa fa-circle-o text-aqua"></i> Safari</li>
                                        <li><i class="fa fa-circle-o text-light-blue"></i> Opera</li>
                                        <li><i class="fa fa-circle-o text-gray"></i> Navigator</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer no-padding">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">美国
                                    <span class="pull-right text-red"><i class="fa fa-angle-down"></i> 12%</span></a>
                                </li>
                                <li><a href="#">意大利 <span class="pull-right text-green"><i class="fa fa-angle-up"></i> 4%</span></a>
                                </li>
                                <li><a href="#">中国
                                    <span class="pull-right text-yellow"><i class="fa fa-angle-left"></i> 0%</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">最近添加的产品</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                        class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <ul class="products-list product-list-in-box">
                                <li class="item">
                                    <div class="product-img">
                                        <img src="manage/images/default-50x50.gif" alt="Product Image">
                                    </div>
                                    <div class="product-info">
                                        <a href="javascript:void(0)" class="product-title">Samsung TV
                                            <span class="label label-warning pull-right">$1800</span></a>
                                        <span class="product-description">
                          Samsung 32" 1080p 60Hz LED Smart HDTV.
                        </span>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="product-img">
                                        <img src="manage/images/default-50x50.gif" alt="Product Image">
                                    </div>
                                    <div class="product-info">
                                        <a href="javascript:void(0)" class="product-title">自行车
                                            <span class="label label-info pull-right">$700</span></a>
                                        <span class="product-description">
                          26" Mongoose Dolomite Men's 7-speed, Navy Blue.
                        </span>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="product-img">
                                        <img src="manage/images/default-50x50.gif" alt="Product Image">
                                    </div>
                                    <div class="product-info">
                                        <a href="javascript:void(0)" class="product-title">Xbox One <span
                                                class="label label-danger pull-right">$350</span></a>
                                        <span class="product-description">
                          Xbox One Console Bundle with Halo Master Chief Collection.
                        </span>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="product-img">
                                        <img src="manage/images/default-50x50.gif" alt="Product Image">
                                    </div>
                                    <div class="product-info">
                                        <a href="javascript:void(0)" class="product-title">PlayStation 4
                                            <span class="label label-success pull-right">$399</span></a>
                                        <span class="product-description">
                          PlayStation 4 500GB Console (PS4)
                        </span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="box-footer text-center">
                            <a href="javascript:void(0)" class="uppercase">查看所有产品</a>
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
<!-- Sparkline -->
<script src="/manage/js/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/manage/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/manage/js/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll -->
<script src="/manage/js/jquery.slimscroll.min.js"></script>
<!-- ChartJS -->
<script src="/manage/js/Chart.js"></script>
<script src="/manage/js/dashboard.js"></script>
</body>
</html>