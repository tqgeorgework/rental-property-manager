<template>
  <div>
    <table id="request-table">
      <tr>
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
        <th>{{ request.title }}</th>
        <th>{{ request.description }}</th>
        <th>{{ request.date }}</th>
        <th>{{ request.status }}</th>
      </tr>
    </table>
  </div>
</template>

<script>
import MaintenanceService from "../services/MaintenanceService";
export default {
  data() {
    return {
      currentRequests: [],
    };
  },
  methods: {
    getMaintenanceRequests() {
      return MaintenanceService.getRequestsByPropertyPrincipal().then(
        (response) => {
          if (response.status === 200) {
            this.currentRequests = response.data;
          }
        }
      );
    },
  },
  created() {
    this.getMaintenanceRequests();
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Orbitron:wght@900&display=swap");
#request-table {
  border: 1px;
}

table,
th,
tr {
  border: 1px solid black;
}
th {
  padding: 5px;
}
.data-row {
  font: 18px "Orbitron";
  font-size: 14px;
  font-weight: 400;
}
</style>