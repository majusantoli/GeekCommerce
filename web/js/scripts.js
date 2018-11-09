(function() {
    console.log("Applying querys")
   
   jQuery('body').on( 'mousedown', '#btnEntrar', function() {
   var txtEmail = $('#txtEmail').val();
   var txtPass = $('#txtPass').val();

    $.get('validarLogin?email=' + txtEmail + '&senha=' + txtPass, function(data) {
        alert(data);
    });
    
    });
    
    jQuery('body').on( 'mousedown', '#btnSalvar', function() {
      var txtEmail = $('#email_cliente').val();
      var txtPass = $('#senha_cliente').val();
 
      
      $.get('criarConta?email=' + txtEmail + '&senha=' + txtPass, function(data) {
        alert(data);
        });

      });
      
      jQuery('body').on( 'mousedown', '#btnCadastrar', function() {
      var txtEmail = $('#txtEmail2').val();
      var txtPass = $('#txtPass2').val();
 
      
      $.get('criarConta?email=' + txtEmail + '&senha=' + txtPass, function(data) {
        alert(data);
        });

      });
      
    jQuery('body').on('mousedown', '#addCarrinho', function() {

    var nome = jQuery('#nomeProduto').text();
    var preco = jQuery('#precoProduto').text().replace(/R\$/, "").replace(/,/, ".");

     $.get('adicionarCarrinho?nome=' + nome + '&preco=' + preco + "&quant=1" , function(data) {
        alert(data);
        });

      });
      
      
      jQuery('body').on('mousedown', '#btnFin', function() {
          

     $.get("finalizarCompra" , function(data) {
        alert(data);
        });

      });



})();