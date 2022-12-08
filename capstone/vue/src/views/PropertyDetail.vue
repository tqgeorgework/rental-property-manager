<template>
  <div class="property-card">
    <img :src="currentProperty.picURL" />
    <div>{{ currentProperty.address }}</div>
    <div>${{ currentProperty.price }}</div>
    <div>{{ currentProperty.bedrooms }} Bed</div>
    <div>{{ currentProperty.bathrooms }} Bath</div>
    <div>{{ currentProperty.sqFootage }} Sq. Ft.</div>
    <div>{{ currentProperty.description }}</div>
    <p />
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentProperty: {}
    }
  },
  methods: {
    getPropertyByPropertyID(ID) {
      this.$store.state.properties.find((property) => {
        return property.propertyID == ID;
      });
    },
  },
  created() {
    this.currentProperty = this.getPropertyByPropertyID(this.$route.params.propertyID);
  }
};
</script>

<style>
</style>