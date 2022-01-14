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
          v-for="card in cards"
          :key="card.num"
          :md="4"
          :sm="12"
          :xs="12"
        >
          <v-card 
          >
            <v-img 
              :src="card.src"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="125px"
            >
             <!-- <v-card-subtitle >{{ new Date().getYear()+1900 }}년{{ new Date().getMonth()+1 }}월{{ new Date().getDate() }}일까지 </v-card-subtitle> -->
            </v-img>
            <v-card-subtitle class="font-weight-black">{{card.title}}</v-card-subtitle>
              <v-row class="ma-1">
                <v-col>
                  <v-rating
                    v-model="rating"
                    background-color="yellow"
                    color="yellow"
                    readonly
                    size="15"
                    :value="card.ratio"
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
      <v-spacer/>
  </v-container>
</template>

<script>
export default {
  name: 'Ranking',
  data () {
      return {
    currentPage: 1,
    page:1,
    rating: 4,
    emptyIcon: 'mdi-heart-outline',
    fullIcon: 'mdi-heart',
    halfIcon: 'mdi-heart-half',
    cards: [
      { title: '비건 양배추롤', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/94cb79b94ff3f1ee571e60cde1868c0c1.jpg',ratio:5,views:100 },
      { title: '쌀쌀한 날씨엔 얼큰한 김치우동', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/06/a618beda7fe0dbbf75575e25c974ac961.jpg',ratio:4,views:100},
      { title: '제철 회로 만든 초밥케이크', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/04/90cb72e7f7b37d917d375e61e3dc4f311.jpg',ratio:3,views:150  },
      { title: '비건 양배추롤', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/94cb79b94ff3f1ee571e60cde1868c0c1.jpg',ratio:5 ,views:100},
      { title: '쌀쌀한 날씨엔 얼큰한 김치우동', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/06/a618beda7fe0dbbf75575e25c974ac961.jpg',ratio:4,views:100},
      { title: '제철 회로 만든 초밥케이크', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/04/90cb72e7f7b37d917d375e61e3dc4f311.jpg',ratio:3,views:150  },
      { title: '비건 양배추롤', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/94cb79b94ff3f1ee571e60cde1868c0c1.jpg',ratio:5,views:100 },
      { title: '쌀쌀한 날씨엔 얼큰한 김치우동', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/06/a618beda7fe0dbbf75575e25c974ac961.jpg',ratio:4,views:100},
      { title: '제철 회로 만든 초밥케이크', src: 'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/04/90cb72e7f7b37d917d375e61e3dc4f311.jpg',ratio:3,views:150  },
      
      ],
     
    }
  },
  methods:{
    handlePageChange(value) {
      this.currentPage = value;
      console.log(this.currentPage);
    }
  }
}
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>
