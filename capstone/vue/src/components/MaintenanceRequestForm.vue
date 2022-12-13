<template>
  <form id="addMaintenanceRequest" v-on:submit.prevent="addMaintenanceRequest">
    <div>
      <label>Problem:</label>
      <input type="text" v-model="newRequest.title" required />
    </div>
    <div>
      <label>Description:</label>
      <textarea type="text" v-model="newRequest.description" />
    </div>
    <div>
      <button class="save" type="submit">Submit maintenance request</button>
      <button
        class="cancel"
        v-on:click="resetForm"
        type="button"
        value="Cancel"
      >
        Cancel
      </button>
    </div>
  </form>
</template>

<script>
import MaintenanceService from "../services/MaintenanceService";

export default {
  props: ['singleProperty'],
  data() {
    return {
      newRequest: {
        title: "title",
        description: "description",
        propertyID: this.singleProperty.propertyID
      },
    };
  },
  methods: {
    addMaintenanceRequest() {
      MaintenanceService.createRequest(this.newRequest).then((response) => {
        if (response.status === 200) {
          this.$store.commit("ADD_REQUEST", this.newRequest);
          this.resetForm();
        }
      });
    },
    resetForm() {
      this.$store.state.showForm = false;
      this.$store.state.newRequest = {};
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Orbitron:wght@900&display=swap");

input {
  box-sizing: border-box;
  font-family: inherit;
  font-size: 14px;
  vertical-align: baseline;
  font-weight: 400;
  line-height: 1.29;
  letter-spacing: 0.16px;
  border-radius: 0;
  outline: 2px solid transparent;
  outline-offset: -2px;
  height: 40px;
  border: none;
  border-bottom: 1px solid #8d8d8d;
  background-color: #f4f4f4fa;
  padding: 0 16px;
  margin-top: 5px;
  margin-bottom: 5px;
  color: #161616;

  transition: background-color 70ms cubic-bezier(0.2, 0, 0.38, 0.9),
    outline 70ms cubic-bezier(0.2, 0, 0.38, 0.9);
}
:focus {
  outline: 2px solid #0f62fe;
  outline-offset: -2px;
}
form {
  margin-right: 50%;
  margin-top: 20px;
}
label {
  align-items: flex-start;
  width: 40vh;
}

/* .save, .cancel{
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
                
} */

button {
  position: relative;
  padding: 4px 20px;

  font: 18px "Orbitron";
  letter-spacing: 1px;
  text-transform: uppercase;
  margin: 40px;

  color: #fff;
  text-shadow: 0 5px 20px rgba(192, 36, 0, 0.4), 0 2px 2px rgba(192, 36, 0, 0.4);
  background-image: radial-gradient(
    100% 75% at 50% 100%,
    #fed262 0%,
    #c40900 100%
  );
  border: none;
  border-radius: 100px;
  box-shadow: inset 0 3px 15px 0 #ae2000, inset 0 -3px 0 0 #fed262,
    inset 0 40px 0 0 rgba(254, 210, 98, 0.4), inset 0 20px 20px 0 #f8bf45,
    0 0 0 8px #000, 0 9px 0 0 #444, 0 0 20px 0 rgba(254, 210, 98, 0.4),
    0 40px 20px -30px rgba(254, 210, 98, 0.2);
}
button:before {
  content: "";
  position: absolute;
  z-index: -2;
  top: -1rem;
  left: -2rem;
  right: -2rem;
  bottom: -1rem;
  background: linear-gradient(#333, #151515);
  border-radius: 100px;
  box-shadow: 0 2px 10px #000, inset 0 2px 0 #444;
}
button:after {
  content: "";
  position: absolute;
  z-index: -1;
  background: #000;
  box-shadow: 0 1px 0 #444;
  height: 10px;
  left: -2rem;
  right: -2rem;
  top: 50%;
  transform: translateY(-50%);
}
button:hover {
  cursor: pointer;
  background-image: radial-gradient(
    100% 75% at 50% 100%,
    #f7b940 0%,
    #a20700 100%
  );
}
button:focus,
button:active {
  outline: none;
  color: #f9e3bf;
  background-image: radial-gradient(
    100% 75% at 50% 100%,
    #f58725 0%,
    #850600 100%
  );
  box-shadow: inset 0 0 50px rgba(0, 0, 0, 0.4), inset 0 0 10px #850600,
    inset 0 3px 15px 0 #ae2000, inset 0 40px 0 0 rgba(254, 210, 98, 0.3),
    inset 0 20px 20px 0 rgba(248, 191, 69, 0.75), 0 0 0 8px #000, 0 9px 0 0 #444;
}

textarea {
  width: 250px;
  height: 130px;
  position: relative;
}
</style>