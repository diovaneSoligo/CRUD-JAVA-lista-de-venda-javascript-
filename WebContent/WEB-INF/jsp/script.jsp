<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script>
var x= [];
var totalfim = 0;

function calcular() {

    var str = document.getElementById("valor").value;

    var num1 = str.split('@');
    var num2 = Number(document.getElementById("qtda").value);
    
    var uni = document.getElementById("valoruni");
    var quant = document.getElementById("quant");
    
    var elemResult = document.getElementById("resultado");

       elemResult.innerText = String(num1[0] * num2);
       uni.textContent = String(num1[0]);
       quant.textContent = String(" X " + num2 + " unid");
    
}

function adicionar(){
	var str = document.getElementById("valor").value;

    var desc = str.split('@');
    
    var descricao = desc[1];
    var codigo = desc[2];
    
	var quantidade = Number(document.getElementById("qtda").value);
	var total = document.getElementById("resultado").innerHTML;
	
	console.log(total);//console navegador
	
	totalfim=totalfim+parseFloat(total);
	
	$("#totalFim").html(totalfim);//coloca o valor total da compra na ID totalFim
	
	x.push([codigo,quantidade,total]);
	//alert(x);
	$("table").append("<tr>"
			+"<td>"+x.length+"</td>"
			+"<td><input form='venda' value='"+codigo+"@"+quantidade+"@"+total+"' style='display:none' type='checkbox' name='item' checked>"+descricao+"</td>"
			+"<td>"+quantidade+"</td>"
			+"<td>"+total+"</td>"
			+"</tr>");
	
}
</script>