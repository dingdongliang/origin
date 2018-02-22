<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | 500 Error</title>

  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      <#include "${request.contextPath}/manage/common/css.ftl"/>
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
        500 Error Page
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">500 error</li>
      </ol>
    </section>


    <section class="content">

      <div class="error-page">
        <h2 class="headline text-red">500</h2>

        <div class="error-content">
          <h3><i class="fa fa-warning text-red"></i> Oops! Something went wrong.</h3>

          <p>
            We will work on fixing that right away.
            Meanwhile, you may <a href="/index">return to dashboard</a> or try using the search form.
          </p>

          <form class="search-form">
            <div class="input-group">
              <input type="text" name="search" class="form-control" placeholder="Search">

              <div class="input-group-btn">
                <button type="submit" name="submit" class="btn btn-danger btn-flat"><i class="fa fa-search"></i>
                </button>
              </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
      </div>
      <!-- /.error-page -->

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
</body>
</html>
