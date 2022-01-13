<template>
   <v-container >
    <v-card-title class="primary--text" >
      {{user_name}} 님의 냉장고 현황
      <!-- 오른쪽 정렬을 위한 스페이서 -->
       <v-spacer/>
      <!-- 플러스 버튼  -->
      <v-row>
        <v-spacer/>
      <v-btn
        color="primary"
        class="ma-2"
        dark
        @click="dialog2 = true"
      > 
      <v-icon> mdi-plus </v-icon>
      </v-btn>
     <v-dialog
        align="center"
        v-model="dialog2"
        max-width="315px"
      >
        <v-card>
          <v-card-title>
            재료추가
          </v-card-title>
          <v-card-text>
            <v-select
              v-model="selingredient"
              :items="select"
              label="재료를 선택하세요"
              item-value="text"
              style="width:280px"
            ></v-select>
             
          </v-card-text>
          <v-card-title>유통기한 선택</v-card-title>
          
         
          <v-date-picker class="pa-3" v-model="picker"></v-date-picker>
          
          <v-card-actions>
            <v-btn
              color="primary"
              text
              @click="addingredient()"
            >
              재료 추가
            </v-btn>
             <v-btn
              color="primary"
              text
              @click="dialog2 = false"
            >
              닫기
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
      </v-row>
    </v-card-title>
     <hr/>
     
     <v-row dense>
        <v-col 
          v-for="card in cards"
          :key="card.num"
          :md="2"
          :sm="4"
          :xs="6"
        >
          <v-card v-if="card.num!=0"
          >
            <v-img 
              :src="card.src"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="125px"
            >
              <v-card-title v-text="card.title"></v-card-title>
              <v-card-subtitle >{{ card.expiration_date }}까지 </v-card-subtitle>
             <!-- <v-card-subtitle >{{ new Date().getYear()+1900 }}년{{ new Date().getMonth()+1 }}월{{ new Date().getDate() }}일까지 </v-card-subtitle> -->
            </v-img>
          </v-card>
        </v-col>
      </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Myrefrigerator',
  data(){
    return{
      cards: [
    { title: '가쓰오부시', src: 'https://cdn.pixabay.com/photo/2015/09/30/10/03/of-965193__480.jpg', expiration_date:"2022-01-25" },
    { title: '간장', src: 'https://cdn.pixabay.com/photo/2019/11/25/15/22/soy-sauce-4652303__480.jpg', expiration_date:"2022-01-28" },
    { title: '강력분', src: 'https://cdn.pixabay.com/photo/2016/08/09/22/23/flour-1581967__480.jpg', expiration_date:"2022-01-29"  },
    { title: '견과류' , src: 'https://cdn.pixabay.com/photo/2017/05/14/16/52/walnuts-2312506__340.jpg', expiration_date:"2022-01-25"  },
    { title: '계란' , src: 'https://cdn.pixabay.com/photo/2016/07/11/19/40/eggs-1510449__480.jpg', expiration_date:"2022-01-25" },
    { title: '고다치즈' , src: 'https://cdn.pixabay.com/photo/2017/01/11/19/56/cheese-1972744__480.jpg', expiration_date:"2022-01-25" },
    { title: '고추기름', src: 'https://cdn.pixabay.com/photo/2016/08/15/20/29/olive-oil-1596417__340.jpg', expiration_date:"2022-01-25" },
    { title: '고춧가루', src: 'https://cdn.pixabay.com/photo/2017/05/23/03/19/red-pepper-2336042__340.jpg', expiration_date:"2022-01-25" },
    { title: '과일치즈', src: 'https://cdn.pixabay.com/photo/2020/05/03/13/23/cheese-5125021__340.jpg', expiration_date:"2022-01-25" },
    { title: '광어회', src: 'https://cdn.pixabay.com/photo/2017/02/14/01/39/flounder-times-2064403__340.jpg', expiration_date:"2022-01-25" },
    { title: '국간장', src: 'https://cdn.pixabay.com/photo/2016/03/31/18/17/asian-1294266__340.png', expiration_date:"2022-01-25" },
    { title: '굴소스', src: 'https://cdn.pixabay.com/photo/2014/12/22/00/04/bottle-576717__480.png', expiration_date:"2022-01-25"}
    ],
      user_name : "백동채",
      selingredient : '',
      dialog2: false,
      notifications: false,
      sound: true,
      widgets: false,
      picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      items: [
        {
          title: 'Click Me',
        },
        {
          title: 'Click Me',
        },
        {
          title: 'Click Me',
        },
        {
          title: 'Click Me 2',
        },
      ],
      select: [
        { text: '가쓰오부시' },
        { text: '간장' },
        { text: '강력분' },
        { text: '견과류' },
        { text: '계란' },
        { text: '고다치즈' },
        { text: '고추기름' },
        { text: '고춧가루' },
        { text: '과일치즈' },
        { text: '광어회' },
        { text: '국간장' },
        { text: '굴소스' },
        { text: '김밥김' },
        { text: '김치' },
        { text: '까망베르치즈' },
        { text: '꽈리고추' },
        { text: '꿀' },
        { text: '노르웨이고등어' },
        { text: '녹인무염버터' },
        { text: '녹차가루' },
        { text: '다진마늘' },
        { text: '다진생강' },
        { text: '달걀' },
        { text: '달걀노른자' },
        { text: '닭볶음탕용닭' },
        { text: '당근' },
        { text: '대파' },
        { text: '데운우유' },
        { text: '데친두부' },
        { text: '돼지고기' },
        { text: '두부' },
        { text: '따뜻한물' },
        { text: '딸기' },
        { text: '레몬' },
        { text: '레몬즙' },
        { text: '로즈마리' },
        { text: '로투스' },
        { text: '마늘' },
        { text: '마요네즈' },
        { text: '만두' },
        { text: '맛술' },
        { text: '매실청' },
        { text: '멸치액젓' },
        { text: '모짜렐라치즈' },
        { text: '무순' },
        { text: '무염버터' },
        { text: '물' },
        { text: '물3+1/2종이컵' },
        { text: '밀가루' },
        { text: '바나나' },
        { text: '바닐라아이스크림' },
        { text: '바닐라익스트랙' },
        { text: '박력분' },
        { text: '밥' },
        { text: '방어회' },
        { text: '버터' },
        { text: '버터개당' },
        { text: '버터또는식용유' },
        { text: '볶은콩가루' },
        { text: '부추' },
        { text: '브리치즈' },
        { text: '블랙올리브' },
        { text: '블루베리' },
        { text: '빨간파프리카' },
        { text: '사과' },
        { text: '설탕' },
        { text: '소금' },
        { text: '소세지' },
        { text: '순두부' },
        { text: '슈가파우더' },
        { text: '시나몬파우더' },
        { text: '시래기' },
        { text: '식용유' },
        { text: '식초' },
        { text: '실파' },
        { text: '쌀' },
        { text: '쑥가루' },
        { text: '쑥갓' },
        { text: '아메리카노' },
        { text: '애호박' },
        { text: '양배추' },
        { text: '양송이버섯' },
        { text: '양파' },
        { text: '어묵' },
        { text: '연어회' },
        { text: '오트밀' },
        { text: '올리고당' },
        { text: '올리브' },
        { text: '올리브오일' },
        { text: '우동면' },
        { text: '우동사리' },
        { text: '우유' },
        { text: '유부채' },
        { text: '이스트' },
        { text: '잭치즈' },
        { text: '짜장가루' },
        { text: '쪽파' },
        { text: '참기름' },
        { text: '참돔회' },
        { text: '찹쌀가루' },
        { text: '청양고추' },
        { text: '체다치즈' },
        { text: '치킨스톡또는다시다' },
        { text: '코코아파우더' },
        { text: '크림치즈' },
        { text: '토마토' },
        { text: '토마토소스' },
        { text: '통깨' },
        { text: '통밀식빵' },
        { text: '팬케이크믹스' },
        { text: '팽이버섯' },
        { text: '페페론치노' },
        { text: '표고버섯' },
        { text: '프로슈토' },
        { text: '플레인요거트' },
        { text: '허브' },
        { text: '호두' },
        { text: '홍고추' },
        { text: '황설탕' },
        { text: '후추' },
        { text: '훈제오리' },
      ],
    addingredient(){
      console.log("hi");
      console.log(this.selingredient);
      console.log(this.picker);
      this.dialog2= false;
    }  
    }
    
  },
  method:{
    
  }
}
</script>

<style scoped>

</style>
