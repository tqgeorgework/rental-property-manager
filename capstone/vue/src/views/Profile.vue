<template>
 <div>
    <admin-profile v-if="$store.getters.role == 'ROLE_ADMIN'"/>
    <landlord-profile v-if="$store.getters.role == 'ROLE_LANDLORD'"/>
    <user-profile v-if="$store.getters.role == 'ROLE_USER'"/>
    <maintenance-profile v-if="$store.getters.role == 'ROLE_MAINTENANCE' "/>
  </div>

</template>

<script>
import AdminProfile from "../components/AdminProfile";
import LandlordProfile from "../components/LandlordProfile";
import UserProfile from "../components/UserProfile";
import MaintenanceProfile from "../components/MaintenanceProfile";


export default {
  components: {
    AdminProfile, LandlordProfile, UserProfile, MaintenanceProfile}
    
}
</script>

<style>
#maintenanceForm{
  display: flex;
  position: fixed;
  left: 30px;

}


</style>