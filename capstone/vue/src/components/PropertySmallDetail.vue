<template>
  <div>
      <img :src="singleProperty.picURL" />
      <div>{{ singleProperty.address }}</div>
      <div>${{ singleProperty.price }}</div>
      <div>{{ singleProperty.bedrooms }} Bed</div>
      <div>{{ singleProperty.bathrooms }} Bath</div>
      <div>{{ singleProperty.sqFootage }} Sq. Ft.</div>
  </div>
</template>

<script>
export default {
    name: 'property-small-detail',
    props: ['singleProperty']
}
</script>

<style scoped>

</style>