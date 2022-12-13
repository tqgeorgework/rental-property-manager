<template>
  <div id = "grid">
   
    <div id="renterProperty">
      <h1> Your Home </h1>
      <property-small-detail :singleProperty="userProperty" id="propdetails"/>
    </div> 

    <div id="rentStatus">
      
      <label id="amount-due" :class="{ unpaid: !clicked, paid: clicked }"
        >Amount Due: {{ clicked ? "PAID" : "$" + userProperty.price }}
      </label>
      
     
      <div :class="{visible: !clicked, invisible: clicked}">
      <button id="payRent" :class="{ btnClicked: userProperty.rentStatus == 'PAID', btn: userProperty.rentStatus != 'PAID'}" v-on:click="(updateRentStatus(), disabled, clicked = true)"  >
        <span>Pay Rent</span>
        
        <img src="https://i.cloudup.com/2ZAX3hVsBE-3000x3000.png" height="62" width="62"></button> 
      </div>
    </div>

    <div id = "maintenance">
      <button v-on:click="$store.state.showForm = true" v-if="$store.state.showForm == false">Submit maintenance request</button>
      <maintenance-request-form v-if="$store.state.showForm" />
    </div>

    
  </div>
</template>

<script>
import MaintenanceRequestForm from "../components/MaintenanceRequestForm.vue";
import PropertyService from "../services/PropertyService";
import PropertySmallDetail from './PropertySmallDetail.vue';
export default {
  components: {PropertySmallDetail, MaintenanceRequestForm},
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

#grid {
  display: grid;
  gap: 30px;
  justify-content: center;
  grid-template-areas:
    "renterProperty rentStatus "
    "maintenance maintenance";
}

#renterProperty {
  grid-area: "renterProperty";
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 22px;
}
#rentStatus {
  grid-area: "rentStatus";
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

}
#maintenance {
  grid-area: "maintenance";
}
.unpaid {
  color: red;
}
.paid {
  color: green;
}
label {
  display: flex;
  flex-direction: column;
  text-align: center;
  margin-right: 300px;
  font-size: larger;
}
.placeholder{
 position: fixed;
  top: 150px;
  margin-right: 120px;
}

.btnClicked {
  display: none;
}



@-webkit-keyframes extend {
    0% {
        width: 300px;
        height: 100px;
        border-radius: 50px;
        } 10% {
        width: 300px;
        height: 100px;
        background: #fff;
        margin-left: - 5px;
        margin-top: - 5px;
        } 20% {
        width: 300px;
        height: 100px;
        background: #6fb07f;
        margin-left: 0px;
        margin-top: 0px;
        } 100% {
        width: 100px;
        height: 100px;
        border-radius: 100px;
        margin-left: 190px;
        background: #6fb07f;
        }
    }
@keyframes extend {
    0% {
        width: 300px;
        height: 100px;
        border-radius: 50px;
        } 10% {
        width: 300px;
        height: 100px;
        background: #fff;
        margin-left: - 5px;
        margin-top: - 5px;
        } 20% {
        width: 300px;
        height: 100px;
        background: #6fb07f;
        margin-left: 0px;
        margin-top: 0px;
        } 100% {
        width: 100px;
        height: 100px;
        border-radius: 100px;
        margin-left: 190px;
        background: #6fb07f;
        }
    }

@-webkit-keyframes disappear {
    0% {
        opacity: 1;
        } 20% {
        color: #fff;
        } 100% {
        opacity: 0;
        }
    }
@keyframes disappear {
    0% {
        opacity: 1;
        } 20% {
        color: #fff;
        } 100% {
        opacity: 0;
        }
    }

@-webkit-keyframes appear {
    0% {
        opacity: 0;
        } 70% {
        opacity: 0;
        } 100% {
        opacity: 1;
        }
      
    }
@keyframes appear {
    0% {
        opacity: 0;
        } 70% {
        opacity: 0;
        } 100% {
        opacity: 1;
        }
     
    }
html {
    background: #fff
    }

input, button, submit {
    border: none
    }

.cont {
    /* position: ; */
    /* width: 300px;
    height: 5px;
    left: 50%;
    top: 50%;
    margin: -100px 0 0 -300px */
    }

#payRent {
    border-width: 1px;
    width: 300px;
    height: 100px;
    /*border-radius*/
    border-radius: 100px;
    background: #fff;
    position: absolute;
    border: 5px solid #6fb07f;
    }

#payRent  > span {
    font-size: 48px;
    color: #6fb07f
    }

img {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
    filter: alpha(opacity=0);
    opacity: 0
    }

#payRent:focus {
    /*animation*/
    -webkit-animation: extend 1s ease-in-out;
    -ms-animation: extend 1s ease-in-out;
    animation: extend 1s ease-in-out;
    -webkit-animation-fill-mode: forwards;
    /* Chrome, Safari, Opera */
    animation-fill-mode: forwards
    }

#payRent:focus > span {
    /*animation*/
    -webkit-animation: disappear 1s ease-in-out;
    -ms-animation: disappear 1s ease-in-out;
    animation: disappear 1s ease-in-out;
    -webkit-animation-fill-mode: forwards;
    /* Chrome, Safari, Opera */
    animation-fill-mode: forwards
    }

#payRent:focus > img {
    /*animation*/
    -webkit-animation: appear 1s ease-in-out;
    -ms-animation: appear 1s ease-in-out;
    animation: appear 1s ease-in-out;
    -webkit-animation-fill-mode: forwards;
    /* Chrome, Safari, Opera */
    animation-fill-mode: forwards
    }

#amount-due {
  display: flex;
  flex-direction: column;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 26px;
  margin: 35px;
}

.invisible{
  animation: hideAnimation 0s ease-in 3s;
  animation-fill-mode: forwards;
}

@keyframes hideAnimation {
  to {
    visibility: hidden;
    width: 0;
    height: 0;
  }
}


</style>