package com.moc.services;
import java.util.List;
import com.moc.models.Donatore;
import com.moc.models.Modulo;
import com.moc.models.Prenotazione;

/**
 * DonatoreInterface
 */
public interface DonatoreInterface {
    
    void modificaProfilo();
    List<Prenotazione> ottieniPrenotazioni(Donatore donatore);
    Donatore findByEmail(String email);
	void modificaModulo(Donatore donatore, Modulo modulo);
    Modulo ottieniModulo(Donatore donatore);
    Boolean isAbilitatoAdonare(Donatore donatore);

}