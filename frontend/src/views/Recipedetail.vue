<template>
   <v-container >
     <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="1000"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img style="object-fit:cover"
      max-height="height+100"
      :src = recipe[0].img
    ></v-img>

    <v-card-title>{{recipe[0].name}}</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="recipe[0].rate"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ms-4">
        {{recipe[0].rate}} ({{recipe[0].rate_count}})
        </div>
      </v-row>

      <div class="my-4 text-subtitle-1">
        {{recipe[0].info1}} / {{recipe[0].info2}} /{{recipe[0].info3}}
      </div>

      <v-row dense class="ma-1 ">
        <v-col 
         class="pa-2"
          outlined
          tile
          v-for="list in lists"
          :key="list"
          :md="12"
          :sm="12"
          :xs="12"
        >
          <v-card 
          >
            <v-img 
                style="object-fit:cover"
              :src= list.detail_img
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="height"
            >
             <!-- <v-card-subtitle >{{ new Date().getYear()+1900 }}년{{ new Date().getMonth()+1 }}월{{ new Date().getDate() }}일까지 </v-card-subtitle> -->
            </v-img>
            <v-card-subtitle class="font-weight-black">{{list.detail_txt}}</v-card-subtitle>
              <v-row class="ma-1">
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>별점으로 평가하기</v-card-title>

    <v-card-text>
      <v-rating
          v-model="evaluate_rate"
          color="amber"
          dense
          half-increments
          size="14"
        ></v-rating>
    </v-card-text>

    <v-card-actions>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="evaluate"
      >
        평가하기
      </v-btn>
    </v-card-actions>
  </v-card>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
    name: 'Recipedetail',
    data(){
        return{
            srcs : "https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/94cb79b94ff3f1ee571e60cde1868c0c1.jpg",
            title:"비건 양배추롤, 건강하고 맛있는 새해 다이어트 레시피",
            detail_id:0,
            detail_txt:['끓는물에 소금을 약간 넣고 양배추 1/4통을 5분 삶아요','토마토 밑둥에 십자로 칼집을 내고, 끓는물에 1~2분 정도 데쳐요.',
            '데친 토마토는 찬물에 담가 잠시 식히고, 껍질을 벗겨요','토마토는 큼직하게 다지고 양파, 파프리카, 올리브는 잘게 다져요.','두부는 물기를 제거해 준비해요.',
            '볼에 두부, 양파, 파프리카, 블랙올리브, 소금, 후추를 버무려 반죽해요.','반죽을 한 입 크기로 만들고 양배추로 감싸 말아요.','냄비에 토마토소스, 토마토, 물, 소금, 후추를 넣어요.',
            '양배추롤을 넣고 10분간 끓여요.'],
            detail_img:['https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/d35ec24fe1a938d86ab5ae875d1606a91.jpg','https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/c6c450aacfe4a2b55aaa0e8b457cc30e1.jpg',
            'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/6730091a8e06963123068b8d3f56e33b1.jpg','https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/778e3108395084b6e84cbe245d74faab1.jpg'
            ,'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/0e56b4d44f2de3b56a67b2cfd5842cf91.jpg','https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/358e12df1c83d50b37aa29dc598484791.jpg',
            'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/85e96b7885c4e61fec609111694cddbe1.jpg','https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/3d3ada4813538bf4c5393dc020422c601.jpg',
            'https://recipe1.ezmember.co.kr/cache/recipe/2022/01/10/b188cfa7ffd4ea3d4487a2bcbbcbc61b1.jpg'],
            rate:4.9,
            rate_count:10,
            info1:"2인분",
            info2:"30분이내",
            info3:"아무나",
            views:100,
            post_date:"2022-01-13 12:09:51",
            Recipe_id : this.$route.params.id,
            lists:[],
            recipe:[],
            evaluate_rate:0,
            user_uid: this.$session.get('useruid'),
            result:3,
        }
    },
    methods :{
      evaluate(){
        console.log('별점 : ' + this.evaluate_rate + 'uid : ' + this.user_uid + '레시피아이디 : ' + this.Recipe_id)
        axios.get('http://52.79.230.195:8080/back/recipe/rate?uid=' + this.user_uid + '&recipe_id='+this.Recipe_id+'&rate='+this.evaluate_rate)
        .then(res =>{ 
          console.log(res.data)
          this.result=res.data
          if (this.result == 1 ) {
            alert("평가가 반영되었습니다.")
            this.$router.push('/Recipedetail/'+this.Recipe_id);
            this.$router.go();
          }
          else {
            alert("이미 평가된 레시피입니다.")
            this.$router.push('/Recipedetail/'+this.Recipe_id);
            this.$router.go();
            
          }
        })
        .catch(error => 
            console.log(error))
      },
      getRecipedetail(){
        axios.get('http://52.79.230.195:8080/back/recipe/recipeDetail?id='+this.Recipe_id)
        .then(res =>{ 
          this.lists = res.data.result;
        })
        .catch(error => 
            console.log(error))
        },
      getRecipe(){
        axios.get('http://52.79.230.195:8080/back/recipe/recipeInfo?id='+this.Recipe_id)
        .then(res =>{ 
          this.recipe = res.data.result;
        })
        .catch(error => 
            console.log(error))
        },
        height () {
        switch (this.$vuetify.breakpoint.name) {
          case 'xs': return 160
          case 'sm' : return 160
          case 'md': return 210
          case 'lg': return 215
          case 'xl': return 400
        }},
      },
    
    created() {
      this.getRecipedetail();
      this.getRecipe();
  }
}

</script>

<style scoped>
</style>