<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/ClubHomePage.css">
<title>Club Homepage</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-navbar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>
</head>

<body>

<!-- Header -->
<header class="w3-container w3-red w3-center w3-padding-128">
  <h1 class="w3-margin w3-jumbo">Club Documents</h1>
  <h4>Here is where you will find all the documents that you need.</h4>
</header>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="w3-content">
    <TABLE BORDER="5"    WIDTH="100%"   CELLPADDING="4" CELLSPACING="3">
   <TR>
      <TH COLSPAN="3"><BR><H3 style="text-align: center">Documents</H3>
      </TH>
   </TR>
   <TR>
      <TH> File Name</TH>
      <TH>File Description</TH>
      <TH> Modified Date</TH>
   </TR>
   <TR ALIGN="CENTER">
      <TD><a href="EventRequestForm.docx" download="Event Request Form">Event Request Forms</a></TD>
      <TD>This form is used for reserving rooms, equipment, etc.</TD>
      <TD><p id="date"></p>
<script>
document.getElementById("date").innerHTML = Date();
</script></TD>
   </TR>
</TABLE>
  </div>
</div>

</body>
</html> 