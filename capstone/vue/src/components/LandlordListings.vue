<template>
  <div id="property-card-container">
    <div
      class="property-card"
      v-for="property in $store.state.properties"
      :key="property.property_ID"
    >
      <property-small-detail :singleProperty="property"/>
      <p />
    </div>
  </div>
</template>

<script>
import PropertyService from "../services/PropertyService";
import PropertySmallDetail from "../components/PropertySmallDetail.vue";

export default {
  components: { PropertySmallDetail },
  created() {
    PropertyService.getOwnProperties().then((response) => {
      this.$store.state.properties = response.data;
    });
  },
  methods: {
    goToDetailedView() {
      const propertyID = this.$route.params.propertyID;
      this.$router.push({
        name: "property-detail",
        params: { ID: propertyID },
      });
    },
  },
};
</script>

<style>
div {
  display: flex;
  justify-content: center;
  justify-items: center;
}
#property-card-container {
  display: grid;
  grid-template-areas: "property property property";
  gap: 10px;
}
.property-card img {
  width: 25vw;
}
</style>