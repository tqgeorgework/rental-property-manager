<template>
  <div>
    Placeholder {{ $store.getters.role }}
    <p>
      <br />
      <label :class="{ unpaid: !clicked, paid: clicked }"
        >Amount Due: {{ clicked ? "PAID" : userProperty.price }}
      </label>
      <br />
      <button :disabled="clicked" v-on:click="updateRentStatus">
        Pay Rent
      </button>
    </p>
  </div>
</template>

<script>
import PropertyService from "../services/PropertyService";
export default {
  data() {
    return {
      clicked: false,
      userProperty: {
        address: "",
        bathrooms: 1,
        bedrooms: 1,
        description: "",
        landlordID: 1,
        picURL: "",
        price: 1,
        propertyID: 1,
        rentStatus: "DUE",
        rented: false,
        sqFootage: 1,
      },
    };
  },
  methods: {
    rentSetup() {
      PropertyService.getPropertyByRenter().then((response) => {
        this.userProperty = response.data;
        this.checkRentStatus();
      });
    },
    updateRentStatus() {
      this.toggleClick();
      PropertyService.updateProperty(this.userProperty)
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit("UPDATE_PROPERTY", this.userProperty);
          }
        })
        .catch((error) => {
          if (error.response) {
            console.log(`error message was ${error.response}`);
          } else if (error.request) {
            console.log(`request ${error.request} was not received`);
          } else {
            console.log("request not made");
          }
        });
    },
    checkRentStatus() {
      if (
        this.userProperty.rentStatus &&
        this.userProperty.rentStatus != "PAID"
      ) {
        this.clicked = false;
      } else {
        this.clicked = true;
      }
    },
    toggleClick() {
      this.clicked = !this.clicked;
    },
  },

  created() {
    this.rentSetup();
  },
};
</script>

<style scoped>
.unpaid {
  color: red;
}
.paid {
  color: green;
}
div {
  display: flex;
  flex-direction: column;
  text-align: center;
}
</style>