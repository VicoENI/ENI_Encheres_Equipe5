$(document).ready(function() {
  // Enregistrement de la fonction de gestion d'événement pour le changement de radio
  $('input[name="inlineRadioOptions"]').on('change', function() {
      var isChecked = $(this).is(':checked');
      if (isChecked) {
      // Désactiver les cases à cocher de l'autre radio
      //debugger
      $('input[name="inlineRadioOptions"]').not(this).prop('checked', false);
      if ($(this).val() === 'Achats') {
          // Activer les cases à cocher de l'achat et désactiver celles de la vente
          $('#defaultCheck1, #defaultCheck2, #defaultCheck3').prop('disabled', false);
          $('#defaultCheck4, #defaultCheck5, #defaultCheck6').prop('checked', false).prop('disabled', true);
      } else if ($(this).val() === 'Ventes') {
          // Activer les cases à co
          $(document).ready(function() {
              // Selecteurs pour les boutons radio et les cases à cocher
              var achatRadio = $("#inlineRadio1");
              var venteRadio = $("#inlineRadio2");
              var achatChecks = [$("input[id=defaultCheck1]"), $("input[id=defaultCheck2]"), $("input[id=defaultCheck3]")];
              var venteChecks = [$("input[id=defaultCheck4]"), $("input[id=defaultCheck5]"), $("input[id=defaultCheck6]")];
        
              // Fonction pour désactiver les cases à cocher liées au bouton "Mes ventes"
              function disableVenteChecks() {
              for (var i = 0; i < venteChecks.length; i++) {
                  venteChecks[i].prop("disabled", true);
              } 
          }
        
          // Fonction pour activer toutes les cases à cocher
          function enableAllChecks() {
            for (var i = 0; i < achatChecks.length; i++) {
              achatChecks[i].prop("disabled", false);
            }
            for (var i = 0; i < venteChecks.length; i++) {
              venteChecks[i].prop("disabled", false);
            }
          }
        
          // Fonction à exécuter lorsque l'utilisateur change l'état des boutons radio
          $("input[name='inlineRadioOptions']").change(function() {
            if (achatRadio.prop("checked")) {
              for (var i = 0; i < venteChecks.length; i++) {
                venteChecks[i].prop("disabled", true);
              }
              } else if (venteRadio.prop("checked")) {
              disableVenteChecks();
              }
          });
        
          // Fonction à exécuter lorsque l'utilisateur change l'état des cases à cocher
          $("input[type='checkbox']").change(function() {
            // Si toutes les cases à cocher sont cochées, activer le bouton "Rechercher"
            if ($("input[type='checkbox']:checked").length === 6) {
              $("input[type='submit']").prop("disabled", false);
            } else {
              $("input[type='submit']").prop("disabled", true);
            }
          });
        
          // Activer toutes les cases à cocher au chargement de la page
          enableAllChecks();
        });
      };
    };
  }) 
})
$(document).ready(function() {
  // Enregistrement de la fonction de gestion d'événement pour le changement de radio
  $('input[name="inlineRadioOptions"]').on('change', function() {
    var isChecked = $(this).is(':checked');
    if (isChecked) {
      // Désactiver les cases à cocher de l'autre radio
      $('input[name="inlineRadioOptions"]').not(this).prop('checked', false);
      if ($(this).val() === 'Achats') {
        // Activer les cases à cocher de l'achat et désactiver celles de la vente
        $('#defaultCheck1, #defaultCheck2, #defaultCheck3').prop('disabled', false);
        $('#defaultCheck4, #defaultCheck5, #defaultCheck6').prop('checked', false).prop('disabled', true);
      } else if ($(this).val() === 'Ventes') {
        // Activer les cases à cocher de la vente et désactiver celles de l'achat
        $('#defaultCheck4, #defaultCheck5, #defaultCheck6').prop('disabled', false);
        $('#defaultCheck1, #defaultCheck2, #defaultCheck3').prop('checked', false).prop('disabled', true);
      }
    }
  });
  
  // Désactiver les cases à cocher d'achats lorsque l'utilisateur coche le bouton radio de "Mes ventes"
  $('#inlineRadio2').on('change', function() {
    if ($(this).is(':checked')) {
      $('#defaultCheck1, #defaultCheck2, #defaultCheck3').prop('checked', false).prop('disabled', true);
    }
  });
  
  // Activer toutes les cases à cocher au chargement de la page
  $('#defaultCheck1, #defaultCheck2, #defaultCheck3, #defaultCheck4, #defaultCheck5, #defaultCheck6').prop('disabled', false);
});
