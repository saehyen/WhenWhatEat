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
  getItem(){
        axios.get("/api/noticelist")
        .then((response) => {
            this.data = response.data;  
            console.log(this.data)
        })
        .catch(function(error) {
            console.log(error);
        });
    }
  },
  created(){
    this.getItem();
  }
  

}
</script>

<style scoped>

</style>
