$(function () {
    $.ajax({
        url: "numeroPonto",
        method: "get",
        contentType: "application/json",
        dataType: "json",
        beforeSend: function () {
            $("#divLoading").addClass("show");
        },
        success: function (data) {
            var dados = data;
            $("#umidadeDoArManha").text(dados.manha);
            $("#umidadeDoArTarde").text(dados.tarde);
            $("#umidadeDoArNoite").text(dados.noite);
            $("#iuv").text(dados.iuvMaximo);
            $("#temperaturaMinima").text(dados.temperaturaMinima);
            $("#temperaturaMaxima").text(dados.temperaturaMaxima);
            $("#nascerDoSol").text(dados.nascerDoSol);
            $("#porDoSol").text(dados.porDoSol);
            
            if(Number(dados.temperaturaMinima.replace(/[^0-9]/g,'').replace("°","")) <= 12) {
                $("#DiaComSol").css("display","block");
                $("#DiaQuente").css("display","none");
                $("#DiaMaisFrio").css("display","none");
            } else if(Number(dados.temperaturaMinima.replace(/[^0-9]/g,'').replace("°","")) > 12) {
                $("#DiaQuente").css("display","block");
                $("#DiaComSol").css("display","none");
                $("#DiaMaisFrio").css("display","none");
            } else {
                $("#DiaMaisFrio").css("display","block");
                $("#DiaComSol").css("display","none");
                $("#DiaQuente").css("display","none");
            }
            
            window.console.log(data);
        }
    });
    $(document).ajaxComplete(function (event, jqxhr, settings) {
        $("#divLoading").removeClass("show");
    });
    
    $("#btnVerificarPonto").click(function () {
        alert("Ainda em desenvolvimento!");
    });
});
