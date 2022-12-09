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
        return axios.get('/properties/renter-property')
    },
    updateProperty(propertyID) {
        return axios.put(`/properties/${propertyID}`)
    }

}