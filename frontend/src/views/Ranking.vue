<template>
   <v-container >
     <v-card-title class="primary--text" >
       Ranking
     </v-card-title>
    <v-row dense class="ma-1 ">
        <v-col 
         class="pa-2"
          outlined
          tile
          v-for="card in recipeList.slice((currentPage-1)*9,(currentPage)*9)"
          :key="card.num"
          :md="4"
          :sm="12"
          :xs="12"
        >
         <v-card @click="godetail(card.id)"
          >
            <v-img 
              :src="card.img"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="125px"
            >
             <!-- <v-card-subtitle >{{ new Date().getYear()+1900 }}년{{ new Date().getMonth()+1 }}월{{ new Date().getDate() }}일까지 </v-card-subtitle> -->
            </v-img>
            <v-card-subtitle style="text-overflow: ellipsis; white-space:nowrap; overflow:hidden;" class="font-weight-black">{{card.name}}</v-card-subtitle>
              <v-row class="ma-1">
                <v-col cols="5">
                  <v-rating
                    v-model="card.rate"
                    background-color="orange"
                    color="orange darken-3"
                    readonly
                    size="15"
                  ></v-rating>    
                </v-col>
                <v-col cols="3" >
                  <span style="font-size:12px">{{card.rate }} </span>
                  <span style="font-size:12px">({{card.rate_count }}) </span>
                   </v-col>
                <v-col >
                  <span style="font-size:12px">조회수 : {{card.views}}</span>
                </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
      <div class="text-center">
        <v-pagination class="ma-8"
          v-model="page"
          :length= Math.ceil(lengths/9)
          @input="handlePageChange"
          prev-icon="mdi-menu-left"
          next-icon="mdi-menu-right"
        ></v-pagination>
      </div>
      <v-spacer/>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Ranking',
  data () {
      return {
    currentPage: 1,
    page:1,
    rating: 4,
    recipeList:[],
    emptyIcon: 'mdi-heart-outline',
    fullIcon: 'mdi-heart',
    halfIcon: 'mdi-heart-half',
    lengths : 0,
    }
  },
  methods:{
    handlePageChange(value) {
      this.currentPage = value;
    },
    getRecipeList() {
      //axios.post('http://10.1.4.112:9999/recipe/rank')
      axios.post('http://52.79.230.195:8080/back/recipe/recipe.do')
        .then((response) => {
          if (response.data.success) {
            this.recipeList = response.data.result;
            this.lengths=response.data.result.length;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    godetail(id){
      this.$router.push('/Recipedetail/'+id);
    },
  },
  created() {
    this.getRecipeList();
  },
}
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>
