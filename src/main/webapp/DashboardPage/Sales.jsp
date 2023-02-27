<%@ page import="jakarta.json.JsonArray" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dispensermachine.dispensermachine.Model.Dispenser" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>Sales</title>
    <link rel="stylesheet" href="../DashboardPage/nicepage.css" media="screen">
<link rel="stylesheet" href="../DashboardPage/Sales.css" media="screen">
    <script class="u-script" type="text/javascript" src="../DashboardPage/jquery-1.9.1.min.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="../DashboardPage/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 5.4.4, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "../DashboardPage/images/d3ed754ea692df1cd9654aca2d08e4f6e33bf3dbf25a93d9e0841b4b0136c3d2967c13bef08d6e45f6150b2f390ff9db1c4bf2efe42585334c3cc0_1280.png"
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Sales">
    <meta property="og:type" content="website">
  <meta data-intl-tel-input-cdn-path="intlTelInput/"></head>
  <body class="u-body u-xl-mode" data-lang="en"><header class="u-clearfix u-header u-header" id="sec-cd56"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="1280" data-image-height="1263">
          <img src="../DashboardPage/images/d3ed754ea692df1cd9654aca2d08e4f6e33bf3dbf25a93d9e0841b4b0136c3d2967c13bef08d6e45f6150b2f390ff9db1c4bf2efe42585334c3cc0_1280.png" class="u-logo-image u-logo-image-1">
        </a>
        <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
          <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px;">
            <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
              <svg class="u-svg-link" viewBox="0 0 24 24"><use xlink:href="#menu-hamburger"></use></svg>
              <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</g></svg>
            </a>
          </div>
          <div class="u-nav-container">
            <ul class="u-nav u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Page-3.html" style="padding: 10px 20px;">Page 3</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Home.html" style="padding: 10px 20px;">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Page-1.html" style="padding: 10px 20px;">Page 1</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Sales.jsp" style="padding: 10px 20px;">Sales</a>
</li></ul>
          </div>
          <div class="u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-inner-container-layout u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Page-3.html">Page 3</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Home.html">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Page-1.html">Page 1</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Sales.jsp">Sales</a>
</li></ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
      </div></header>
    <section class="u-clearfix u-image u-section-1" id="carousel_564b" data-image-width="1553" data-image-height="1000">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-expanded-width u-list u-list-1">
          <div class="u-repeater u-repeater-1">
              <c:forEach items="${requestScope.data}" var="sale">
                 <div class="u-align-left u-container-style u-list-item u-opacity u-opacity-85 u-palette-5-dark-2 u-repeater-item u-list-item-1">
                    <div class="u-container-layout u-similar-container u-valign-bottom-lg u-valign-bottom-md u-valign-bottom-sm u-valign-bottom-xs u-container-layout-1">
                        <img src="../DashboardPage/images/16b425580a4eeff3f13bc8aba7c1f6fad095e3915f21a4629ff36b0868908037ca7bcdf541deaee67d09c3d891349efd71bf670ec466bdcad3951e_1280.png" alt="" class="u-image u-image-default u-image-1" data-image-width="1280" data-image-height="1181">
                        <h6 class="u-text u-text-default u-text-1">Dispenser Id <c:out value="${sale.getSalesDispenserID()}"/></h6>
                        <h6 class="u-text u-text-3" style="font-size: 1.50rem"><c:out value="${sale.getArticle().getName()}"/><br></h6>
                        <h6 class="u-text u-text-3" style="font-size: 1.5rem">Total sold article <c:out value="${sale.getTotalSoldArticles()}"/> </h6>
                        <h6 class="u-text u-text-3" style="font-size: 1.5rem">Total price <c:out value="${sale.getTotalPrice()}"/> &#x20AC</h6>
                    </div>
                 </div>
              </c:forEach>
          </div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-a837"><div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Sample text. Click to select the Text Element.</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-templates" target="_blank">
        <span>Website Templates</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="" target="_blank">
        <span>Website Builder Software</span>
      </a>. 
    </section>
  
</body></html>