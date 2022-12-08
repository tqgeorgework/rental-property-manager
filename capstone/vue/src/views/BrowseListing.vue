<template>
  <div id="property-card-container">
    <property-listing/>
  </div>
</template>

<script>
import PropertyListing from '../components/PropertyListing.vue';
import PropertyService from "../services/PropertyService";
export default {
  components: { PropertyListing },
  created() {
    PropertyService.properties().then((response) => {
      this.$store.state.properties = response.data;
    });
  },
};
</script>

<style>

</style>