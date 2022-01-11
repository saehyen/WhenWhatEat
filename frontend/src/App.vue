<template>
  <div id="app">
    <Header/>
    <router-view :key="frontend/src/router"></router-view>
    <Footer/>
  </div>  
</template>

<script>
import Header from './components/common/Header'; //import 헤더 추가
import Footer from './components/common/Footer'; //import 풋터 추가

export default {
  name: 'App',
  components: {
     Header          //헤더 컴포넌트 추가
    ,Footer  
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}

</style>
