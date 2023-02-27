<%@ page import="jakarta.json.JsonArray" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dispensermachine.dispensermachine.Model.Dispenser" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Out of service">
    <meta name="description" content="">
    <title>Page 3</title>
    <link rel="stylesheet" href="../DashboardPage/nicepage.css" media="screen">
<link rel="stylesheet" href="../DashboardPage/Page-3.css" media="screen">
    <script class="u-script" type="text/javascript" src="../DashboardPage/jquery-1.9.1.min.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="../DashboardPage/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 5.4.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "../DashboardPage/images/d3ed754ea692df1cd9654aca2d08e4f6e33bf3dbf25a93d9e0841b4b0136c3d2967c13bef08d6e45f6150b2f390ff9db1c4bf2efe42585334c3cc0_1280.png"
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Page 3">
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
            <ul class="u-nav u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="../Home.html" style="padding: 10px 20px;">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="../DashboardPage/DispenserView.jsp" style="padding: 10px 20px;">Page 3</a>
</li></ul>
          </div>
          <div class="u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-inner-container-layout u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="DashboardPage/Home.html">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="../DashboardPage/DispenserView.jsp">Page 3</a>
</li></ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
      </div></header>
    <section class="u-align-center u-clearfix u-image u-section-1" id="carousel_dbe3" data-image-width="1553" data-image-height="1000">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h2 class="u-custom-font u-font-playfair-display u-text u-text-1"><c:out value="${requestScope.status}"/> <c:if test="${requestScope.supply==1}">: To supply based on the current temperature <c:out value="${requestScope.weather}"/>&#8451 in Paris</c:if>
            <br>
        </h2>
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
          <table class="u-table-entity u-table-entity-1">
            <colgroup>
              <col width="14.3%">
              <col width="14.3%">
              <col width="14.3%">
              <col width="14.3%">
              <col width="14.3%">
              <col width="14.500000000000005%">
              <col width="13.900000000000006%">
            </colgroup>
            <thead class="u-palette-5-dark-2 u-table-header u-table-header-1">
              <tr>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">Id</th>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">drink-type</th>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">gps-coordinates</th>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">installation-address</th>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">intervention-date<br>
                </th>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">location</th>
                <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">comment</th>
                  <th class="u-border-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-1 u-table-cell">Status</th>


              </tr>
            </thead>
            <tbody class="u-palette-5-dark-3 u-table-body u-table-body-1">
            <c:forEach items="${requestScope.data}" var="dispenser">
              <tr>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-8"><c:out value="${dispenser.getId()}"/></td>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-9"><c:out value="${dispenser.getDrinkType()}"/></td>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-10"><c:out value="${dispenser.getGpsCoordinates()}"/></td>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-11"><c:out value="${dispenser.getInstallationAddress()}"/></td>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-12"><c:out value="${dispenser.getInterventionDate()}"/></td>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-13"><c:out value="${dispenser.getLocation()}"/></td>
                <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-14"><c:out value="${dispenser.getComment()}"/></td>
                  <td class="u-border-1 u-border-palette-5-dark-1 u-table-cell u-table-cell-14" style="background-color:<c:choose>
                  <c:when test="${dispenser.getDispenserStatus().getCurrentState()=='ok'}">green</c:when>
                  <c:when test="${dispenser.getDispenserStatus().getCurrentState()=='attention'}">orange;color: #0f0f0f</c:when>
                  <c:when test="${dispenser.getDispenserStatus().getCurrentState()=='alarme'}">yellow;color:black;</c:when>
                  <c:when test="${dispenser.getDispenserStatus().getCurrentState()=='erreur'}">red;color: #0f0f0f</c:when>
                  <c:otherwise>black</c:otherwise>
                  </c:choose>
                          "><c:out value="${dispenser.getDispenserStatus().getCurrentState()}"/></td>

              </tr>
            </c:forEach>
            </tbody>
          </table>
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