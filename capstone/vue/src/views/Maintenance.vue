<template>
  <div>
    <maintenance-request-form v-if="$store.getters.role == 'ROLE_USER'"/>
    <maintenance-request-list v-if="$store.getters.role == 'ROLE_LANDLORD'"/>
    
  </div>
</template>

<script>
import MaintenanceRequestForm from '../components/MaintenanceRequestForm.vue';
import MaintenanceRequestList from '../components/MaintenanceRequestList.vue';
export default {
components: {
  MaintenanceRequestForm,
MaintenanceRequestList}
  
}

</script>

<style>

</style>