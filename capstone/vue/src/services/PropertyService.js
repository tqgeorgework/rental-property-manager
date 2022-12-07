import axios from 'axios';

export default {
    properties() {
       return axios.get('/properties') 
    },
    property(ID) {
        return axios.get(`/property/${ID}`)
    },
    
    addProperty() {
        return axios.post('/profile')
    },
    // getPropertyByLandlordId(ID) {
    //     return axios.get('/profile/')
    // }

}