<template>

    <div id="property-card-container">
        <router-link :to="{name:'property-detail', params:{ID:property.propertyID}}" class="property-card" v-for="property in $store.state.properties" :key="property.property_ID">
            <img :src="property.picURL"/>
            <div>{{property.address}}</div>
            <div>${{property.price}} /month</div>
            <p/>
            </router-link>
            
        
        Placeholder Listings</div>
</template>

<script>
import PropertyService from '../services/PropertyService'
export default {
created() {
  PropertyService.properties().then(response => {
    this.$store.state.properties=response.data;
  })
},
methods: {
  goToDetailedView() {
    const propertyID = this.$route.params.propertyID;
    this.$router.push({name : 'property-detail', params: {ID: propertyID}});
  }

}
}
</script>

<style>
#property-card-container {
    display: grid;
    grid-template-areas:
    "property property property";
    gap: 10px;
}
.property-card img {
    width: 25vw;
}
</style>