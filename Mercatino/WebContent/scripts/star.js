
// faccio il preload dell'immagine utilizzata per l'effetto rollover
var staron = new Image(); staron.src = "../Immagini/star-on.png";

// Definisco la funzione per la votazione che verrà lanciata
// all'evento onclick su una delle 5 stelle
function star_vota(QT){
	document.getElementById('voto').value = QT;
	
  // Creo una variabile con l'output da restituire al momento del voto
	var star_output = '<span class="output">Hai votato ' + QT + ' stelle!</span>';
  // Cambio dinamicamente il contenuto del DIV contenitore con il messaggio di
  // conferma di votazione avvenuta
  document.getElementById('voto_div').innerHTML = star_output;
}

// Definisco la funzione per "accendere" dinamicamente le stelle
// unico argomento è il numero di stelle da accendere
function star_accendi(QT)
{
  // verifico che esistano i DIV delle stelle
  // se il DIV non esiste significa che si è già votato
  if (document.getElementById('star_1'))
  {
    // Ciclo tutte e 5 i DIV contenenti le stelle
    for (i=1; i<=5; i++)
    {
      // se il div è minore o uguale del numero di stelle da accendere
      // imposto dinamicamente la classe su "on"
      if (i<=QT) document.getElementById('star_' + i).className = 'on';
      // in caso contrario spengo la stella...
      else document.getElementById('star_' + i).className = '';
    }
  }
}
