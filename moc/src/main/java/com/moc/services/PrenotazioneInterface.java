package com.moc.services;

import java.sql.Timestamp;
import java.util.List;

import com.moc.models.Donatore;
import com.moc.models.Prenotazione;
import com.moc.models.SedeAvis;

/**
 * PrenotazioneInterface
 */
public interface PrenotazioneInterface {

    List<Timestamp> salvaListaDate(List<Timestamp> list,SedeAvis sedeAvis);

    Prenotazione findById(Long id);

    Prenotazione prenotaData(Donatore donatore,Prenotazione prenotazione);
}