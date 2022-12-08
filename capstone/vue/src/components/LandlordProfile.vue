<template>
  <div> WELCOME LANDLORD 
    <!-- {{ $store.getters.role }} -->
    <button v-on:click="$store.state.showForm = true" v-if="!$store.state.showForm">Add Property</button>
    <property-add-form v-if="$store.state.showForm" />
  </div>
</template>

<script>
import PropertyAddForm from "./PropertyAddForm.vue";

export default {
  components: { PropertyAddForm },
  name: "landlord-profile",
};
</script>

<style>
div {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-items: center;
}


</style>