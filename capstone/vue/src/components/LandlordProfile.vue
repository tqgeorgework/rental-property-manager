<template>
  <div>Placeholder {{$store.getters.role}}
    <button v-on:click="showForm=true" v-if="!showForm">Add Property</button>
    <form  v-on:submit.prevent="addProperty" v-if="showForm===true">
      <div>
      <label>Address:</label>
      <input type= "text" v-model="$store.state.newProperty.address"/>
      </div>
      <div>
        <label>Price:</label>
        <input type="number" v-model="$store.state.newProperty.price"/>
      </div>
      <div>
        <label>Bedrooms:</label>
        <input type="number" v-model="$store.state.newProperty.bedrooms"/>
      </div>
      <div>
        <label>Bathroom:</label>
        <input type="number" step= "0.5" v-model="$store.state.newProperty.bathrooms"/>
      </div>
      <div>
        <label>Pic URL:</label>
        <input type="url" v-model="$store.state.newProperty.pic_url"/>
      </div>
      <div>
        <label>SQ Footage:</label>
        <input type="number" v-model="$store.state.newProperty.sq_footage"/>
      </div>
      <div>
        <label>Description:</label>
        <input type="text" v-model="$store.state.newProperty.description"/>
      </div>
      <div>
        <input type="submit" value="save"/>
        <input v-on:click="resetForm" type="button" value="cancel"/>
      </div>
    </form>

  </div>
</template>

<script>

export default {
name: 'landlord-profile',
data(){
return{
  showForm: false,
}
},
methods: {
addProperty(){
  this.$store.state.newProperty.landlord_id = this.$store.state.user.landlord_id;
  this.$store.commit("ADD_PROPERTY", this.$store.state.newProperty);
  this.resetForm();
},
resetForm(){
  this.showForm = false;
  this.$store.state.newProperty = {};
}
}
}

</script>

<style>

</style>