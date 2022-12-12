<template>
  <div class="property-card">
    <img :src="currentProperty.picURL" />
    <div>{{ currentProperty.address }}</div>
    <div>${{ currentProperty.price }}</div>
    <div>{{ currentProperty.bedrooms }} Bed</div>
    <div>{{ currentProperty.bathrooms }} Bath</div>
    <div>{{ currentProperty.sqFootage }} Sq. Ft.</div>
    <div class="description">{{ currentProperty.description }}</div>
    <p />
  </div>
</template>

<script>
import PropertyService from "../services/PropertyService"
export default {
  data() {
    return {
      currentProperty: {
        picURL: "",
        address: "",
        price: 1,
        bedrooms: 1,
        bathrooms: 1,
        sqFootage: 1,
        description: ""
      }
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
    PropertyService.property(this.$route.params.ID).then(response => {
      this.currentProperty.picURL = response.data.picURL;
      this.currentProperty.address = response.data.address;
      this.currentProperty.price = response.data.price;
      this.currentProperty.bedrooms = response.data.bedrooms;
      this.currentProperty.bathrooms = response.data.bathrooms;
      this.currentProperty.sqFootage = response.data.sqFootage;
      this.currentProperty.description = response.data.description;
    });
  }
};
</script>

<style scoped>
div {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  margin-left: 10vw;
  margin-right: 10vw;
}
img {
  width: 100vh;
}

.description {
  margin: 10px;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
}


</style>