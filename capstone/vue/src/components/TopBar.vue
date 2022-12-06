<template>
  <header id="page-header">
    <nav>
    <router-link :to="{ name: 'profile' }">Profile</router-link>
    <router-link :to="{ name: 'login' }" v-if="$store.state.token == ''">Login / Register</router-link>
    <router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <router-link :to="{ name: 'listings' }">Browse Listings</router-link>
    <router-link :to="{ name: 'maintenance' }" v-if="$store.state.token != ''">Maintenance</router-link>
    </nav>
    <img src="../../img/RPMLogo.png" />
    <h1 id="site-name">Rental Property Manager</h1>
    <menu class="quick-menu">
      <router-link :to="{ name: 'browse' }"
        ><font-awesome-icon icon="fa-solid fa-search" /></router-link>
      <router-link :to="{ name: 'maintenance' }"
        ><font-awesome-icon icon="fa-solid fa-wrench" />
      </router-link>
      <router-link :to="{ name: 'profile' }"
        ><font-awesome-icon icon="fa-solid fa-user-circle" />
      </router-link>
    </menu>
  </header>
</template>

<script>
export default {};
</script>

<style>

/* TODO */
/* Fix CSS and make design responsive for wrapping etc. */

a {
  color: rgb(0, 0, 0);

}

#site-name {
  font-size: 52px;
}

#page-header:nth-child(1),
a#page-header:nth-child(4) {
  flex-grow: 2;
}
#page-header:nth-child(2),
#page-header:nth-child(3) {
  flex-grow: 1;
}

#page-header {
  color: rgb(112, 21, 21);
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
  padding-left: 10px;
  padding-right: 10px;
  padding-bottom: 10px;
  margin-bottom: 5px;
  width: 100%;
  height: 15%;
  flex-wrap: wrap;
  grid-area: header;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  position: fixed;
  background-color: white;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;

}
#page-header img {
  height: 140px;
  margin-top: 10px;
}

#page-header nav {
  padding-left: 0;
}
#page-header nav {
  list-style-type: none;
  display: inline;
}
#page-header nav :not(:first-child):before {
  content: "";
  padding-right: 15px;
}
#page-header nav a {
  text-decoration: none;
  font-size: 20px;
}
#page-header nav a:hover {
  text-decoration: underline;
}

.quick-menu {
  font-size: 36px;
}
</style>