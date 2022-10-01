$(document).ready(function(){
    $.ajax({
        type:"GET",
        dataType:"html",
        url:"./ServletTest",
        data: $.param(),
        success: function(data){
           let parseData = JSON.parse(data);
           console.log("petición correcta");
        }
    });
});


