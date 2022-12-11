<template>
  <form id="addPropertyForm" v-on:submit.prevent="addProperty">
    <div>
      <label>Address:</label>
      <input type="text" v-model="$store.state.newProperty.address" />
    </div>
    <div>
      <label>Price:</label>
      <input type="number" value="700" min="5" step="5" v-model="$store.state.newProperty.price" />
    </div>
    <div>
      <label>Bedrooms:</label>
      <input type="number" value="1" min="1" v-model="$store.state.newProperty.bedrooms" />
    </div>
    <div>
      <label>Bathrooms:</label>
      <input
        type="number"
        value="1"
        min="0.5"
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
      <input type="number" value="500" step="5" min="5" v-model="$store.state.newProperty.sqFootage" />
    </div>
    <div>
      <label>Description:&nbsp;</label>
      <textarea type="text" v-model="$store.state.newProperty.description" />
    </div>
    <div>
      <input class="save" type="submit" value="Save" />
      <input class="cancel" v-on:click="resetForm" type="button" value="Cancel" />
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
      newProperty.rentStatus = "PAID",
      newProperty.rented = false;
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

<style scoped>
input {
  box-sizing: border-box;
                    font-family: inherit;
                    font-size: 14px;
                    vertical-align: baseline;
                    font-weight: 400;
                    line-height: 1.29;
                    letter-spacing: .16px;
                    border-radius: 0;
                    outline: 2px solid transparent;
                    outline-offset: -2px;
                    height: 40px;
                    border: none;
                    border-bottom: 1px solid #8D8D8D;
                    background-color: #f4f4f4fa;
                    padding: 0 16px;
                    margin-top: 5px;
                    margin-bottom: 5px;
                    color: #161616;
                
                    transition: background-color 70ms cubic-bezier(.2,0,.38,.9),outline 70ms cubic-bezier(.2,0,.38,.9);
}
                    :focus{
                        outline: 2px solid #0F62FE;
                        outline-offset: -2px;
                    }
form{
  margin-right: 50%;
  margin-top: 20px;
 
}
label{
  align-items: flex-start;
  width: 40vh;
}

.save, .cancel{
 display: inline-block;
 
                outline: 0;
                border: none;
                cursor: pointer;
                padding: 0px 24px;
                border-radius: 50px;
                min-width: 100px;
                height: 50px;
                font-size: 18px;
                background-color: rgb(221, 73, 19);
                font-weight: 500;
                color: #222;
                margin: 10px;
                
}
textarea{
  width:400px;
  height: 130px;
}
</style>