<template>
   <v-container >
     <v-card
    class="mx-auto"
  >
    <v-img
      :src= 'ingredients.prod_img'
      max-height="200px"
    ></v-img>

    <v-card-title>
      {{ingredients.prod_name}}
    </v-card-title>

    <v-card-subtitle>
      유통기한 : {{ingredients.prod_exp}} 까지
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
import axios from 'axios'
export default {
    name: 'Ingredient',
    data(){
        return{
          Recipe_id : this.$route.params.id, 
          show: false,
          ingredients:[],
        }
    },
    methods :{
      useIngredient(){
        this.$router.push('/Myrefrigerator');
        console.log("home");
      },
      getIndredient(){
        console.log("start");
        axios.get('http://10.1.4.112:9999/myrefrigerator/myrefrigerator?uid=2')
        .then(res =>{ 
          this.ingredients=res.data.result[this.Recipe_id];
          console.log(this.ingredients)
        })
        .catch(error => 
            console.log(error))
        },

    },
    created(){
      this.getIndredient();
    }
}

</script>

<style scoped>
</style>