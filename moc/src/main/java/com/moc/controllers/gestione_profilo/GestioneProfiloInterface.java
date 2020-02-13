package com.moc.controllers.gestione_profilo;

import com.moc.models.Profilo;
import com.moc.security.UtenteCorrente;
import com.moc.utils.InterfaceApi;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * GestioneProfiloInterface
 */
public interface GestioneProfiloInterface {

    @PutMapping(value="/donatore/gestione-profilo/modificare-profilo")
    public ResponseEntity<InterfaceApi> modificareProfiloDonatore(@AuthenticationPrincipal UtenteCorrente utenteCorrente , Profilo profilo);

    @PutMapping(value="/sedeAvis/gestione-profilo/modificare-profilo")
    public ResponseEntity<InterfaceApi> modificareProfiloSedeAvis(@AuthenticationPrincipal UtenteCorrente utenteCorrente, Profilo profilo);

    @PutMapping(value="/centroTrasfusione/gestione-profilo/modificare-profilo")
    public ResponseEntity<InterfaceApi> modificareProfiloCentroTrasfusione(@AuthenticationPrincipal UtenteCorrente utenteCorrente, Profilo profilo);

    @GetMapping(value="/donatore/gestione-profilo/ottieni-profilo")
    public ResponseEntity<InterfaceApi> ottenereProfiloDonatore(@AuthenticationPrincipal UtenteCorrente utenteCorrente);

    @GetMapping(value="/sedeAvis/gestione-profilo/ottieni-profilo")
    public ResponseEntity<InterfaceApi> ottenereProfiloSedeAvis(@AuthenticationPrincipal UtenteCorrente utenteCorrente);

    @GetMapping(value="/centroTrasfusione/gestione-profilo/ottieni-profilo")
    public ResponseEntity<InterfaceApi> ottenereProfiloCentroTrasfusione(@AuthenticationPrincipal UtenteCorrente utenteCorrente);

}