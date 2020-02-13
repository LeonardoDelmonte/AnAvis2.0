package com.moc.services;

import java.util.Date;
import java.util.List;

import com.moc.models.Donatore;
import com.moc.models.Modulo;
import com.moc.models.Prenotazione;
import com.moc.repositories.DonatoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DonatoreService
 */
@Service
public class DonatoreService implements DonatoreInterface {

    @Autowired
    private DonatoreRepository donatoreRepository;

    @Override
    public void modificaProfilo() {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Prenotazione> ottieniPrenotazioni(Donatore donatore) {
        return donatore.getListaPrenotazioni();
    }

    @Override
    public Donatore findByEmail(String email) {
        return donatoreRepository.findByEmail(email);
    }

    @Override
    public void modificaModulo(Donatore donatore, Modulo modulo) {
       if(donatore.getModulo()==null){
           donatore.setModulo(modulo);
           donatore.setAbilitaDonazione(true);
           donatoreRepository.save(donatore);
       }
    }

    @Override
    public Modulo ottieniModulo(Donatore donatore) {
        if(donatore.getModulo()==null){
            return new Modulo();
        }
        return donatore.getModulo();        
    }

    @Override
    public Boolean isAbilitatoAdonare(Donatore donatore) {
        Long date = new Date().getTime();
        Long last = 0L;
        if(donatore.getModulo()==null)
            return false;
        List<Prenotazione> list = donatore.getListaPrenotazioni();
        if (!list.isEmpty())
            last = list.get(list.size() - 1).getDate().getTime();
        if (date - last > 7884008640L) {
            donatore.setAbilitaDonazione(true);
            donatoreRepository.save(donatore);
        }
        return true;
    }

    
    
}