package com.moc.controllers.gestione_sede_avis;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.moc.components.ControllaDate;
import com.moc.dto.RangeDateDto;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;
import com.moc.security.UtenteCorrente;
import com.moc.services.PrenotazioneInterface;
import com.moc.services.SedeAvisInterface;
import com.moc.utils.InterfaceApi;
import com.moc.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * GestioneDateSedeAvis può entrare qui solo la sedeAvis
 * 
 * //TO DO// implementa modifica ed elimina
 */
@RestController
public class GestioneSedeAvis implements GestioneSedeAvisInterface {

    @Autowired
    private SedeAvisInterface sedeAvisService;
    @Autowired
    private PrenotazioneInterface prenotazioneService;
    @Autowired
    private ControllaDate controllaDate;

    @Override
    public ResponseEntity<InterfaceApi> ottieniDate(@AuthenticationPrincipal UtenteCorrente utenteCorrente) {

        SedeAvis sedeAvis = sedeAvisService.findByEmail(utenteCorrente.getEmail());

        List<Prenotazione> list = sedeAvisService.ottieni(sedeAvis);

        return new ResponseEntity<>(new ResponseList<Prenotazione>(list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterfaceApi> inserireDateLibere(@AuthenticationPrincipal UtenteCorrente utenteCorrente,
            RangeDateDto rangeDateDto) {

        SedeAvis sedeAvis = sedeAvisService.findByEmail(utenteCorrente.getEmail());

        List<Timestamp> list = controllaDate.formattaRangeDate(rangeDateDto);

        list = prenotazioneService.salvaListaDate(list, sedeAvis);

        return new ResponseEntity<>(new ResponseList<Timestamp>(list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InterfaceApi> modificareData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,
            Prenotazione prenotazione) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<InterfaceApi> eliminareData(@AuthenticationPrincipal UtenteCorrente utenteCorrente,
            HttpServletRequest req) {
        // TODO Auto-generated method stub
        return null;
    }


}