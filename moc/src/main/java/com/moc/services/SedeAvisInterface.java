package com.moc.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.moc.dto.RangeDateDto;
import com.moc.dto.SedeAvisProfiloDto;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;

/**
 * DateSedeAvisInterface
 */
public interface SedeAvisInterface {

    void elimina(Prenotazione prenotazione);
    void modifica(Prenotazione prenotazione);
    Map<String,List<Prenotazione>> ottieni(SedeAvis sedeAvis);
    SedeAvis findByEmail(String email);
    SedeAvis findByComune(String comune);
	void modificaProfilo(SedeAvis sedeAvis, SedeAvisProfiloDto profilo);
	SedeAvisProfiloDto ottieniProfilo(SedeAvis sedeAvis);
	Set<String> getAllRegioni();
	Set<String> getAllProvincie(String regione);
	Set<String> getAllComuni(String provincia);

}