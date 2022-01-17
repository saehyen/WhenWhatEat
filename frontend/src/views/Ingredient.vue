<template>
   <v-container >
     <v-card
    class="mx-auto"
  >
    <v-img
      src="https://cdn.pixabay.com/photo/2015/09/30/10/03/of-965193__480.jpg"
      max-height="200px"
    ></v-img>

    <v-card-title>
      {{Recipe_id}}번 재료 재료이름 표시
    </v-card-title>

    <v-card-subtitle>
      {{Recipe_id}}번 재료 유통기한 및 남은 시간 표시하는곳
    </v-card-subtitle>

    <v-card-actions>
      

      
      <v-btn
        color="orange darken-2"
        text
        @click="show = !show"
      >
        레시피목록
      </v-btn>
      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn
        color="orange darken-2"
        text
        @click="useIngredient()"
      >
        재료 사용완료
        
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
          {{Recipe_id}}번 재료 레시피들
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
  </v-container>
</template>

<script>
export default {
    name: 'Ingredient',
    data(){
        return{
          Recipe_id : this.$route.params.id, 
          show: false,
        }
    },
    methods :{
      useIngredient(){
        this.$router.push('/Myrefrigerator');
        console.log("home");
        
      }
    }
}

</script>

<style scoped>
</style>