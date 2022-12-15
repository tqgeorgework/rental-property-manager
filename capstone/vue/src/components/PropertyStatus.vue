<template>
  <div>
    <div v-show="curProperty.rentStatus == 'PAID'">
      <p v-show="getDaysUntilDue == 'Today!'">Rent is TODAY!</p>
      <p v-show="getDaysUntilDue != 'Today!'">
        Rent is due in {{ getDaysUntilDue }} days.
      </p>
    </div>
    <div v-show="curProperty.rentStatus != 'PAID'">
       <p>Rent is {{curProperty.rentStatus}}!</p> 
    </div>
  </div>
</template>

<script>
export default {
  date() {
    return {
      
    };
  },

  props: ["curProperty"],
  computed: {
    getDaysUntilDue() {
      let todayDate = new Date();
      let dueDate = new Date(
        todayDate.getFullYear(),
        todayDate.getMonth(),
        14
      );
      let todayDay = todayDate.getDate();
      let dueDay = dueDate.getDate();
      let lastDayOfCurrentMonth = new Date(
        todayDate.getFullYear(),
        todayDate.getMonth() + 1,
        0
      ).getDate();

      if (todayDay < dueDay) {
        return dueDay - todayDay;
      } else if (todayDay > dueDay) {
        return lastDayOfCurrentMonth + (dueDay - todayDay);
      } else {
        return "Today!";
      }
    },
  },
};
</script>

<style>
</style>