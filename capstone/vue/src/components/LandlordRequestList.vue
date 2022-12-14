<template>
  <div>
    <h2>Maintenance requests on your property: </h2>
    <table id="all-landlord-requests">
      <tr>
        <th>Property Address</th>
        <th>Title</th>
        <th>Description</th>
        <th>Request Date</th>
        <th>Status</th>
      </tr>
      <tr
        class="data-row"
        v-for="request in currentRequests"
        :key="request.requestID"

      >
        <th>{{ request.propertyID }}</th>
        <th>{{ request.title }}</th>
        <th>{{ request.description }}</th>
        <th>{{ request.date }}</th>
        <th>{{ request.status }}</th>
        <th> 
          <input type="checkbox" v-if="request.status == 'RECEIVED'" :id="request.requestID" :value="request.requestID" v-model.number="selectedRequests"/>
        </th>
      </tr>
    </table>
  <div>
    <select id="workers">
      <option v-for="worker in workers"></option>
    <button :disabled="selectedRequests == 0">Submit</button>
  </div>
</template>

<script>
import MaintenanceService from '../services/MaintenanceService';
import AuthService from '../services/AuthService';


export default {
  data() {
    return {
      currentRequests: [],
      selectedRequests: [],
      workers: []
    };
  },
  methods: {
    setupRequests() {
      MaintenanceService.getRequestsByLandlord().then((response) => {
        this.currentRequests = response.data;
      })
    }
  },

  created() {
    this.setupRequests();
  }
};
</script>

<style>
</style>