<template>
   <v-container >
    <v-card-title class="primary--text" >
       Recipe
    </v-card-title>
    <!--==================카테고리=====================  -->
    <v-row justify="space-around">
    <v-col
      cols="12"
    >
      <v-sheet
        elevation="3"
        class="py-4 px-1"
        rounded
      > 

        <v-chip-group
          multiple
          active-class="primary--text"
        ><span style="line-height:40px; padding:0 5px;"> 재료별 </span>
          <v-chip
            v-for="indredient in indredients"
            :key="indredient"
          >
            {{ indredient }}
          </v-chip>
        </v-chip-group>
         
         <v-chip-group
          active-class="primary--text"
        ><span style="line-height:40px; padding:0 5px;"> 소요시간 </span>
          <v-chip
            v-for="times in time_takens"
            :key="times"
          >
            {{ times }}
          </v-chip>
        </v-chip-group>
        <v-chip-group
          multiple
          active-class="primary--text"
        ><span style="line-height:40px; padding:0 5px;"> 난이도 </span>
          <v-chip
            v-for="difficulty in difficulties"
            :key="difficulty"
          >
            {{ difficulty }}
          </v-chip>
        </v-chip-group>
      </v-sheet>
    </v-col>
  </v-row>
  <!--==================카테고리끝=====================  -->
  <v-row>
  <v-col>
  <v-card-title class="primary--text" >
       총 <span style="text-decoration:underline">10000</span>개의 레시피가 검색되었습니다
  </v-card-title>
  
  </v-col>
  
  <v-col align="right"
        justify="right">
        <v-btn-toggle  align="right"
          justify="right"
          v-model="toggle_exclusive"
          mandatory
          @change="SortPick"
        >
          <v-btn position:absolute right >최신순</v-btn>
          <v-btn right> 추천순</v-btn>
        </v-btn-toggle>
      </v-col>
  </v-row>
  <hr/>
  <!-- 검색된 레시피 출력하는 곳 -->
  <v-sheet
        elevation="3"
        class="py-1 px-1"
        rounded
  > 
  <!-- 92번째 줄 cards에서 recipeList로 수정함 / title => name, src => img, ratio => rate 이렇게 db에 있는 값 이름으로 처리 -->
    <v-card-title class="primary--text" >
       Ranking
     </v-card-title>
    <v-row dense class="ma-1 ">
        <v-col 
         class="pa-2"
          outlined
          tile
          
          v-for="card in recipeList"
          :key="card.num"
          :md="4"
          :sm="12"
          :xs="12"
        >
          <v-card 
          >
            <v-img 
              :src="card.img"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="125px"
            >
             <!-- <v-card-subtitle >{{ new Date().getYear()+1900 }}년{{ new Date().getMonth()+1 }}월{{ new Date().getDate() }}일까지 </v-card-subtitle> -->
            </v-img>
            <v-card-subtitle class="font-weight-black">{{card.name}}</v-card-subtitle>
              <v-row class="ma-1">
                <v-col>
                  <v-rating
                    v-model="rating"
                    background-color="yellow"
                    color="yellow"
                    readonly
                    size="15"
                    :value="card.rate"
                  ></v-rating>    
                </v-col>
                <v-col>
                  <span style="font-size:12px">(10)  </span>
                  <span style="font-size:12px">조회수 : {{card.views}}</span>
                </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
      <div class="text-center">
        <v-pagination class="ma-8"
          v-model="page"
          :length="4"
          @input="handlePageChange"
          prev-icon="mdi-menu-left"
          next-icon="mdi-menu-right"
        ></v-pagination>
      </div>
  </v-sheet>
  <v-row>
    
    <v-col>
      
      
      
       
    </v-col>
  </v-row>
  <br/>  


  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Recipe',
  data: () => ({
      indredients: [
        '전체',
        '소고기',
        '돼지고기',
        '닭고기',
        '기타고기',
        '해물',
        '과일',
        '채소',
        '달걀/유제품',
        '가공식품류',
        '쌀',
        '밀가루',
        '곡류',
        '기타'
      ],
      time_takens:[
        '전체',
        '5분 이내',
        '10분 이내',
        '20분 이내',
        '30분 이내',
        '60분 이내',
        '90분 이내',
        '2시간 이내',
        '2시간 이상'
      ],
      difficulties:[
        '전체',
        '아무나',
        '초급',
        '중급',
        '고급',
        '초고수'
      ],

      // -------> recipeList
      recipeList: [],
      // <-----------------

      toggle_exclusive: undefined,
      currentPage: 1,
    page:1,
    rating: 4,
    emptyIcon: 'mdi-heart-outline',
    fullIcon: 'mdi-heart',
    halfIcon: 'mdi-heart-half',

    }),
    created() {
      this.getRecipeList();
    },
    methods: {

      // ----------------------->RecipeController에서 데이터 가져옴.
    getRecipeList() {
      axios.post('http://10.1.4.112:9999/recipe/get-recipe-list.do')
        .then((response) => {
          if (response.data.success) {
            console.log(response.data.result);
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },

      SortPick(){
      console.log("clicked! : "+ this.toggle_exclusive);
    }

    // <------------------------------------------------------
    

  }
}
</script>

<style scoped>
</style>
