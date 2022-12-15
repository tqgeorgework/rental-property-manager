<template>
  <div id="landlord-maintenance-requests">
    <h2>Maintenance requests on your property: </h2>
    <table id="all-landlord-requests">
      <tr>
        <th>Property Address</th>
        <th>Title</th>
        <th>Description</th>
        <th>Request Date</th>
        <th>Status</th>
        <th>Assign Worker
          <div>
              <select id="workers" v-model="selectedWorker">
      <option v-for="worker in workers" :value="worker.id" :key="worker.id"> {{worker.name}} </option>
    </select>
    
    <button :disabled="selectedRequestsIDs == 0" @click="assignWorker()">Submit</button> </div>
        </th>
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
          <input type="checkbox" v-if="request.status == 'RECEIVED'" :id="request.requestID" :value="request.requestID" v-model.number="selectedRequestsIDs"/>
        </th>
      </tr>
    </table>
  <!-- <div>
    <select id="workers" v-model="selectedWorker">
      <option v-for="worker in workers" :value="worker.id" :key="worker.id"> {{worker.name}} </option>
    </select>
    
    <button :disabled="selectedRequestsIDs == 0" @click="assignWorker()">Submit</button>
    
  </div> -->
  </div>
</template>

<script>
import MaintenanceService from "../services/MaintenanceService";
import AuthService from "../services/AuthService";

export default {
  data() {
    return {
      currentRequests: [],
      selectedRequestsIDs: [],
      selectedRequests: [],
      workers: [],
      selectedWorker: {}
    };
  },
  methods: {
    setupRequests() {
      MaintenanceService.getRequestsByLandlord().then((response) => {
        this.currentRequests = response.data;
      });
    },
    setupUsers() {
      AuthService.allMaintenanceWorkers().then((response) => {
        this.workers = response.data;
      });
    },
    getSelectedRequests() {
      this.selectedRequestsIDs.forEach(ID => {
        this.currentRequests.forEach(request => {
          if (request.requestID == ID) {
            this.selectedRequests.push(request);
          }
        })
      })
    },
    assignWorker() {
      this.getSelectedRequests();
      this.selectedRequests.forEach(request => {
        request.workerID = this.selectedWorker;
        request.status = "IN PROGRESS"
      })
      
      MaintenanceService.assignWorker(this.selectedRequests).then((response) => {
        if (response == 200) {
          this.selectedRequests = [],
          this.selectedWorker = {},
          this.setupRequests();
        }
      })
    }
  },

  created() {
    this.setupRequests();
    this.setupUsers();
  },
};
</script>

<style>
#landlord-maintenance-requests {
  display: flex;
  flex-direction: column;
}
</style>