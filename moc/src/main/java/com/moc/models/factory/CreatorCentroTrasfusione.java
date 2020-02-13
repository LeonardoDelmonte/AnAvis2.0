package com.moc.models.factory;

import com.moc.dto.RegistrazioneDto;
import com.moc.models.Autorizzazioni;
import com.moc.models.CentroTrasfusione;
import com.moc.models.Utente;

/**
 * CreatorCentroTrasfusione
 */
public class CreatorCentroTrasfusione extends Creator{

    private CentroTrasfusione centroTrasfusione;

	@Override
	public Utente creaUtente(RegistrazioneDto registrazioneDto) {
        centroTrasfusione = registrazioneDto.getCentroTrasfusione();
        controllaInfoUtente(centroTrasfusione);
        setAutorizzazioni();
        return this.builder();
    }

    @Override
    protected void setAutorizzazioni() {
        Autorizzazioni autorizzazioni = new Autorizzazioni();
        autorizzazioni.autorizzazioniCentroTrasfusione();
        centroTrasfusione.setAutorizzazioni(autorizzazioni.getAutorizzazioni());
    }

    private Utente builder(){
        //lascio il builder e non ritorno la variabile locale 
        //perchè cosi un json con qualcosa in più ad esempio un modulo già creato
        //non può passare
        return   
            CentroTrasfusione.builder()
                .email(centroTrasfusione.getEmail())
                .password(centroTrasfusione.getPassword())
                .ruolo(centroTrasfusione.getRuolo())
                .direttore(centroTrasfusione.getDirettore())
                .regione(centroTrasfusione.getRegione())
                .provincia(centroTrasfusione.getProvincia())
                .comune(centroTrasfusione.getComune())
                .autorizzazioni(centroTrasfusione.getAutorizzazioni())
                //qui creeremo altre relationShip come liste emergenza
                .build(); 
    }

    
}