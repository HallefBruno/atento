$(function () {
    $("#btnVerificarPonto").click(function () {
        $.ajax({
            url: "numeroPonto",
            method: "get",
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                
                var dados = data;
                
                $("#umidadeDoAr").val(dados.manha+"-"+dados.tarde+"-"+dados.noite);
                $("#iuv").val(dados.iuvMaximo);
                $("#temperatura").val(dados.temperaturaMinima+"-"+dados.temperaturaMaxima);
                $("#sol").val(dados.nascerDoSol+"-"+dados.porDoSol);
                
                window.console.log(data);
            }
        });
    });
});
