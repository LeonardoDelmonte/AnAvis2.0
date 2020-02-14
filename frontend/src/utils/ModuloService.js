import axiosInstance from './interceptor'

class ModuloService {

    async modificaModuloDonatore(modulo) {
        return await axiosInstance.put('/donatore/gestione-modulo/modifica-modulo', modulo)
    }

    async modificaModuloSede(modulo) {
        return await axiosInstance.put('/sede/gestione-modulo/modifica-modulo', modulo)
    }

    async loadModuloDonatore(email) {
        return await axiosInstance.get('/donatore/gestione-modulo/ottieni-modulo/' + email)
    }
    
    async loadModuloSede(email) {
        return await axiosInstance.get('/sede/gestione-modulo/ottieni-modulo/' + email)
    }
}

export default new ModuloService()