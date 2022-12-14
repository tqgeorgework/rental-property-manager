<template>
  <div id="app">
    <nav>
      <div id="top">
      <top-bar/>
      </div>
      <div id="view">
      <router-view/>
      </div>
      <div id="foot">
      <bottom-bar/>
      </div>
    </nav>
  </div>
</template>

<script>
import TopBar from "./components/TopBar.vue";
import BottomBar from "./components/BottomBar.vue";

export default {
  components: {
    TopBar, BottomBar
  }
}
</script>
<style>

#app {
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  display: grid;
  grid-template-areas:
  "top"
  "view"
  "foot";
}
#view {
  margin-top: 159px;
}
body {
  background-color: #EFF5F5
}

</style>