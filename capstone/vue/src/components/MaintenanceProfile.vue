<template>
  <div>
    <div id="maintenance-container">
    <h2>Maintenance Requests</h2>
    <maintenance-request-list/>
    </div>
  </div>
  
</template>

<script>
import MaintenanceRequestList from './MaintenanceRequestList.vue'

export default {
  components: { MaintenanceRequestList },

}
</script>

<style>
#maintenance-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>