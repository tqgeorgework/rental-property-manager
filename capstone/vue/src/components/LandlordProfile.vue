
<template>
  <div>
    <span style="font-size: 1.5em"></span>
    <!-- {{ $store.getters.role }} -->

    <!-- <property-add-form v-if="$store.state.showForm" /> -->
    <landlord-request-list />
    <div>
      <h1>Your Properties:</h1>
      <div id="button">
        <router-link :to="{ name: 'add-property' }">
          <button onclick="blur()">Add Property</button>
        </router-link>
      </div>
      <landlord-listings />
    </div>
  </div>
</template>
<script>
import LandlordListings from "./LandlordListings.vue";
// import PropertyAddForm from "./PropertyAddForm.vue";
import LandlordRequestList from "./LandlordRequestList.vue";

export default {
  components: { LandlordListings, LandlordRequestList },
  name: "landlord-profile",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Orbitron:wght@900&display=swap");
div {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-items: center;
}

h1 {
  font-size: 44px;
}

#button {
  display: flex;
  align-items: center;
}

button {
  position: relative;
  padding: 4px 20px;
  width: 20vw;
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
</style>