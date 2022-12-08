<template>
  <div id="property-card-container">
    <div
      class="property-card"
      v-for="property in $store.state.properties"
      :key="property.property_ID"
    >
      <property-small-detail :singleProperty="property"/>
    </div>
  </div>
</template>

<script>
import PropertySmallDetail from './PropertySmallDetail.vue'
export default {
  components: { PropertySmallDetail },
    name: 'property-listing',
}
</script>

<style >
#property-card-container {
  display: grid;
  grid-template-areas: "property property property";
  gap: 10px;
  justify-content: center;
}

.property {
    grid-area: "property";
}

.property-card img {
  width: 25vw;
}
</style>