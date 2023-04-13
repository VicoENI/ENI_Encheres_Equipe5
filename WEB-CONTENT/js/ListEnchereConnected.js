$(document).ready(function() {
  // Désactiver les cases à cocher contenant "ventes_" lorsque le bouton radio "Achats" est sélectionné
  $('input[name="inlineRadioOptions"][value="Achats"]').click(function() {
    $('input[type="checkbox"][id^="ventes_"]').prop('disabled', true);
    
    $('input[type="checkbox"][id^="ventes_"]').prop('checked', false);
    $('input[type="checkbox"][id^="achats_"]').prop('disabled', false);
  });

  // Désactiver les cases à cocher contenant "achats_" lorsque le bouton radio "Ventes" est sélectionné
  $('input[name="inlineRadioOptions"][value="Ventes"]').click(function() {
    $('input[type="checkbox"][id^="achats_"]').prop('disabled', true);
    
    $('input[type="checkbox"][id^="achats_"]').prop('checked', false);
    $('input[type="checkbox"][id^="ventes_"]').prop('disabled', false);
  });
});