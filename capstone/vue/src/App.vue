<template>
  <div id="app">
    <div id="nav">
      <top-bar/>
      <router-view/>
      <bottom-bar/>
      <!-- <router-link :to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
  </div>
</template>

<script>
import TopBar from "./components/TopBar.vue";

export default {
  components: {
    TopBar,
  }
}
</script>