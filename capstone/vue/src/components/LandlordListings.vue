<template>
  <div id="property-card-container">
    <div
      class="property-card"
      v-for="property in ownProperties"
      :key="property.landlord_ID"
    >
      <property-small-detail :singleProperty="property"/>
      <property-status :curProperty="property"/>
      <p />
    </div>
  </div>
</template>

<script>
import PropertyService from "../services/PropertyService";
import PropertySmallDetail from "../components/PropertySmallDetail.vue";
import PropertyStatus from './PropertyStatus.vue';

export default {
  components: { PropertySmallDetail, PropertyStatus },
  data() {
    return {
      ownProperties: {
        
      }
    }
  },
  created() {
    PropertyService.getOwnProperties().then((response) => {
      this.ownProperties = response.data;
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
.property-card {
  display: flex;
  flex-direction: column;
}

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