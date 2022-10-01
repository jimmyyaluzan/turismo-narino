var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-saldo").html("$"+user.saldo.toFixed()  );

        getLugares(false, "ASC");

        $("#ordenar-clima").click(ordenarLugares);
    });



async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getLugares(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletLugarListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarLugares(parsedResult);
            } else {
                console.log("Error recuperando los datos de los lugares");
            }
        }
    });
}
function mostrarLugares(lugares) {

    let contenido = "";

    $.each(lugares, function (index, lugar) {

        lugar = JSON.parse(lugar);
        let precio;

        if (lugar.viajes > 0) {

            if (user.premium) {

                if (lugar.novedad) {
                    precio = (20000 - (20000 * 0.1));
                } else {
                    precio = (10000 - (10000 * 0.1));
                }
            } else {
                if (lugar.novedad) {
                    precio = 20000;
                } else {
                    precio = 10000;
                }
            }

            contenido += '<tr><th scope="row">' + lugar.id + '</th>' +
                    '<td>' + lugar.sitio + '</td>' +
                    '<td>' + lugar.clima + '</td>' +
                    '<td>' + lugar.viajes + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + lugar.id + '" disabled ';
            if (lugar.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="venderLugar(' + lugar.id + ',' + precio + ');" class="btn btn-success" ';
            if (user.saldo < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#lugares-tbody").html(contenido);
}

 function ordenarLugares() {
        if ($("#icono-ordenar").hasClass("fa-sort")) {
            getLugares(true, "ASC");
            $("#icono-ordenar").removeClass("fa-sort");
            $("#icono-ordenar").addClass("fa-sort-down");
        } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
            getLugares(true, "DESC");
            $("#icono-ordenar").removeClass("fa-sort-down");
            $("#icono-ordenar").addClass("fa-sort-up");
        } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
            getLugares(false, "ASC");
            $("#icono-ordenar").removeClass("fa-sort-up");
            $("#icono-ordenar").addClass("fa-sort");
        }
    }
    
});


function venderLugar(id, precio) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletLugarVender",
        data: $.param({
            id: id,
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                restarDinero(precio).then(function () {
                    location.reload();
                });

            } else {
                console.log("Error en la reserva de el lugar");
            }
        }
    });

}

async function restarDinero(precio) {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRestarDinero",
        data: $.param({
            username: username,
            saldo: parseFloat(user.saldo - precio)
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                console.log("Saldo actualizado")
            } else {
                console.log("Error en el proceso de pago");
            }
        }
    });
}

