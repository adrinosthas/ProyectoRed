/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
   $("#Reg").click(function(){
      $(".registro").slideToggle("slow");
      $("#loginForm").hide();
   }); 
});

//$(function () {
//$.datepicker.setDefaults();
//$("#fechaNac").datepicker({
//firstDay: 1
//});
//});
//  $(function() {
//    $( "#fechaNac" ).datepicker($.datepicker.regional["es"]);
//  });
  $(function() {
    $( "#fechaNac" ).datepicker({
      changeMonth: true,
      changeYear: true,
      dateFormat: "yy-mm-dd",
      dayNamesMin: [ "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" ],
      monthNamesShort:["Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"],
      yearRange: "1945:",
      showAnim: "explode",
      maxDate: "0d"
    });
  });

  $(function() {
    $( "#fecha" ).datepicker({
      changeMonth: true,
      changeYear: true,
      dateFormat: "yy-mm-dd",
      dayNamesMin: [ "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" ],
      monthNamesShort:["Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"],
      //yearRange: "1945:",
      showAnim: "explode",
      minDate: "0d"
    });
  });