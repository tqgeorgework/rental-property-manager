<template>
  <div>
      <router-link :to="{name:'property-detail', params:{ID: singleProperty.propertyID}}">
      <img :src="singleProperty.picURL" />
      <div>{{ singleProperty.address }}</div>
      <div>${{ singleProperty.price }}/Month</div>
      </router-link>
  </div>
</template>

<script>
export default {
    name: 'property-small-detail',
    props: ['singleProperty']
}
</script>

<style scoped>
  div {
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  }


  img {
    width: 30vw;
  }
</style>