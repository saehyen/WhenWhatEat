<template>
   <v-container >
    재료 디테일 화면 {{Recipe_id}}
  </v-container>
</template>

<script>
export default {
    name: 'Ingredient',
    data(){
        return{
          Recipe_id : this.$route.params.id, 
        }
    },
    methods :{
        
    }
}

</script>

<style scoped>
</style>