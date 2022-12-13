<template>
  <div>
    <h2>Your current maintenance requests:</h2>
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
// import MaintenanceService from "../services/MaintenanceService";
// import PropertyService from "../services/PropertyService";
export default {
//   props: ["properties"],
  data() {
    return {
      currentRequests: [],
    };
  }
//   methods: {
//     getAllMaintenanceRequests() {}
//       return PropertyService.getOwnProperties().forEach(property => {
//           MaintenanceService.getRequestsByPropertyID(property.propertyID).then(
//               (response) => {
//                   if (response.status === 200) {
//                       this.currentRequests.push(response.data);
//                   }
//               }
//           )
//       });
//       let curRequests = []
//       this.properties.array.forEach(property => {
//           MaintenanceService.getRequestsByPropertyID(property.propertyID).then((response) =>
//           {
//               curRequests.push(response.data);
//           }
//           )
//           this.currentRequests = curRequests;
         
//       });
//     },
//   },
//   created() {
//     this.getAllMaintenanceRequests();
//   },

// };
};
</script>

<style>
</style>