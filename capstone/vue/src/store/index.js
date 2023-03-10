import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    properties: [],
    newProperty: {},
    requests: [],
    newRequest: {},
    showForm: false
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_PROPERTY(state, property) {
      state.properties.unshift(property);
    },
    UPDATE_PROPERTY(state, property) {
      state.properties.property = property;
    },
    ADD_REQUEST(state, request) {
      state.requests.push(request);
    },
    UPDATE_REQUEST(state, request) {
      state.requests.request = request;
    }
  },
  getters: {
    role(state) {
      return state.user.authorities[0].name;
    },
    price(state) {
      return state.properties.price;
    },
    property(state, propertyID) {
      state.properties.find(property => {
        property.propertyID === propertyID;
      })
    },
    request(state, requestID) {
      state.requests.find(request => {
        request.requestID === requestID;
      })
    }
  },

})
