<template>
   <v-container >
    <v-card-title class="primary--text" >
       {{user_name}} 님의 냉장고 현황
     </v-card-title>
     <hr/>
  </v-container>
</template>

<script>
export default {
  name: 'Myrefrigerator',
  data(){
    return{
      user_name : "최세민"
    }
  }
}
</script>

<style scoped>

</style>
