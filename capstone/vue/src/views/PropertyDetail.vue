<template>
  <div class="property-card" :key="property.property_ID">
    <img :src="property.picURL" />
    <div>{{ property.address }}</div>
    <div>${{ property.price }}</div>
    <div>{{ property.bedrooms }} Bed</div>
    <div>{{ property.bathrooms }} Bath</div>
    <div>{{ property.sqFootage }} Sq. Ft.</div>
    <div>{{ property.description }}</div>
    <p />
  </div>
</template>

<script>
export default {
  methods: {
    getPropertyByPropertyID(ID) {
      this.$store.state.properties.find((property) => {
        return property.propertyID == ID;
      });
    },
  },
  computed: {
    property() {
      const properties = this.$route.params.propertyID;
      return this.getPropertyByPropertyID(properties);
    },
  },
};
</script>

<style>
</style>