package com.moc.services;

import java.util.List;

import com.moc.dto.SedeAvisProfiloDto;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;

/**
 * DateSedeAvisInterface
 */
public interface SedeAvisInterface {

    void elimina(Prenotazione prenotazione);
    void modifica(Prenotazione prenotazione);
    List<Prenotazione> ottieni(SedeAvis sedeAvis);
    SedeAvis findByEmail(String email);
    SedeAvis findByComune(String comune);
	void modificaProfilo(SedeAvis sedeAvis, SedeAvisProfiloDto profilo);
	SedeAvisProfiloDto ottieniProfilo(SedeAvis sedeAvis);

}