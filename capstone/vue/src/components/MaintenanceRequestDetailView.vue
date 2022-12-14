<template>
  <div id="detail-request-container">
    <div id=information-bar>
    <div>{{detailRequest.title}}asdf</div>
    <div>{{detailRequest.date}}asdf</div>
    <div>{{detailRequest.status}}asdf</div>
    <div>
      
    </div>
    </div>
    <div id="details">{{detailRequest.description}}</div>
    
    <div>
      <button @click="markComplete">Mark Complete</button>
    </div>
  </div>
</template>

<script>
export default {
data() {
  return {
    detailRequest: {}
  }
},
methods: {
  markComplete() {
    this.detailRequest.status = "COMPLETE"
    this.markComplete(this.detailRequest);
  }
},
created() {
  this.detailRequest;
}
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Orbitron:wght@900&display=swap");
#detail-request-container {
  display: flex;
  flex-direction: column;
}
#information-bar {
  display: flex;
    width: 700px;
  justify-content: space-between;
}

#information-bar:first-child {
  flex-grow: 4;
}

#details  {
  font: 18px "Orbitron";
}
</style>