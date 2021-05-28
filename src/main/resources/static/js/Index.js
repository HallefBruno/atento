$(function () {
    $.ajax({
        url: "numeroPonto",
        method: "get",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {

            var dados = data;

            $("#umidadeDoAr").text(dados.manha+"-"+dados.tarde+"-"+dados.noite);
            $("#iuv").text(dados.iuvMaximo);
            $("#temperatura").text(dados.temperaturaMinima+"-"+dados.temperaturaMaxima);
            $("#sol").text(dados.nascerDoSol+"-"+dados.porDoSol);

            window.console.log(data);
        }
    });
    $("#btnVerificarPonto").click(function () {
        alert("Ainda em desenvolvimento!");
    });
});
