package com.moc.models.factory;

import com.moc.dto.RegistrazioneDto;
import com.moc.models.Utente;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Creator
 */

public abstract class Creator {

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    abstract public Utente creaUtente(RegistrazioneDto registrazioneDto);
    
    protected void controllaInfoUtente(Utente utente){
        //qualunque errore lancia un eccezione e non tornare indietro un null
        //controlla se l apw rispetta i parametri
        //encode the pw
        utente.setPassword(passwordEncoder().encode(utente.getPassword()));
        //controlla ruolo con un enum dei ruoli
        //notNul notBlank controllato nella Entity
        //se va tutto bene il metodo privato della subClass
        //prende la variabile locale che ora è giusta      
        System.out.println("ciao");
    }

    abstract protected void setAutorizzazioni(Utente utente);
}