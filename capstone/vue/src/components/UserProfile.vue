<template>
  <div>Placeholder {{$store.getters.role}} 
    <p>
   <br>
    <label :class="{'unpaid': !clicked, 'paid': clicked}">Amount Due: {{$store.getters.price}} </label>
   <br>
    <button v-on:click="clicked = !clicked">Pay Rent</button>
    </p>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      clicked: false
    }
  }

}
</script>

<style scoped>
.unpaid{
  color:red;
}
.paid{
  color:green;
}
div{
 display: flex;
 flex-direction: column;
 text-align: center;
}

</style>