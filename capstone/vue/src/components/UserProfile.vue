<template>
  <div>Placeholder {{$store.getters.role}} 
    <p>
   <br>
    <label :class="{'unpaid': !clicked, 'paid': clicked}">Amount Due: {{userProperty.price}} </label>
   <br>
    <button v-on:click="clicked = !clicked">Pay Rent</button>
    </p>
  </div>
  
</template>

<script>
import PropertyService from '../services/PropertyService';
export default {
  data() {
    return {
      clicked: false,
      userProperty: {
        price: 0
      }
    }
  },
methods: {
  getRent(){
    PropertyService.getPropertyByRenter().then((response)=> {
      this.userProperty = response.data;
      
    })
  }
},
created(){
  this.getRent();
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