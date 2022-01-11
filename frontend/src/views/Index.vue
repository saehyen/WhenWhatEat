<template>
  <div class="index">
    <div class="banner"><img src="../assets/mainbanner.jpg" alt="배너"></div>
    <div class="wrap">
        <div class="thisweek">
            <h2> 금주의 레시피</h2>
            <div class="hooperwrap">
                <div class="todo"> Todo </div>
                <!-- <hooper :infiniteScroll="true" :wheelControl="false" :hoverPause="false" :mouseDrag="false" :autoPlay="true" :playSpeed="3000" :itemsToShow="6" class="pahooper">
                    <slide v-for="palist in palists" v-bind:key="palist">
                        <div class="palist">
                            <a href="#none"><img :src="require(`@/assets/img/${palist.img}`)"></a>
                        </div>
                    </slide>
                </hooper> -->
           </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Index',
  components:{
  },
  data(){
  }
}
</script>

<style scoped>
.index .banner{width : 100%; max-width:1400px; margin : 0 auto;}
.index .banner img{width : 100%;height: 20vh;}
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
.hooperwrap .todo {height: 300px; background-color: silver;}
.swiper-slide img {display: block; width: 100%; height: 85%;}
</style>
