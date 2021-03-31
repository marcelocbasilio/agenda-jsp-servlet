/**
	Validação de formulário
	@author José de Assis
 */
 
 function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	
	if (nome === "" || nome === "undefined") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone === "" || fone === "undefined") {
		alert('Preencha o campo Fone')
		frmContato.fone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
	
}