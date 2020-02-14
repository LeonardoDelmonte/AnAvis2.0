import axiosInstance from './interceptor'

class GestioneCentroTrasfusione {

    async inviaEmergenza(gruppoSanguigno) {
        return await axiosInstance.post('/centro/inserisci-emergenze',gruppoSanguigno)
    }

    async getEmergency(){
        return await axiosInstance.get('centro/ottieni-emergenze')
    }

    async deleteEmergenze(emergenza){
        return await axiosInstance.delete('centro/elimina-emergenze',
                { data:emergenza } 
          )
    }

    async getCountRichieste(){
        return await axiosInstance.get('/centro/conta-emergenze')
    }
    
}

export default new GestioneCentroTrasfusione()