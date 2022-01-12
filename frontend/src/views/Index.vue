<template>
   <v-container >
      <v-card
    color="secondary"
    flat
    tile
  >
    <v-window v-model="onboarding">
      <v-window-item
        v-for="n in length"
        :key="`card-${n}`"
      >
        <v-card
          color="transparent"
          height="200"
        >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
            <v-card-text class="text-center">
              {{n}}
            </v-card-text>
          </v-row>
        </v-card>
      </v-window-item>
    </v-window>

    <v-card-actions class="justify-space-between">
      <v-btn
        text
        @click="prev"
      >
        <v-icon>mdi-chevron-left</v-icon>
      </v-btn>
      <v-item-group
        v-model="onboarding"
        class="text-center"
        mandatory
      >
        <v-item
          v-for="n in length"
          :key="`btn-${n}`"
          v-slot="{ active, toggle }"
        >
          <v-btn
            :input-value="active"
            icon
            @click="toggle"
          >
            <v-icon small>mdi-record</v-icon>
          </v-btn>
        </v-item>
      </v-item-group>
      <v-btn
        text
        @click="next"
      >
        <v-icon>mdi-chevron-right</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
  
  
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
          >
            <v-slide-group
              v-model="model"
              class="pa-3"
              center-active
              show-arrows
            >
              <v-slide-item
                v-for="n in 10"
                :key="n"
                v-slot="{ active, toggle }"
              >              
                <v-card
                  :color="active ? 'primary' : 'grey lighten-1'"
                  class="ma-4"
                  height="200"
                  width="125"
                  @click="toggle"
                >
                  <v-row
                    class="fill-height"
                    align="center"
                    justify="center"
                  >
                    <v-scale-transition>
                      <h3 v-if="active" color="white">
                        재료
                      </h3>
                       <h3 v-if-else="active" color="white">
                        {{n}}
                      </h3>
                    </v-scale-transition>
                  </v-row>
                </v-card>
                
              </v-slide-item>
           
            </v-slide-group>
            
  </v-sheet>
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
    }),

    methods: {
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
