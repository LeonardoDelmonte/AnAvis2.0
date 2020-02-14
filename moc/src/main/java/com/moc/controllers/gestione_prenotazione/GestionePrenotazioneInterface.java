package com.moc.controllers.gestione_prenotazione;

import com.moc.dto.PrenotazionePerTerziDto;
import com.moc.security.UtenteCorrente;
import com.moc.utils.InterfaceApi;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * GestionePrenotazioneInterface
 */
public interface GestionePrenotazioneInterface {

    @PostMapping(value="/sedeAvis/prenota-per-donatore")
    public ResponseEntity<InterfaceApi> prenotaPerTerzi(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody PrenotazionePerTerziDto prenotazionePerTerziDto);

    @PostMapping(value="/donatore/gestione-date/prenota-data")
    public ResponseEntity<InterfaceApi> prenotaData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,@RequestBody Long idPrenotazione);

}