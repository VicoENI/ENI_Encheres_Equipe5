/**
 * Fichier qui regroupe les fonctions liées à la validation du formulaire d'inscription
 */

 $(document).ready(function () {
	 
	 $("#error-pwd").hide();
	 
	 $("#form-inscription input[type=submit]").click(() => {
	    return checkPassword($("#motdepasse").val(), $("#confirmationmdp").val());
	    });
});


function checkPassword(pwd, confPwd)
{
		
    const check = pwd === confPwd;
    
    if(!check)
		$("#error-pwd").show();
	else
		$("#error-pwd").hide();	
	
	return check;
    
}