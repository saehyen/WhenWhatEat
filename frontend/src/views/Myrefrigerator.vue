<template>
  <div class="Myrefrigerator">
    <div class="wrap">
      <h2> {{user_name}} 님의 냉장고 현황</h2>
      <hr>
      <div class="ingredientlist">

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Myrefrigerator',
  data(){
    return{
      user_name : "하이"
    }
  }
}
</script>

<style scoped>
  .wrap {margin : 0 auto; max-width: 1400px; width:100%;}
  .Myrefrigerator .wrap .ingredientlist{ height: 500px; background-color:rgb(253, 247, 239)}
</style>
