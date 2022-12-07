import axios from 'axios';

export default {
    properties() {
       return axios.get('/properties') 
    },
    property(ID) {
        return axios.get(`/properties/${ID}`)
    },
    
    addProperty(property) {
        return axios.post('/properties/profile', property)
    },
    // getPropertyByLandlordId(ID) {
    //     return axios.get('/profile/')
    // }

}