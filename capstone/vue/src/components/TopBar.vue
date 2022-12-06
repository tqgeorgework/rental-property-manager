<template>
  <header id="page-header">
    <router-link :to="{ name: 'home' }">Home</router-link>
    <router-link :to="{ name: 'login' }">Login/Register</router-link>
    <router-link :to="{ name: 'listings' }">Browse Listings</router-link>
    <router-link :to="{ name: 'maintenance' }">Maintenance</router-link>
    <img src="img/RPMLogo.png" />
    <h1 id="site-name">Rental Property Manager</h1>
    <menu>
      <router-link :to="{ name: 'browse' }"
        ><i class="fa fa-search" style="font-size: 36px"></i
      ></router-link>
      <router-link :to="{ name: 'maintenance' }"
        ><i class="fa fa-wrench" style="font-size: 36px"></i
      ></router-link>
      <router-link :to="{ name: 'profile' }"
        ><i class="fa fa-user-circle" style="font-size: 36px"></i
      ></router-link>
    </menu>
  </header>
</template>

<script>
export default {};
</script>

<style>

a {
  color: rgb(0, 0, 0);
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
  color: rgb(0, 0, 0);
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
  padding-left: 10px;
  padding-right: 10px;
  padding-bottom: 10px;
  margin-bottom: 5px;
  width: 100%;
  flex-wrap: wrap;
  grid-area: header;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  position: fixed;
  background-color: white;
}
#page-header img {
  height: 90px;
  margin-top: 10px;
}

#page-header nav ul {
  padding-left: 0;
}
#page-header nav li {
  list-style-type: none;
  display: inline;
}
#page-header nav li:not(:first-child):before {
  content: " ";
  padding-right: 15px;
}
#page-header nav li a {
  text-decoration: none;
}
#page-header nav li a:hover {
  text-decoration: underline;
}

</style>