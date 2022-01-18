<template>
   <v-container >
       <v-card>
          <v-card-title> 
              관리자페이지 ( 히든 페이지 )
          </v-card-title>
          <v-row>
      <v-btn
        color="primary darken-3"
        class="ma-8"
        dark
        @click="dialog2 = true"
      > 
         <v-card-title > 메인 홈페이지 유튜브 변경 </v-card-title>
      </v-btn>
     <v-dialog
        align="center"
        v-model="dialog2"
        max-width="315px"
      >
        <v-card>
          <v-card-title color="primary" >
            메인 홈페이지 유튜브 변경
          </v-card-title>
          <v-card-text>
              <div>
    <v-combobox
              v-model="selingredient"
              :items="select"
              label="바꿀 유튜브"
              outlined
              dense
              style="width:280px"
            ></v-combobox>
    <v-text-field label="유튜브 주소"></v-text-field>
    <v-text-field label="제목"></v-text-field>
    <v-text-field label="키워드"></v-text-field>
  </div>
          </v-card-text>
          <v-card-actions>
            <v-btn
              color="primary darken-3"
              text
              @click="addingredient()"
            >
              변경
            </v-btn>
             <v-btn
              color="primary darken-3"
              text
              @click="dialog2 = false"
            >
              닫기
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
          </v-row>
       </v-card>
    </v-container>
</template>

<script>
export default {
  name: 'Admin',
  data () {
      return {
        dialog2: false,
        select :['1번 유튜브','2번 유튜브','3번 유튜브']
      }
  },
   methods:{
    addingredient(){
      this.cards.append(cards.length()+1,this.selingredient.text,"",this.picker);
      this.dialog2= false;
        },
    }
}
</script>

<style scoped>
</style>