<template>
   <v-container >
     <v-card
    class="mx-auto"
  >
    <v-img
      :src= 'ingredients[0].prod_img'
      :height="heights"
    ></v-img>

    <v-card-title>
      {{ingredients[0].prod_name}}
    </v-card-title>

    <v-card-subtitle>
      유통기한 : {{ingredients[0].prod_exp}} 까지
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
          height:0
        
        }
        
    },
    computed:{
      heights () {
        switch (this.$vuetify.breakpoint.name) {
          case 'xs': return 160
          case 'sm' : return 350
          case 'md': return 400
          case 'lg': return 400
          case 'xl': return 600
        }}
    },
    methods :{
      useIngredient(){
        axios.get('/myrefrigerator/deleteMyRefrigerator?detail_id='+ this.ingredients.detail_id)
        .then(res =>{ 
          console.log(res)
        })
        .catch(error => 
            console.log(error))
      
        this.$router.push('/Myrefrigerator');
        console.log("home");
      },
      getIndredient(){
        console.log("start");
        axios.get('/myrefrigerator/infoIngre?detail_id='+this.Recipe_id)
        .then(res =>{ 
          this.ingredients = res.data.result;
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