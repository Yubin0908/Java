<!-- login page -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8>
    <title>Login</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="<?php echo base_url('assets/bootstrap/css/bootstrap.min.css');?>">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<?php echo base_url('assets/dist/css/AdminLTE.min.css');?>">
    <!-- iCheck -->
    <link rel="stylesheet" href="<?php echo base_url('assets/plugins/iCheck/square/blue.css');?>">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <link rel="stylesheet" href="<?php echo base_url('assets/dist/css/skins/_all-skins.min.css');?>">
    <link rel="stylesheet" href="<?php echo base_url('assets/plugins/iCheck/all.css');?>">
    <link rel="stylesheet" href="<?php echo base_url('assets/plugins/iCheck/square/blue.css');?>">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!-- jQuery 2.2.3 -->
    <script src="<?php echo base_url('assets/plugins/jQuery/jquery-2.2.3.min.js');?>"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="<?php echo base_url('assets/bootstrap/js/bootstrap.min.js');?>"></script>
    <!-- iCheck -->
    <script src="<?php echo base_url('assets/plugins/iCheck/icheck.min.js');?>"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
    
    <style type="text/css">
      body {
        background-color: #222d32;
      }
    .login-page {
      background-color: #222d32;
    }
    </style>
    
    <style type="text/css">
      body {
        background-color: #222d32;
      }
      body.hold-transition.login-page {
        background-color: #222d32;
      }
      body.hold-transition.login-box {
        background-color: #222d32;
      }
      body.hold-transition.register-box {
        background-color: #222d32;
      }
      body.hold-transition.register-box.register-box-body {
        background-color: #222d32;
      }
      body.hold-transition.forgot-box {
        background-color: #222d32;
      }
      body.hold-transition.forgot-box.forgot-box-body {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-logo {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-body {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-footer {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-message {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-title {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-icon {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-image {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-image img {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-image.lockscreen-image-content {
        background-color: #222d32;
      }
      body.hold-transition.lockscreen.lockscreen-image.lockscreen-image-content img {
        background-color: #222d32;
      }

    </style>
  </head>

  <div class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="index.html"><b>Admin</b>LTE</a>
      </div>
  <!-- login form -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>

        <form action="<?php echo site_url('login/aksi_login');?>" method="post">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Username" name="username">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
            <?php echo form_error('username');?>
            <?php echo $this->session->flashdata('msg');?>
            <?php echo validation_errors('<div class="alert alert-danger">','</div>');?>
            <?php echo $this->session->flashdata('pesan');?>
            

          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Password" name="password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            <?php echo form_error('password');?>
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> Remember Me
                </label>
              </div>
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
            </div>
            <!-- /.col -- -->
          </div>
          <?php echo form_close();?>
          <a href="#">I forgot my password</a><br>
          <a href="register.html" class="text-center">Register a new membership</a>

        </form>

      </div>
      <!-- /.login-box-body -->

    </div>
    <!-- /.login-box -->

  </div>
  <!-- /.login-page -->
</html>