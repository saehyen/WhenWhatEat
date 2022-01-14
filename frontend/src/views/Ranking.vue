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
              <v-row>
                <v-col class="ma-1" >
                  <v-rating 
                    empty-icon="🤍"
                    full-icon="💛"
                    readonly
                    length="5"
                    size="15"
                    :value="card.ratio"
                  ></v-rating> 
              </v-col>
              <v-col class="ma-2 text-right">
                <span> 조회수 : {{card.views}}</span>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
      <div class="text-center">
    <v-pagination
      v-model="page"
      :length="4"
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
    rating: 3.5,
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
      headers: [
        {
          text: 'Dessert (100g serving)',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: 'Calories', value: 'calories' },
        { text: 'Fat (g)', value: 'fat' },
        { text: 'Carbs (g)', value: 'carbs' },
        { text: 'Protein (g)', value: 'protein' },
        { text: 'Iron (%)', value: 'iron' },
      ],
      desserts: [
        {
          name: 'Frozen Yogurt',
          calories: 159,
          fat: 6.0,
          carbs: 24,
          protein: 4.0,
          iron: '1%',
        },
        {
          name: 'Ice cream sandwich',
          calories: 237,
          fat: 9.0,
          carbs: 37,
          protein: 4.3,
          iron: '1%',
        },
        {
          name: 'Eclair',
          calories: 262,
          fat: 16.0,
          carbs: 23,
          protein: 6.0,
          iron: '7%',
        },
        {
          name: 'Cupcake',
          calories: 305,
          fat: 3.7,
          carbs: 67,
          protein: 4.3,
          iron: '8%',
        },
        {
          name: 'Gingerbread',
          calories: 356,
          fat: 16.0,
          carbs: 49,
          protein: 3.9,
          iron: '16%',
        },
        {
          name: 'Jelly bean',
          calories: 375,
          fat: 0.0,
          carbs: 94,
          protein: 0.0,
          iron: '0%',
        },
        {
          name: 'Lollipop',
          calories: 392,
          fat: 0.2,
          carbs: 98,
          protein: 0,
          iron: '2%',
        },
        {
          name: 'Honeycomb',
          calories: 408,
          fat: 3.2,
          carbs: 87,
          protein: 6.5,
          iron: '45%',
        },
        {
          name: 'Donut',
          calories: 452,
          fat: 25.0,
          carbs: 51,
          protein: 4.9,
          iron: '22%',
        },
        {
          name: 'KitKat',
          calories: 518,
          fat: 26.0,
          carbs: 65,
          protein: 7,
          iron: '6%',
        },
      ],
    }
  }
}
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>
