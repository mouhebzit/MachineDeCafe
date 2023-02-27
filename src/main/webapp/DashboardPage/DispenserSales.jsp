<%@ page import="jakarta.json.JsonArray" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dispensermachine.dispensermachine.Model.Dispenser" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Dispenser Sales">
    <meta name="description" content="">
    <title>Page 1</title>
    <link rel="stylesheet" href="../DashboardPage/nicepage.css" media="screen">
<link rel="stylesheet" href="../DashboardPage/Page-1.css" media="screen">
    <script class="u-script" type="text/javascript" src="../DashboardPage/jquery-1.9.1.min.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="../DashboardPage/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 5.4.4, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "../DashboardPage/images/d3ed754ea692df1cd9654aca2d08e4f6e33bf3dbf25a93d9e0841b4b0136c3d2967c13bef08d6e45f6150b2f390ff9db1c4bf2efe42585334c3cc0_1280.png"
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Page 1">
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
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="DispenserSales.jsp" style="padding: 10px 20px;">Page 1</a>
</li></ul>
          </div>
          <div class="u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-inner-container-layout u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Page-3.html">Page 3</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Home.html">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="DispenserSales.jsp">Page 1</a>
</li></ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
      </div></header>
    <section class="u-align-center u-clearfix u-image u-section-1" id="carousel_58cc" data-image-width="1553" data-image-height="1000">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-align-center u-custom-font u-font-raleway u-text u-text-default u-text-1">Dispenser Sales<br>
        </h1>
        <p class="u-align-center u-text u-text-default u-text-2">Choose the dispenser to show its sales<br>
        </p>
        <div class="u-expanded-width u-list u-list-1">
          <div class="u-repeater u-repeater-1">

            <c:forEach items="${requestScope.data}" var="dispenser">

            <div class="u-container-style u-list-item u-opacity u-opacity-0 u-repeater-item u-white u-list-item-1">
                <a href="<c:url value="/home/SalesByDispenserServlet?id="/><c:out value="${dispenser.getId()}"/>" style="color:#111111">
              <div class="u-container-layout u-similar-container u-valign-top u-container-layout-1">
                <div class="u-align-center u-container-style u-expanded-width u-group u-opacity u-opacity-75 u-palette-5-dark-3 u-shape-rectangle u-group-1">
                  <div class="u-container-layout u-valign-middle u-container-layout-2">
                    <h3 class="u-custom-font u-font-raleway u-text u-text-default u-text-3">Dispenser ID <c:out value="${dispenser.getId()}"/></h3>
                  </div>
                </div>
                <img alt="" class="u-expanded-width u-image u-image-contain u-image-default u-image-1" src="../DashboardPage/images/VendingMachine.png" data-image-width="512" data-image-height="512">
                <div class="u-container-style u-expanded-width u-group u-opacity u-opacity-80 u-palette-5-light-1 u-group-2">
                  <div class="u-container-layout u-valign-top u-container-layout-3">
                    <p class="u-align-center u-text u-text-default u-text-4">Total Sales <b><c:out value="${dispenser.getDispenserStatus().getTotalPrice()}"/> &#x20AC</b>
                    </p>
                    <ul class="u-align-left u-custom-list u-text u-text-5">
                      <li>
                        <div class="class u-list-icon u-text-black">
                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content" viewBox="0 0 512.019 512.019" x="0px" y="0px" id="svg-b379" style=""><path fill="currentColor" d="M362.676,0H149.343C119.888,0,96.01,23.878,96.01,53.333v448 c-0.011,5.891,4.757,10.675,10.648,10.686c2.84,0.005,5.565-1.123,7.571-3.134L256.01,367.083l141.781,141.781 c4.16,4.171,10.914,4.179,15.085,0.019c2.006-2.001,3.133-4.717,3.134-7.55v-448C416.01,23.878,392.131,0,362.676,0z"></path></svg>
                        </div><c:out value="${dispenser.getDrinkType()}"/>
                      </li>
                      <li>
                        <div class="class u-list-icon u-text-black">
                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content" viewBox="0 0 512.019 512.019" x="0px" y="0px" id="svg-b379" style=""><path fill="currentColor" d="M362.676,0H149.343C119.888,0,96.01,23.878,96.01,53.333v448 c-0.011,5.891,4.757,10.675,10.648,10.686c2.84,0.005,5.565-1.123,7.571-3.134L256.01,367.083l141.781,141.781 c4.16,4.171,10.914,4.179,15.085,0.019c2.006-2.001,3.133-4.717,3.134-7.55v-448C416.01,23.878,392.131,0,362.676,0z"></path></svg>
                        </div><c:out value="${dispenser.getLocation()}"/>
                      </li>
                      <li>
                        <div class="class u-list-icon u-text-black">
                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content" viewBox="0 0 512.019 512.019" x="0px" y="0px" id="svg-b379" style=""><path fill="currentColor" d="M362.676,0H149.343C119.888,0,96.01,23.878,96.01,53.333v448 c-0.011,5.891,4.757,10.675,10.648,10.686c2.84,0.005,5.565-1.123,7.571-3.134L256.01,367.083l141.781,141.781 c4.16,4.171,10.914,4.179,15.085,0.019c2.006-2.001,3.133-4.717,3.134-7.55v-448C416.01,23.878,392.131,0,362.676,0z"></path></svg>
                        </div><c:out value="${dispenser.getInstallationAddress()}"/>
                      </li>
                      <li>
                        <div class="class u-list-icon u-text-black">
                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content" viewBox="0 0 512.019 512.019" x="0px" y="0px" id="svg-b379" style=""><path fill="currentColor" d="M362.676,0H149.343C119.888,0,96.01,23.878,96.01,53.333v448 c-0.011,5.891,4.757,10.675,10.648,10.686c2.84,0.005,5.565-1.123,7.571-3.134L256.01,367.083l141.781,141.781 c4.16,4.171,10.914,4.179,15.085,0.019c2.006-2.001,3.133-4.717,3.134-7.55v-448C416.01,23.878,392.131,0,362.676,0z"></path></svg>
                        </div><c:out value="${dispenser.getDispenserStatus().getOperatingStatus()}"/>
                      </li>
                    </ul>
                    <a href="https://nicepage.com/website-builder" class="u-border-none u-btn u-btn-rectangle u-button-style u-grey-70 u-btn-1">learn more</a>
                  </div>
                </div>
              </div>
                </a>
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
      <a class="u-link" href="https://nicepage.com/html-templates" target="_blank">
        <span>HTML Template</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="https://nicepage.dev" target="_blank">
        <span>Website Builder</span>
      </a>. 
    </section>
  
</body></html>