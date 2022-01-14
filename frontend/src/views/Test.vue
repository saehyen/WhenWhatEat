<template>
  <div class="hello">
    {{ recipeList }}
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',
  data() {
    return {
      recipeList: [],
    };
  },
  props: {
    msg: String,
  },
  created() {
    this.getRecipeList();
  },
  methods: {
    getRecipeList() {
      axios.post('http://localhost:9999/recipe/get-recipe-list.do')
        .then((response) => {
          if (response.data.success) {
            console.log(response.data.result);
            this.recipeList = response.data.result;
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
 button{background-color : silver;}
</style>