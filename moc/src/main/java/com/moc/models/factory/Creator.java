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
        //controlla se la pw e l'email rispetta i parametri
        utente.setPassword(passwordEncoder().encode(utente.getPassword()));  
    }

    abstract protected void setAutorizzazioni(Utente utente);
}