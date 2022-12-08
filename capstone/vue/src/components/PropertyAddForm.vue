<template>
  <form v-on:submit.prevent="addProperty">
    <div>
      <label>Address:</label>
      <input type="text" v-model="$store.state.newProperty.address" />
    </div>
    <div>
      <label>Price:</label>
      <input type="number" v-model="$store.state.newProperty.price" />
    </div>
    <div>
      <label>Bedrooms:</label>
      <input type="number" v-model="$store.state.newProperty.bedrooms" />
    </div>
    <div>
      <label>Bathroom:</label>
      <input
        type="number"
        step="0.5"
        v-model="$store.state.newProperty.bathrooms"
      />
    </div>
    <div>
      <label>Pic URL:</label>
      <input type="url" v-model="$store.state.newProperty.picURL" />
    </div>
    <div>
      <label>SQ Footage:</label>
      <input type="number" v-model="$store.state.newProperty.sqFootage" />
    </div>
    <div>
      <label>Description:</label>
      <input type="text" v-model="$store.state.newProperty.description" />
    </div>
    <div>
      <input type="submit" value="Save" />
      <input v-on:click="resetForm" type="button" value="Cancel" />
    </div>
  </form>
</template>

<script>
import PropertyService from "../services/PropertyService";

export default {

  data() {
    return {

    };
  },
  methods: {
    addProperty() {
      let newProperty = this.$store.state.newProperty;

      PropertyService.addProperty(newProperty).then((response) => {
        if (response.status === 200) {
          this.$store.commit("ADD_PROPERTY", newProperty);
        }
      });
      this.resetForm();
    },
    resetForm() {
      this.$store.state.showForm = false;
      this.$store.state.newProperty = {};
    },
  },
};
</script>

<style>
</style>