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
      </tr>
    </table>
  </div>
</template>

<script>
import MaintenanceService from '../services/MaintenanceService';


export default {
  data() {
    return {
      currentRequests: [],
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