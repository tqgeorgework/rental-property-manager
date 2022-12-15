<template>
  <header id="page-header">
    <nav>
      <div id="link-container" v-show="true">
        <div v-if="$store.state.token != ''">
          <router-link :to="{ name: 'profile' }">Profile</router-link
          >&nbsp;|&nbsp;
        </div>

        <div>
          <router-link :to="{ name: 'listings' }">Browse Listings</router-link
          >&nbsp;|&nbsp;
        </div>
        <span v-if="$store.state.token == ''"></span>
        <div v-else-if="$store.getters.role == 'ROLE_LANDLORD'">
          <router-link :to="{ name: 'add-property' }"
            >Add Properties</router-link
          >&nbsp;|&nbsp;
        </div>
        <span v-if="$store.state.token == ''"></span>
        <div v-else-if="$store.getters.role == 'ROLE_LANDLORD'">
          <router-link :to="{ name: 'request-detail' }">Maintenance</router-link>&nbsp;|&nbsp;
        </div>
        <span v-if="$store.state.token == ''"></span>
        <div v-else-if="isUser" :isUser="setRentedPropertyID">
          <router-link :to="{ name: 'maintenance', params: {'propID': `${this.propertyID}`}}">Maintenance</router-link>&nbsp;|&nbsp;
        </div>
        <div v-if="$store.state.token == ''">
          <router-link :to="{ name: 'login' }">Login / Register</router-link>
        </div>
        <div v-if="$store.state.token != ''">
          <router-link :to="{ name: 'logout' }">Logout</router-link>
        </div>
      </div>
    </nav>
    <img src="../../img/OrgLogo.png" />
    <h1 id="site-name">Rent<span style="font-size: 1.2em">TE</span>nant</h1>
    <menu class="quick-menu">
      <router-link
        v-if="$store.state.token != ''"
        id="profile-shortcut"
        :to="{ name: 'profile' }"
        ><i class="fas fa-user-circle" />
      </router-link>
      <router-link id="listings-shortcut" :to="{ name: 'listings' }"
        >
        <i class="fas fa-house" />
      </router-link>

      <router-link
        v-if="$store.state.token != ''"
        id="logout-shortcut"
        :to="{ name: 'logout' }"
        ><i class="fas fa-sign-out" />
      </router-link>
    </menu>
  </header>
</template>

<script>
import PropertyService from '../services/PropertyService';
export default {
  data() {
    return {
      propertyID: 0,
    }
  },
  methods: {
    setRentedPropertyID() {
      let output = {
        propertyID: 0,
      };
      PropertyService.getPropertyByRenter().then(
        (response) => {
          if (response.status === 200) {
            output = response.data;
          }
        }
      );
      this.propertyID = output.propertyID;
    }
  },
  computed: {
    isUser() {
      return this.$store.getters.role == 'ROLE_USER';
    },
    getPropertyID() {
      this.setRentedPropertyID;
      return this.propertyID;
    }
  },
};
</script>

<style>
/* TODO */
/* Fix CSS and make design responsive for wrapping etc. */

a {
  color: rgb(0, 0, 0);
  text-decoration: none;
}
a:hover {
  color: rgb(221, 73, 19);
  text-decoration: underline;
}

#site-name {
  font-size: 65px;
  filter: drop-shadow(5px 10px 5px #806819);
}

#page-header:nth-child(1),
a#page-header:nth-child(4) {
  flex-grow: 2;
}
#page-header:nth-child(2),
#page-header:nth-child(3) {
  flex-grow: 1;
}

#link-container {
  display: flex;
}

#page-header {
  /* color: rgb(112, 21, 21); */
  animation: color-change 8s infinite;
  box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12),
    0 2px 4px -1px rgba(0, 0, 0, 0.2);

  margin-top: -10px;
  padding-bottom: 10px;
  margin-bottom: 5px;
  margin-left: -5px;
  width: 100vw;
  height: 140px;

  display: flex;
  justify-content: space-evenly;
  align-items: center;
  position: fixed;
  background-color: white;
  font-family: Impact, Haettenschweiler, "Arial Narrow Bold", sans-serif;
}
#page-header img {
  /* filter: drop-shadow(0px 1px 15px #806819); */
  height: 140px;
  margin-top: 10px;
  /* animation: rotation 25s infinite alternate; */
  animation: rotation 20s linear 40s alternate infinite;
}

/* #page-header nav :not(:first-child):before {
   content: " |";
  padding-right: 10px;
} */
#page-header nav a {
  text-decoration: none;
  font-size: 20px;
}
#page-header nav a:hover {
  text-decoration: underline;
}

.quick-menu {
  display: grid;
  grid-template-areas: "search-shortcut, maintenance-shortcut, profile-shortcut";
  font-size: 36px;
  margin-right: 10px;
}

@keyframes rotation {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}

@keyframes rotation {
  80% {
    transform: translateX(0vw) rotateZ(0deg);
  }

  20% {
    transform: translateX(345px) rotateZ(360deg);
  }

  40% {
    transform: translateX(345px) rotateZ(360deg);
  }
}

@keyframes color-change {
  0% {
    color: rgb(112, 21, 21);
  }
  50% {
    color: black;
  }
  100% {
    color: rgb(6, 58, 4);
  }
}
</style>

