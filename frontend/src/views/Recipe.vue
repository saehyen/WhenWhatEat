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
          v-model="ingredient_category"
          multiple
          active-class="primary--text"
          
        ><span style="line-height:40px; padding:0 5px;"> 재료별 </span>
          <v-chip
            v-for="indredient in indredients"
            :key="indredient"
            :value="indredient"
            @click="ingredient_category_sel"
          >
            {{ indredient }}
          </v-chip>
        </v-chip-group>
         
         <v-chip-group
          v-model="time_category"
          active-class="primary--text"
        ><span style="line-height:40px; padding:0 5px;"> 소요시간 </span>
          <v-chip
            v-for="times in time_takens"
            :key="times"
            :value="times"
            @click="time_category_sel"
          >
            {{ times }}
          </v-chip>
        </v-chip-group>
        <v-spacer/>
        <v-col>
        <v-btn class="py-4 px-1"
          width="100%"
          @click="category_select"
          elevation="2"
          style="margin:0 auto;"
        >분류</v-btn>
        </v-col>
      </v-sheet>
    </v-col>
      
  </v-row>
  <v-col></v-col>
  
  <!--==================카테고리끝=====================  -->
  <v-row>
  <v-col>
  <v-card-title class="primary--text" >
       총 <span style="text-decoration:underline"> {{lengths}} </span> 개의 레시피가 검색되었습니다
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
           <v-btn right> 조회순</v-btn>
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
                    background-color="orange "
                    color="orange darken-3"
                    readonly
                    size="15"
                    :value= card.rate
                  ></v-rating>    
                </v-col 
                  >
                <v-col cols="3">
                  <span style="font-size:12px">{{card.rate }} </span>
                  <span style="font-size:12px">({{card.rate_count }}) </span>
                   </v-col>
                <v-col>
                  <span style="font-size:12px">조회수 : {{card.views}}</span>
                </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
      <div class="text-center">
        <v-pagination class="ma-4"
          v-model="page"
          :length= Math.ceil(lengths/9)
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
      '고기',
      '해물',
      '채소',
      '과일',
      '밀가루',
      '쌀',
      '달걀/유제품',
      '콩/견과류',
      '가공식품',
      '김치/젓갈/장류',
      '버섯',
      '양념/소스',
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
    ingredient_category:[],
      // -------> recipeList
    recipeList: [],
      // <-----------------
    toggle_exclusive: undefined,
    time_category:"",
    currentPage: 1,
    page:1,
    rating: 4,
    rate_count:0,
    emptyIcon: 'mdi-heart-outline',
    fullIcon: 'mdi-heart',
    halfIcon: 'mdi-heart-half',
    lengths : 0,
    id : 0,
    
    }),
    created() {
      this.getRecipeList();
    },
    methods: {
    // 분류 버튼 눌렀을 때
    category_select(){
      console.log(this.ingredient_category.slice(0,this.ingredient_category.length));
      console.log(this.time_category);
      if(this.time_category.includes("전체")){
        console.log("시간전체선택");
      }
      if(this.ingredient_category == "전체"){
        console.log("재료전체선택");
      }
    },
    // 시간 선택
    time_category_sel(){
    },
    // 재료 선택
    ingredient_category_sel(){
      const params={
        'times_category' : this.ingredient_category.slice(0,this.ingredient_category.length),
        'category' : this.time_category
      }
      axios.post('http://52.79.230.195:8080/back/recipe/category',params)
        .then((response) => {
          if (response.data.success) {
            this.lengths = response.data.result.length;
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
      if(this.ingredient_category.includes("전체")){
        this.ingredient_category = []
        console.log("전체선택")
        console.log(this.ingredient_category)
      }
    },
    godetail(id){
      this.$router.push('/Recipedetail/'+id);
    },
      // ----------------------->RecipeController에서 데이터 가져옴.
    getRecipeList() {
      axios.post('http://52.79.230.195:8080/back/recipe/recipe')
        .then((response) => {
          if (response.data.success) {
            console.log(response.data.result);
            console.log(response.data.result.length);
            this.lengths = response.data.result.length;
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    SortPick(){
      console.log("clicked! : "+ this.toggle_exclusive);
      // 최신순
      if (this.toggle_exclusive==0) {
        axios.post('http://52.79.230.195:8080/back/recipe/recipe')
        .then((response) => {
          if (response.data.success) {
            this.lengths = response.data.result.length;
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
      }
      // 추천순
      else if(this.toggle_exclusive==1){
        axios.post('http://52.79.230.195:8080/back/recipe/recipeRate ')
        .then((response) => {
          if (response.data.success) {
            this.lengths = response.data.result.length;
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
      }
      // 조회순
      else if(this.toggle_exclusive==2){
        axios.post('http://52.79.230.195:8080/back/recipe/recipeViews')
        .then((response) => {
          if (response.data.success) {
            this.lengths = response.data.result.length;
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
      }
    },
    handlePageChange(value) {
      this.currentPage = value;
      console.log(this.currentPage);
    }

    // <------------------------------------------------------
    

  }
}
</script>

<style scoped>
</style>