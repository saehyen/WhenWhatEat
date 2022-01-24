<template>

<div>
  <v-container>
    BoardTest
  </v-container>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data(){
    return{
    }
  },

  methods:{
    view(data){
      console.log(data)
      this.$router.push({
        name:"detail",
        query :{body: data.content,
                id: data.noticeIdx,
                title: data.title,
                views: data.views,
                content: data.content}
      })
    },
  create(){
    console.log('hi')
  },
  getItem(){
      const page = 0;
        axios.get("/api/noticelist")
        .then((response) => {
            this.data = response.data;  
            console.log(this.data)

        })
    },
  },
  created(){
    this.getItem();
  }
  

}
</script>

<style scoped>

</style>
