import axios from 'axios';

export default {
    properties() {
       return axios.get('/properties') 
    },
    property(ID) {
        return axios.get(`/properties/${ID}`)
    },
    
    addProperty(property) {
        return axios.post('/properties/add', property)
    },
    getOwnProperties() {
        return axios.get('/properties/own')
    },
    getPropertyByRenter() {
        return axios.get('/properties/renterProperty')
    },
    updateProperty(property) {
        return axios.put(`/properties/renterProperty`, property)
    }

}