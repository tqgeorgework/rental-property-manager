<template>
    <div id="property-card-container">
        <div class="property-card" v-for="property in $store.state.properties" :key="property.property_ID">
            <img :src="property.picURL"/>
            <div>{{property.address}}</div>
            <div>{{property.price}}</div>
            <div>{{property.bedrooms}} Bed </div>
            <div>{{property.bathrooms}} Bath </div>
            <div>{{property.sqFootage}} Sq. Ft.</div>
            <p/>
            
        </div>
        Placeholder Listings</div>
</template>

<script>
import PropertyService from '../services/PropertyService'
export default {
created() {
  PropertyService.properties().then(response => {
    this.$store.state.properties=response.data;
  })
}
}
</script>

<style>
#property-card-container {
    display: grid;
    grid-template-areas:
    "property property property"
    "property property property"
    "property property property";
    gap: 10px;
}
.property-card img {
    width: 25vw;
}
</style>