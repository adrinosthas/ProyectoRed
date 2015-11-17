/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function cargar(div, desde){
                 $(div).load(desde);
            }
            $(document).ready(function(){

                $('.opciones').hide();
                $('.opciones:first').show();

                $('.nav li').click(function(){
                        $('.nav li').removeClass('active');
                        $(this).addClass('active');
                        $('.opciones').hide();
                        var contenidoAct = $(this).find('a').attr('href');
                        $(contenidoAct).fadeIn();
                });
            });