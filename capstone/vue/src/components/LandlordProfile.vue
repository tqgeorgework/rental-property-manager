<template>
  <div>
    Placeholder {{ $store.getters.role }}
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
</style>