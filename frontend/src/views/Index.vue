<template>
   <v-container >
      <v-container fluid>
      <v-row dense>
        <v-col
          v-for="card in cards"
          :key="card.title"
          :cols="card.flex"
        >
          <v-card>
            <v-img
              :src="card.src"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="240px"
            >
              <v-card-title v-text="card.title"></v-card-title>
            </v-img>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  
  <!-- ============================================================================================ -->
  <v-card class="pa-3" >
    <v-card-title class="text-h5 font-weight-black">
    금주의 레시피
  </v-card-title>
    <v-row>
      <v-col>
        <v-sheet
            class="mx-auto"
            elevation="5"
            width="100%"
            height="260"
          >
            <v-slide-group
              v-model="model"
              class="pa-3"
              center-active
              show-arrows
            >
              <v-slide-item
                v-for="n in 5"
                :key="n"
                v-slot="{ active, toggle }"
              >              
                <v-card
                  :color="active ? 'primary' : 'grey lighten-1'"
                  class="ma-4"
                  height="200"
                  width="300"
                  @click="toggle"
                >
                  <v-row
                    class="fill-height"
                    align="center"
                    justify="center"
                  >
                    <v-scale-transition>
                      <h3 v-if="active" color="white">
                        {{n}}번 요리 재료들
                      </h3>
                       <h3 v-if-else="active" color="white">
                        요리{{n}}
                      </h3>
                    </v-scale-transition>
                    
                  </v-row>
                  <p class="font-weight-black text-center" >음식이름{{n}}</p>
                </v-card>
              </v-slide-item>
           
            </v-slide-group>
            
        </v-sheet>
      </v-col>
      </v-row>
      
     </v-card>
     
      <!-- ============================================================================================ -->
<v-card class="pa-3" >
    <v-card-title class="text-h5 font-weight-black">
    유튜브 레시피
  </v-card-title>
    <v-row >
      <v-col tile align="center">
         <youtube class="youtube"
            :height= "200"
            :width= "300"  
            :video-id= videoId[0]
            :player-vars="playerVars"
            @ready="ready"
            @playing="playing"
            @ended="ended"
            @error="error"
            ref="youtube" />
            <v-card-title class="text-center justify-center font-weight-black" >한식</v-card-title>
            <v-card-subtitle >달걀볶음밥</v-card-subtitle>
            
      </v-col>
      
        <v-col align="center" >
            <youtube class="youtube"
              :height= 200
              :width= 300  
              :video-id = videoId[2]
              :player-vars="playerVars"
              @ready="ready"
              @playing="playing"
              @ended="ended"
              @error="error"
              ref="youtube" />
              <v-card-title class= "text-center justify-center font-weight-black">양식</v-card-title>
              <v-card-subtitle class="font-content">각국 면 요리</v-card-subtitle>
              
        </v-col>
        <v-col tile
      align="center"  >
         <youtube class="youtube"
            :height= "200"
            :width= "300"  
            :video-id= videoId[1]
            :player-vars="playerVars"
            @ready="ready"
            @playing="playing"
            @ended="ended"
            @error="error"
            ref="youtube" />
            <v-card-title class=" text-center justify-center font-weight-black">디저트</v-card-title>
            <v-card-subtitle >뱅쇼</v-card-subtitle>
            
        </v-col>
      </v-row>
     </v-card>
  </v-container>
</template>

<script>
  export default {
  name: 'Index',
  components:{
  },
  data: () => ({
      length: 3,
      onboarding: 0,
      videoId: ['kR77WlHRZrs','dQnjf9ouGgk','uYapP-gOAVU'],
      cards: [
      { title: 'R', src: 'https://cdn.pixabay.com/photo/2015/09/21/14/23/supermarket-949912_1280.jpg', flex: 12 }
    ],
    // src="./assets/Logo.jpg
    }),
    computed: {
        playerVars() {
          return {
            //controls: 0,
            player3: Object,
            rel: 0,
            autoplay: 0,
            enablejsapi: 1,
            fs: 0,
            playsinline: 1,
            ivLoadPolicy2: 1,
            //playlist: this.videoId,
            //muted: 1,
            //loop: 1,
            start: this.start,
            end: this.end
          };
        },
      },
    methods: {
      ready(){},
      playing(){
        this.$refs.youtube.player.playVideo()
      },
      ended(){},
      error(){},
      next () {
        this.onboarding = this.onboarding + 1 === this.length
          ? 0
          : this.onboarding + 1
      },
      prev () {
        this.onboarding = this.onboarding - 1 < 0
          ? this.length - 1
          : this.onboarding - 1
      },
    },
}
</script>

<style scoped>
</style>