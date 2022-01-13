<template>
   <v-container >
    <button>Test</button>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
    name: 'Recipe',
    data(){
        return{
            baseUrl:'http://localhost:9999'
            
        }
    },
    methods :{
        test(){
            axios.post(`http://localhost:9999/testurl`)
            .then((response)=>{
                console.log(response.data);
                if(response.status === 200){
                }else{
                    alert(response)
                    alert("통신에러");
                }
            }).catch((err)=>{
                alert(err);
                console.log(err);
                alert("예외 에러");
            })
        }
    }
}
</script>

<style scoped>
 button{background-color : silver;}
</style>