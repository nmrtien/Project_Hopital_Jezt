
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="../Hospital_Jezt/Common/Images/PatientsImages/${pat.paAvatar}" rel="icon" type="image/png">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="DesignHome/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="DesignHome/css/animate.css">
    
    <link rel="stylesheet" href="DesignHome/css/owl.carousel.min.css">
    <link rel="stylesheet" href="DesignHome/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="DesignHome/css/magnific-popup.css">

    <link rel="stylesheet" href="DesignHome/css/aos.css">

    <link rel="stylesheet" href="DesignHome/css/ionicons.min.css">

    <link rel="stylesheet" href="DesignHome/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="DesignHome/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="DesignHome/css/flaticon.css">
    <link rel="stylesheet" href="DesignHome/css/icomoon.css">
    <link rel="stylesheet" href="DesignHome/css/style.css">
  </head>
  <body>
    
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index.html"><i class="flaticon-pharmacy"></i><span>Life</span>Journey</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> Menu
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="Home.jsp" class="nav-link">Home</a></li>
          <li class="nav-item"><a href="MedicineController?action=getAllMedicineHome" class="nav-link">Medicine</a></li>
          <li class="nav-item"><a href="DoctorController?action=listDoctorHome" class="nav-link">Doctors</a></li>
          <li class="nav-item"><a href="CategoryController?action=homeCategory" class="nav-link">Departments</a></li>
          <li class="nav-item dropdown" class="nav-item cta"><a class="nav-link"  data-target="#modalAppointment">
          <span>Account</span>
         
          <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right" id="checkView">
          	<a href="PatientsController?action=getDetailPatients&doId=${pat.doId}" class="dropdown-item" id="value">
              <i class="ni ni-user-run"></i>
              <span>${pat.paFullName}</span>
            </a>
             <div class="dropdown-divider"></div>
            <a href="Login.jsp" class="dropdown-item" id="login">
              <i class="ni ni-user-run"></i>
              <span>Login</span>
            </a>
           
            <div class="dropdown-divider"></div>
            <a href="Logout.jsp" class="dropdown-item" id="logout">
              <i class="ni ni-user-run"></i>
              <span>Logout</span>
            </a>
          </div>
        </li>
          
          
        </ul>
      </div>
    </div>
  </nav>
    <!-- END nav -->


</html>